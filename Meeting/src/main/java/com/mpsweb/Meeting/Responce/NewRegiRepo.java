package com.mpsweb.Meeting.Responce;

import java.util.List;



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
	private String mjoinigname1;
	private String mjoinigname2;
	public String getMjoinigname1() {
		return mjoinigname1;
	}

	public void setMjoinigname1(String mjoinigname1) {
		this.mjoinigname1 = mjoinigname1;
	}

	public String getMjoinigname2() {
		return mjoinigname2;
	}

	public void setMjoinigname2(String mjoinigname2) {
		this.mjoinigname2 = mjoinigname2;
	}

	public String getMjoinigname3() {
		return mjoinigname3;
	}

	public void setMjoinigname3(String mjoinigname3) {
		this.mjoinigname3 = mjoinigname3;
	}

	private String mjoinigname3;
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
