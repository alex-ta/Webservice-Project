package com.data.wrapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.data.Education;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


@XmlRootElement
public class Education_Wrapper {
	
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The start date of an education", required = true)
	private String start;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The end date of an education", required = true)
	private String end;
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The institute that provided the education", required = true)
	private String institute;
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The type of graduation gained", required = true)
	private String graduation;
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The reached degree gained", required = true)
	private String degree;
    @JsonProperty(required = false)
    @ApiModelProperty(notes = "The urlid which identifies an existing education object", required = true)
    @NotNull
    @Size(max=200)
    private String user;
	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The urlid which identifies an existing user object", required = true)
	private String uuid;
	
	public Education_Wrapper(){}
	
	public Education_Wrapper(Education e){
		this();
		if(e != null){
		this.start = e.getStart();
		this.end = e.getEnd();
		this.institute = e.getInstitute();
		this.graduation = e.getGraduation();
		this.degree = e.getDegree();
		this.user = e.getParentId();
		this.uuid = e.getUuid();
		}
	}

	public Education getEducation(Education education){
		if(this.getStart() != null)
		education.setStart(this.getStart());
		if(this.getEnd() != null)
		education.setEnd(this.getEnd());
		if(this.getInstitute() != null)
		education.setInstitute(this.getInstitute());
		if(this.getGraduation() != null)
		education.setGraduation(this.getGraduation());
		if(this.getDegree() != null)
		education.setDegree(this.getDegree());
		if(this.getUser() != null)
		education.setParentId(this.getUser());
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}	
}
