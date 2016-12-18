package com.data;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;

import org.hibernate.annotations.Proxy;
@Proxy(lazy = false)
public abstract class Template {
	
	private String id;
	private HashMap<String,String> templates;
	private HashMap<String,List<String>> keywords;
	
	public Template(){
		this.id = UUID.randomUUID().toString();
		templates = new HashMap<String,String>();
		keywords = new HashMap<String,List<String>>();
	}
	
	public void addTemplatePart(String key,String template, List<String> keys){
		templates.put(key, template);
		keywords.put(key,keys);
	}
	
	public HashMap<String, ?>[] getTemplate(){
		return new HashMap[]{templates, keywords};
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
