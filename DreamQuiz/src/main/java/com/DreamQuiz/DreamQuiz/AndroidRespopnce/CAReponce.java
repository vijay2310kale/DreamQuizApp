package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;

import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CAReponce {
	
	
	private String Message; 
	private String status;
	
	List<CurrentAffairs> caresponce;

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

	public List<CurrentAffairs> getCaresponce() {
		return caresponce;
	}

	public void setCaresponce(List<CurrentAffairs> caresponce) {
		this.caresponce = caresponce;
	}


}
