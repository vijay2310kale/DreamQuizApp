package com.mpsweb.Meeting.Responce;

import java.util.List;

import com.mpsweb.Meeting.entites.Banner;
import com.mpsweb.Meeting.entites.Meetingdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetBannerResponce {
	
	
	private String Message; 
	private String status;
	
	
	List<Banner> GetAllBanner;


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Banner> getGetAllBanner() {
		return GetAllBanner;
	}


	public void setGetAllBanner(List<Banner> getAllBanner) {
		GetAllBanner = getAllBanner;
	}

}
