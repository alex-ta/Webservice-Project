package com.data.wrapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.data.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class User_Wrapper {

	public User_Wrapper(){}
	
	public User_Wrapper(User user){
		this();
		if(user != null){
		this.uuid = user.getUuid();
		this.username = user.getId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.title = user.getTitle();
		this.gender = user.getGender();
		this.street = user.getStreet();
		this.housenumber = user.getHousenumber(); 
		this.plz = user.getPlz();
		this.city = user.getCity();
		this.country = user.getCountry();
		this.nationality = user.getNationality();
		this.phone = user.getPhone();
		this.mail = user.getMail();
		this.birthdate = user.getBirthdate();
		this.birthplace = user.getBirthplace();
		this.image = user.getImage();
		}
	}

	
	public User join(User user){
		if(this.getUsername() != null)
		user.setId(this.getUsername());
		if(this.getName() != null)
		user.setName(this.getName());
		if(this.getSurname() != null)
		user.setSurname(this.getSurname());
		if(this.getTitle() != null)
		user.setTitle(this.getTitle());
		if(this.getGender() != null)
		user.setGender(this.getGender());
		if(this.getStreet() != null)
		user.setStreet(this.getStreet());
		if(this.getHousenumber() != null)
		user.setHousenumber(this.getHousenumber());
		if(this.getPlz() != null)
		user.setPlz(this.getPlz());
		if(this.getCity() != null)
		user.setCity(this.getCity());
		if(this.getCountry() != null)
		user.setCountry(this.getCountry());
		if(this.getNationality() != null)
		user.setNationality(this.getNationality());
		if(this.getPhone() != null)
		user.setPhone(this.getPhone());
		if(this.getMail() != null)
		user.setMail(this.getMail());
		if(this.getBirthdate() != null)
		user.setBirthdate(this.getBirthdate());
		if(this.getBirthplace() != null)
		user.setBirthplace(this.getBirthplace());
		if(this.getImage() != null)
		user.setImage(this.getImage());
		return user;
	}
	

	
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The urlid which identifies an existing user object", required = true)
    @NotNull
    @Size(max=200)
 	private String username;
	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The urlid which identifies an existing user object", required = true)
	private String uuid;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of an user", required = true)
	private String name;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The surname of an user", required = true)
	private String surname;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The title of an user", required = true)
	private String title;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The gender of an user (male|female)", required = true)
	private String gender;
	
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The street of the users address", required = true)
	private String street;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The housenumber of the users address", required = true)
	private String housenumber;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The plz of the users address", required = true)
	private String plz;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The city of the users address", required = true)
	private String city;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The country of the users address", required = true)
	private String country;
 	@NotNull
    @Size(max=200)
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The nationality of the user", required = true)
	private String nationality;
 	
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The users phonenumber", required = true)
	private String phone;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The users email address", required = true)
	private String mail;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The users birthdate", required = true)
	private String birthdate;
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The users birthplace", required = true)
	private String birthplace;
 	
 	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The users image", required = true)
	private String image;
	
 	
 	public String getUsername() {
		return username;
 	}
	public void setUsername(String username) {
		this.username = username;
	}
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
}
