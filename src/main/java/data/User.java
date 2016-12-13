package data;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "user")
public class User {

	private String id;
	
	@Id
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

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
	
	
	// somehow not working
	@Transient
	private List<Job> jobs;
	@Transient
	private List<Skill> skills;
	@Transient
	private List<Education> educationSkills;
	@Transient
	private List<String> hobbies;
		
	private Image image;

	public User () {
		this.jobs = new ArrayList<Job>();
		this.skills = new ArrayList<Skill>();
		this.educationSkills = new ArrayList<Education>();
		this.hobbies = new ArrayList<String>();
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

	public List<Job> getJobs() {
		return jobs;
	}

	public void addJob(Job job) {
		this.jobs.add(job);
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void addSkill(Skill l) {
		this.skills.add(l);
	}

	public List<Education> getEducationSkills() {
		return educationSkills;
	}

	public void addEducation(Education education) {
		this.educationSkills.add(education);
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void addHobby(String hobby) {
		this.hobbies.add(hobby);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
