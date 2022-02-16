package com.DreamQuiz.DreamQuiz.entity;

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

public class OldPaper {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long opid;

	 @Column(name = "opcategoryname") 
		private String opcategoryname;
	 
	 @Column(name = "optitle") 
		private String optitle;
	 
	 @Column(name = "opdescripiton") 
		private String opdescripiton;
	 
	 @Column(name = "oppdffile") 
		private String oppdffile;
	 
	 
	 @Column(name = "thumbnail") 
		private String thumbnail;
	 
	

	public Long getOpid() {
		return opid;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setOpid(Long opid) {
		this.opid = opid;
	}

	public String getOpcategoryname() {
		return opcategoryname;
	}

	public void setOpcategoryname(String opcategoryname) {
		this.opcategoryname = opcategoryname;
	}

	public String getOptitle() {
		return optitle;
	}

	public void setOptitle(String optitle) {
		this.optitle = optitle;
	}

	public String getOpdescripiton() {
		return opdescripiton;
	}

	public void setOpdescripiton(String opdescripiton) {
		this.opdescripiton = opdescripiton;
	}

	public String getOppdffile() {
		return oppdffile;
	}

	public void setOppdffile(String oppdffile) {
		this.oppdffile = oppdffile;
	}


}
