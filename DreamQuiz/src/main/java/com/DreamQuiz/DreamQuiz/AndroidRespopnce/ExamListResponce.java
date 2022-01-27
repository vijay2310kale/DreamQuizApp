package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;

import com.DreamQuiz.DreamQuiz.entity.Examdetails;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExamListResponce {

	
	
	private String Message; 
	private String status;
	List<Examdetails> Examdetails;
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
	public List<Examdetails> getExamdetails() {
		return Examdetails;
	}
	public void setExamdetails(List<Examdetails> examdetails) {
		Examdetails = examdetails;
	}
	
	
	
}
