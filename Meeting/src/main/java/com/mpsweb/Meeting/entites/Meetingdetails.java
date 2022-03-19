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
public class Meetingdetails {
	

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private long mid;
	
	@Column(name = "meetingid") 
	private String meetingid;
	
	@Column(name = "meetingname") 
	private String meetingname;
	
	
	@Column(name = "mpassword") 
	private String mpassword;
	
	@Column(name = "status") 
	private String status;

	
	
	

	@Column(name="datetimespan")
	 private String datetimespan;
	 
	 
	 
	public String getDatetimespan() {
		return datetimespan;
	}

	public void setDatetimespan(String datetimespan) {
		this.datetimespan = datetimespan;
	}

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public String getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

	public String getMeetingname() {
		return meetingname;
	}

	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 public String getMpassword() {
			return mpassword;
		}

		public void setMpassword(String mpassword) {
			this.mpassword = mpassword;
		}
}
