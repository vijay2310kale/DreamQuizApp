package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;

import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubjectListResponce {
	
	private String Message; 
	private String status;
	List<Subject> Subjectlist;
	
	
	
	
	
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
	public List<Subject> getSubjectlist() {
		return Subjectlist;
	}
	public void setSubjectlist(List<Subject> subjectlist) {
		Subjectlist = subjectlist;
	}
	

	
	
	
}
