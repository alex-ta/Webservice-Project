package dao;
import java.util.List;
import org.hibernate.Session;

import boot.Database;
import data.User;

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
		O o = activeSession.load(getDaoClass(), k);
		activeSession.getTransaction().commit();
		closeSession();
		return o;
		
	}
	
	public List<O> getAll(){
		activeSession = base.getSession();
		activeSession.beginTransaction();
		// Deprecated in Favour of JPA Query
		List<O> list = activeSession.createCriteria(User.class).list();
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
