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
public class NewRegiRepo {
	
	
	private String Message; 
	private String status;
	private String loginid;
	private String password;
	private String username;
	
	List<NewRegiRepo> NewRegiRepo;

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

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<NewRegiRepo> getNewRegiRepo() {
		return NewRegiRepo;
	}

	public void setNewRegiRepo(List<NewRegiRepo> newRegiRepo) {
		NewRegiRepo = newRegiRepo;
	}


}
