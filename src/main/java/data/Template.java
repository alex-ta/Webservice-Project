package data;

import java.util.HashMap;
import java.util.List;

public abstract class Template {
	
	private HashMap<String,String> templates;
	private HashMap<String,List<String>> keywords;
	
	
	public Template(){
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
	
}
