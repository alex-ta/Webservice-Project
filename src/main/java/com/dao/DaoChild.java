package com.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class DaoChild<O, PID> extends Dao<O>{
	
	public List<O> getAll(PID parentId){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		criteria.where(builder.equal(root.get("parentId"), parentId));
		List<O> list = activeSession.createQuery(criteria).getResultList();
		activeSession.getTransaction().commit();
		return list;
		}
	
	public O get(PID parentId, String uuid){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		criteria.where(
				builder.and(
						builder.equal(root.get("parentId"), parentId),
						builder.equal(root.get("uuid"), uuid)
						));
		List<O> list = activeSession.createQuery(criteria).getResultList();
		activeSession.getTransaction().commit();
		if(list.size() > 0){
			return list.get(0);
		} else {
			return null;
		}
	}

	
	public void delete(PID parentId, String uuid){
		activeSession = base.getSession();
		O o = get(parentId, uuid);
		activeSession.beginTransaction();
		activeSession.delete(o);
		activeSession.getTransaction().commit();
		closeSession();
	}
	
	
}
