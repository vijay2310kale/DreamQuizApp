package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;

import com.DreamQuiz.DreamQuiz.entity.Topicsnotespdf;

public class TopicNotesRepsponce {
	
	
	private String Message; 
	private String status;
	
	List<Topicsnotespdf> TopicNotesRepsponce;

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

	public List<Topicsnotespdf> getTopicNotesRepsponce() {
		return TopicNotesRepsponce;
	}

	public void setTopicNotesRepsponce(List<Topicsnotespdf> topicNotesRepsponce) {
		TopicNotesRepsponce = topicNotesRepsponce;
	}

}
