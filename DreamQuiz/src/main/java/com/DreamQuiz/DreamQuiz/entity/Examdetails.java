package com.DreamQuiz.DreamQuiz.entity;

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
public class Examdetails {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eid;
	
	 @Column(name = "examname") 
		private String examname;
	 
	 @Column(name = "examurl") 
		private String examurl;
	 
	 @Column(name = "examgovfee") 
		private String examgovfee;
	 
	 @Column(name = "examformfee") 
		private String examformfee;
	 
	 @Column(name = "lastdate") 
		private String lastdate;	
	 
	 @Column(name = "datetimespan") 
		private String datetimespan;

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getExamurl() {
		return examurl;
	}

	public void setExamurl(String examurl) {
		this.examurl = examurl;
	}

	public String getExamgovfee() {
		return examgovfee;
	}

	public void setExamgovfee(String examgovfee) {
		this.examgovfee = examgovfee;
	}

	public String getExamformfee() {
		return examformfee;
	}

	public void setExamformfee(String examformfee) {
		this.examformfee = examformfee;
	}

	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public String getDatetimespan() {
		return datetimespan;
	}

	public void setDatetimespan(String datetimespan) {
		this.datetimespan = datetimespan;
	}	
	 
	 
	 
	

}
