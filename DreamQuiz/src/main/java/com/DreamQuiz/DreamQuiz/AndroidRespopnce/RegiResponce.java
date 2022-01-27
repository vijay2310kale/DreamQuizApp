package com.DreamQuiz.DreamQuiz.AndroidRespopnce;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegiResponce {
	
	
	private String message;
	private String status;
	private String otp;
	private String user_id;
	
	private List registerlist;

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

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List getRegisterlist() {
		return registerlist;
	}

	public void setRegisterlist(List registerlist) {
		this.registerlist = registerlist;
	}


}
