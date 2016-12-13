package database;
import java.util.List;

import org.hibernate.Session;

import data.User;

public abstract class Dao <O> {
	
	private Database base;

	abstract Class<O> getDaoClass();
	abstract O setPrimaryKey(O o);
	
	
	protected Dao(){
		base = Database.getDatabase();
	}
	
	public O get(String k){
		Session session = base.getSession();
		session.beginTransaction();
		O o = session.load(getDaoClass(), k);
		session.getTransaction().commit();
		session.close();
		return o;
		
	}
	
	public List<O> getAll(){
		Session session = base.getSession();
		session.beginTransaction();
		// Deprecated in Favour of JPA Query
		List<O> list = session.createCriteria(User.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
		}
	
	public void save (O o){
		Session session = base.getSession();
		session.beginTransaction();
		setPrimaryKey(o);
		session.persist(o);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(String k){
		Session session = base.getSession();
		session.beginTransaction();
		O o = session.load(getDaoClass(), k);
		session.getTransaction().commit();
		session.beginTransaction();
		session.delete(o);
		session.getTransaction().commit();
		session.close();
	}

}
