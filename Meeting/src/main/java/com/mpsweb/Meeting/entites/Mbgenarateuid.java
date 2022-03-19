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
public class Mbgenarateuid {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private long priid;
	
	
	@Column(name = "userid") 
	private String userid;
	
	
	@Column(name = "username") 
	private String username;
	
	@Column(name = "bwebsite") 
	private String bwebsite;
	
	@Column(name = "whatsupno") 
	private String whatsupno;
	
	@Column(name = "genid") 
	private String genid;
	
	@Column(name = "gpassword") 
	private String gpassword;
	
	@Column(name = "companyname") 
	private String companyname;
	
	@Column(name="datetimespan")
	 private String datetimespan;

	public long getMid() {
		return priid;
	}

	public void setMid(long mid) {
		this.priid = mid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBwebsite() {
		return bwebsite;
	}

	public void setBwebsite(String bwebsite) {
		this.bwebsite = bwebsite;
	}

	public String getWhatsupno() {
		return whatsupno;
	}

	public void setWhatsupno(String whatsupno) {
		this.whatsupno = whatsupno;
	}

	public String getGenid() {
		return genid;
	}

	public void setGenid(String genid) {
		this.genid = genid;
	}

	public String getGpassword() {
		return gpassword;
	}

	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getDatetimespan() {
		return datetimespan;
	}

	public void setDatetimespan(String datetimespan) {
		this.datetimespan = datetimespan;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public long getPriid() {
		return priid;
	}

	public void setPriid(long priid) {
		this.priid = priid;
	}

}
 