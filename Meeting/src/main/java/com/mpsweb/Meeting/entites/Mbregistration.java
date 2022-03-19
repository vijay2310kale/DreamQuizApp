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
public class Mbregistration {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private long uid;
	
	@Column(name = "mobileno") 
	private String mobileno;
	
	@Column(name = "password") 
	private String password;
		
	@Column(name = "userid") 
	private String userid;
	
	
	@Column(name="datetimespan")
	 private String datetimespan;


	public long getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getDatetimespan() {
		return datetimespan;
	}


	public void setDatetimespan(String datetimespan) {
		this.datetimespan = datetimespan;
	}


	
	
	
	
	
}
