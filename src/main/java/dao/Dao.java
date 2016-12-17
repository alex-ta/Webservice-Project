package dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import boot.Database;

public abstract class Dao <O> {
	
	private Database base;
	private Session activeSession;
	
	abstract Class<O> getDaoClass();
	abstract O setPrimaryKey(O o);
	
	
	protected Dao(){
		base = Database.getDatabase();
	}
	
	public O get(String k){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		// Deprecated in Favour of JPA Query
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		criteria.where(builder.equal(root.get("id"), k));
		O list = activeSession.createQuery(criteria).getSingleResult();
		activeSession.getTransaction().commit();
		return list;	
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

	public List<O> getAll(String parentId){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		// Deprecated in Favour of JPA Query
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		criteria.where(builder.equal(root.get("parentId"), parentId));
		List<O> list = activeSession.createQuery(criteria).getResultList();
		activeSession.getTransaction().commit();
		return list;
		}
	
	public O get(String parentId, String id){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		// Deprecated in Favour of JPA Query
		CriteriaBuilder builder = activeSession.getCriteriaBuilder();
		CriteriaQuery<O> criteria = builder.createQuery(getDaoClass());
		Root<O> root = criteria.from(getDaoClass());
		criteria.select(root);
		criteria.where(
				builder.and(
						builder.equal(root.get("parentId"), parentId),
						builder.equal(root.get("id"), id)
						));
		O list = activeSession.createQuery(criteria).getSingleResult();
		activeSession.getTransaction().commit();
		return list;
		}
	
	public void save (O o){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		setPrimaryKey(o);
		activeSession.persist(o);
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
	
	public void closeSession(){
		if(activeSession.isConnected()){
			activeSession.close();
		}
	}

}
