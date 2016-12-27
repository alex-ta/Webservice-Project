package com.data.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User_Wrapper {
	
	private String uuid;
	private String name;
	private String surname;
	private String title;
	private String gender;
	
	private String street;
	private String housenumber;
	private String plz;
	private String city;
	private String country;
	private String nationality;
	
	private String phone;
	private String mail;
	private String birthdate;
	private String birthplace;
	
	private String image;
	private String jobsUrl;
	private String skillUrl;
	private String educationUrl;
	private String hobbyUrl;	
	
	private List<String> jobs;
	private List<String> skills;
	private List<String> educations;
	private List<String> hobbies;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getJobsUrl() {
		return jobsUrl;
	}
	public void setJobsUrl(String jobsUrl) {
		this.jobsUrl = jobsUrl;
	}
	public String getSkillUrl() {
		return skillUrl;
	}
	public void setSkillUrl(String skillUrl) {
		this.skillUrl = skillUrl;
	}
	public String getEducationUrl() {
		return educationUrl;
	}
	public void setEducationUrl(String educationUrl) {
		this.educationUrl = educationUrl;
	}
	public String getHobbyUrl() {
		return hobbyUrl;
	}
	public void setHobbyUrl(String hobbyUrl) {
		this.hobbyUrl = hobbyUrl;
	}
	public List<String> getJobs() {
		return jobs;
	}
	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getEducations() {
		return educations;
	}
	public void setEducations(List<String> educations) {
		this.educations = educations;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

}
