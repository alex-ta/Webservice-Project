package com.data;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import com.data.Roles;

@Entity
@Table(name = "user")
@Proxy(lazy = false)

public class User {
	
	private String uuid;
	private String id;
	private String name;
	private String surname;
	private String title;
	private String gender;
	private String password;
	
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
	
	// bei create ressource zurück
	private String image;
	private List<Job> jobs;
	private List<Skill> skills;
	private List<Education> educations;
	private List<Hobby> hobbies;
	private List<Roles> roles;
	
	public User () {
		this.uuid = UUID.randomUUID().toString();
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	public List<Education> getEducations() {
		return educations;
	}
	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	public List<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	@ElementCollection(targetClass = Roles.class)
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "role_id"))
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	@Id
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
}
