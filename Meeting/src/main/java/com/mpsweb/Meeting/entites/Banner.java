package com.mpsweb.Meeting.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Banner {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long bid;
	
	
	@Column(name = "bannerid") 
	private String bannerid;
	
	 @Column(name = "filetype") 
		private String filetype;
	 
	 @Column(name = "filepath") 
		private String filepath;


	public Long getBid() {
		return bid;
	}


	public void setBid(Long bid) {
		this.bid = bid;
	}


	public String getFilepath() {
		return filepath;
	}


	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}


	public String getBannerid() {
		return bannerid;
	}


	public void setBannerid(String bannerid) {
		this.bannerid = bannerid;
	}



	
}
