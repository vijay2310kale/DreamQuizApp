package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;

import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VideolistResponce {
	
	
	private String Message; 
	private String status;
	
	List<Videodetails> videodetailsresponce;

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

	public List<Videodetails> getVideodetailsresponce() {
		return videodetailsresponce;
	}

	public void setVideodetailsresponce(List<Videodetails> videodetailsresponce) {
		this.videodetailsresponce = videodetailsresponce;
	}

	
}
