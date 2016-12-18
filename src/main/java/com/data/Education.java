package com.data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

@XmlRootElement
@Entity
@Table(name = "education")
@Proxy(lazy = false)
public class Education {
	
	public static String URL = "/educations";
	
	public Education(String uid){
		this();
		this.parentId = uid;
	}
	
	public Education(){
		this.id = UUID.randomUUID().toString();
	}
	
	private String id;
	private String parentId;
	private String start;
	private String end;
	private String institute;
	private String graduation;
	private String degree;

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
	public void setParentId(String parendId) {
		this.parentId = parendId;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
}
