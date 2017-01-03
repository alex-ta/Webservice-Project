package com.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.boot.Database;

public abstract class Dao <O> {
	
	protected Database base;
	protected Session activeSession;
	
	abstract Class<O> getDaoClass();
	abstract O setPrimaryKey(O o);
	
	
	protected Dao(){
		base = Database.getDatabase();
	}
	
	public O getByUuid(String uuid){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		criteria.where(builder.equal(root.get("uuid"), uuid));
		List<O> list = activeSession.createQuery(criteria).getResultList(); //  return null ??
		activeSession.getTransaction().commit();
		if(list.size() > 0){
			return list.get(0);
		} else {
			return null;
		}
	}
	
	public O getById(Object k){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		criteria.where(builder.equal(root.get("id"), k));
		List<O> list = activeSession.createQuery(criteria).getResultList();
		activeSession.getTransaction().commit();
		if(list.size() > 0){
			return list.get(0);
		} else {
			return null;
		}	
	}
	
	public List<O> getAll(){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		// Deprecated in Favour of JPA Query
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		List<O> list = activeSession.createQuery(criteria).getResultList();
		activeSession.getTransaction().commit();
		return list;
	}

	public void save (O o){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		setPrimaryKey(o);
		activeSession.saveOrUpdate(o);
		activeSession.getTransaction().commit();
		closeSession();
	}
	
	public void delete(String k){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		O o = activeSession.load(getDaoClass(), k);
		activeSession.getTransaction().commit();
		activeSession.beginTransaction();
		activeSession.delete(o);
		activeSession.getTransaction().commit();
		closeSession();
	}
	
	public void delete(O o){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		activeSession.delete(o);
		activeSession.getTransaction().commit();
		closeSession();
	}
	
	public void closeSession(){
		if(activeSession.isConnected()){
			activeSession.close();
		}
	}

}
