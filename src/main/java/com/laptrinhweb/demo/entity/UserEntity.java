package com.laptrinhweb.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//model class
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String passWord;
	@Column(name = "email")
	private String email;
	// @Column(name = "enabled")
	// private Boolean enabled;
	// @Column(name = "fullname")
	// private String fullName;
	// @Column(name = "gender")
	// private Boolean gender;
	// @Column(name = "birthday")
	// private Date birthday;
	// @Column(name = "address")
	// private String address;
	// @Column(name = "telephone")
	// private String telephone;
	
	// @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	// private Set<User_Role> userRoles;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(String userName, String passWord, String email) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
	}

	// public UserEntity(Long id, String userName, String passWord, Boolean enabled, String fullName, Boolean gender,
	// 		Date birthday, String address, String email, String telephone) {
	// 	super();
	// 	this.id = id;
	// 	this.userName = userName;
	// 	this.passWord = passWord;
	// 	this.enabled = enabled;
	// 	this.fullName = fullName;
	// 	this.gender = gender;
	// 	this.birthday = birthday;
	// 	this.address = address;
	// 	this.email = email;
	// 	this.telephone = telephone;
	// }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// public Boolean getEnabled() {
		// 	return enabled;
		// }

	// public void setEnabled(Boolean enabled) {
	// 	this.enabled = enabled;
	// }

	// public String getFullName() {
	// 	return fullName;
	// }

	// public void setFullName(String fullName) {
	// 	this.fullName = fullName;
	// }

	// public Boolean getGender() {
	// 	return gender;
	// }

	// public void setGender(Boolean gender) {
	// 	this.gender = gender;
	// }

	// public Date getBirthday() {
	// 	return birthday;
	// }

	// public void setBirthday(Date birthday) {
	// 	this.birthday = birthday;
	// }

	// public String getAddress() {
	// 	return address;
	// }

	// public void setAddress(String address) {
	// 	this.address = address;
	// }


	// public String getTelephone() {
	// 	return telephone;
	// }

	// public void setTelephone(String telephone) {
	// 	this.telephone = telephone;
	// }
	
}

