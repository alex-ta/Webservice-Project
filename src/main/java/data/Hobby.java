package data;

// jndi Datasource
// tomcat realm


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

@XmlRootElement
@Entity
@Table(name = "hobby")
@Proxy(lazy = false)
public class Hobby {
	
	public static String URL = "/hobbies";
	
	public Hobby(String uid){
		this();
		this.parentId = uid;
	}
	
	Hobby(){
		this.id = UUID.randomUUID().toString();
	}
	
	private String id;
	private String parentId;
	private String name;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getParentId() {
		return parentId;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
