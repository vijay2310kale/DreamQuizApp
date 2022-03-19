package com.mpsweb.Meeting.Responce;

import java.util.List;

import com.mpsweb.Meeting.entites.Banner;
import com.mpsweb.Meeting.entites.Mbgenarateuid;
import com.mpsweb.Meeting.entites.Meetingdetails;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MbGenUidResponce {
	
	
	
	private String message;
	private String status;
	private String genid;
	
	
	List<Mbgenarateuid> getallmyid;
		
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
	public String getGenid() {
		return genid;
	}
	public void setGenid(String genid) {
		this.genid = genid;
	}
	public List<Mbgenarateuid> getGetallmyid() {
		return getallmyid;
	}
	public void setGetallmyid(List<Mbgenarateuid> getallmyid) {
		this.getallmyid = getallmyid;
	}
	
	
		

}
