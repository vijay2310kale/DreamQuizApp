package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;

import com.DreamQuiz.DreamQuiz.entity.OldPaper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OldPaperResponce {
	
	
	
	private String Message; 
	private String status;
	
	List<OldPaper> OldPaperResponce;

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

	public List<OldPaper> getOldPaperResponce() {
		return OldPaperResponce;
	}

	public void setOldPaperResponce(List<OldPaper> oldpaperilst) {
		OldPaperResponce = oldpaperilst;
	}
	
	
	
	
	
}