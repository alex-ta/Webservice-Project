package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

@XmlRootElement
@Entity
@Table(name = "user")
@Proxy(lazy = false)
public class User {

	@Column(name="id")
	private String id;
	
	@Id
	public String getId() {
		return id;
	}
	@Id
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
	private final String jobs;
	@Transient
	private final String skills;
	@Transient
	private final String educationSkills;
	@Transient
	private final String hobbies;
		
	private String image;

	public User () {
		this.jobs = "/user/"+this.getId()+"/jobs";
		this.skills = "/user/"+this.getId()+"/skills";
		this.educationSkills = "/user/"+this.getId()+"/educations";
		this.hobbies = "/user/"+this.getId()+"/hobbies";
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
	
	@Transient
	public String getJobs() {
		return jobs;
	}
	
	@Transient
	public String getSkills() {
		return skills;
	}
	
	@Transient
	public String getEducationSkills() {
		return educationSkills;
	}
	
	@Transient
	public String getHobbies() {
		return hobbies;
	}
	
	public String getImage() {
		return image;
	}
	
	@Transient
	public void setImage(String image) {
		this.image = image;
	}
	
}
