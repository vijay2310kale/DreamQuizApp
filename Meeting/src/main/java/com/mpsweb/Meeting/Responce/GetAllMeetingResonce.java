package com.mpsweb.Meeting.Responce;

import java.util.List;

import com.mpsweb.Meeting.entites.Meetingdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetAllMeetingResonce {
	
	
	private String message;
	private String status;
	
	
	List<Meetingdetails> GetAllMeetingResonce ;


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Meetingdetails> getGetAllMeetingResonce() {
		return GetAllMeetingResonce;
	}


	public void setGetAllMeetingResonce(List<Meetingdetails> getAllMeetingResonce) {
		GetAllMeetingResonce = getAllMeetingResonce;
	}

	

}
