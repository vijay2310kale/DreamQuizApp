package com.mpsweb.Meeting.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewRegister {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private long uid;
		
	@Column(name = "fname") 
	private String fname;
	
	@Column(name = "lname") 
	private String lname;
		
	@Column(name = "loginid") 
	private String loginid;

	@Column(name = "password") 
	private String password;
	
	
	 @Column(name="phone_no")
	 private String phone_no;
	 
	 @Column(name="email")
	 private String email;
	 
	 @Column(name="mjoinigname1")
      private String mjoinigname1;
	
	 @Column(name="mjoinigname2")
		 private String mjoinigname2;
	
	 @Column(name="mjoinigname3")
	 private String mjoinigname3;
	 
	 @Column(name="datetimespan")
	 private String datetimespan;
	 
	 @Column(name="deviceid")
	 private String deviceid;
	 
	 @Column(name="status")
	 private String status;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatetimespan() {
		return datetimespan;
	}

	public void setDatetimespan(String datetimespan) {
		this.datetimespan = datetimespan;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getMjoinigname1() {
		return mjoinigname1;
	}

	public void setMjoinigname1(String mjoinigname1) {
		this.mjoinigname1 = mjoinigname1;
	}

	public String getMjoinigname2() {
		return mjoinigname2;
	}

	public void setMjoinigname2(String mjoinigname2) {
		this.mjoinigname2 = mjoinigname2;
	}

	public String getMjoinigname3() {
		return mjoinigname3;
	}

	public void setMjoinigname3(String mjoinigname3) {
		this.mjoinigname3 = mjoinigname3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
