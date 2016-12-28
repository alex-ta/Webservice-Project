package com.data.wrapper;

import javax.xml.bind.annotation.XmlRootElement;

import com.data.Education;


@XmlRootElement
public class Education_Wrapper {
	
	private String start;
	private String end;
	private String institute;
	private String graduation;
	private String degree;
	private String uuid;
	
	public Education_Wrapper(){}
	
	public Education_Wrapper(Education e){
		this();
		this.start = e.getStart();
		this.end = e.getEnd();
		this.institute = e.getInstitute();
		this.graduation = e.getGraduation();
		this.degree = e.getDegree();
		this.uuid = e.getUuid();
	}
	
	public Education getEducation(){
		Education education = new Education();
		education.setStart(this.getStart());
		education.setEnd(this.getEnd());
		education.setInstitute(this.getInstitute());
		education.setGraduation(this.getGraduation());
		education.setDegree(this.getDegree());
		education.setUuid(this.getUuid());
		return education;
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
		
	
}
