package com.newsblock.api.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.newsblock.api.model.dto.NewUser;
import com.newsblock.api.util.md5;

@Entity
@Table(name = "users_login")
public class UserLogins implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userid;

	@JsonIgnore
	private String password;

	private String fullname;

	private String email;

	private String mobilenumber;

	@Expose(serialize = false)
	private Timestamp lastlogin;

	private int roleid;

	private int createdby;

	@Expose(serialize = false)
	private Timestamp createdon;

	@Expose(serialize = false)
	private Timestamp updatedon;

	private int isactive;

	private int gender;

	private String address;

	private String access_token;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public Timestamp getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public Timestamp getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public Timestamp getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Timestamp updatedon) {
		this.updatedon = updatedon;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public void fromDTO(NewUser userData) {
		this.userid = userData.getUserid();
		this.password = md5.getMd5(userData.getPassword());
		this.fullname = userData.getFullname();
		this.email = userData.getEmail();
		this.mobilenumber = userData.getMobilenumber();
		this.roleid = 100;
		this.createdby = 2;

		Date today = new Date();

		this.createdon = new Timestamp(today.getTime());
		this.updatedon = this.createdon;
		this.isactive = 1;
		this.gender = userData.getGender();
		this.address = userData.getAddress();

	}

}
