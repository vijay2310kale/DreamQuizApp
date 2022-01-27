package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;


import com.DreamQuiz.DreamQuiz.entity.Topics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TopiclistResponce {
	
	
	private String Message; 
	private String status;
	
	List<Topics> topiclist;

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

	public List<Topics> getTopiclist() {
		return topiclist;
	}

	public void setTopiclist(List<Topics> topiclist) {
		this.topiclist = topiclist;
	}
	

}
