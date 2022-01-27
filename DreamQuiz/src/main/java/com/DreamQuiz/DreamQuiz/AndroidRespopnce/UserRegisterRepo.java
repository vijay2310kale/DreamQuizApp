package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import java.util.List;
import java.util.Optional;

import com.DreamQuiz.DreamQuiz.entity.UserRegistration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegisterRepo {
	
	private String Message; 
	private String status;
	
	Optional<com.DreamQuiz.DreamQuiz.entity.UserRegistration> UserRegistration;

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

	public Optional<com.DreamQuiz.DreamQuiz.entity.UserRegistration> getUserRegistration() {
		return UserRegistration;
	}

	public void setUserRegistration(Optional<UserRegistration> alluserlist) {
		UserRegistration = alluserlist;
	}


}
