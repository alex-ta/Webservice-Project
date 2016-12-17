package data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

@XmlRootElement
@Entity
@Table(name = "skills")
@Proxy(lazy = false)
public class Skill {
	
	public static String URL = "/skills";
	
	public Skill(String uid){
		this();
		this.parentId = uid;
	}
	
	Skill(){
		this.id = UUID.randomUUID().toString();
	}
	
	private String collectiveterm;
	private String term;
	private int priority;
	private int ability;
	private String id;
	private String parentId;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParendId() {
		return parentId;
	}
	public void setParendId(String parendId) {
		this.parentId = parendId;
	}
	
	public String getCollectiveterm() {
		return collectiveterm;
	}
	public void setCollectiveterm(String collectiveterm) {
		this.collectiveterm = collectiveterm;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	
}
