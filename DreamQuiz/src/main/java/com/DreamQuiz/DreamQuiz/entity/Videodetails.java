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

public class Videodetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vid;
	
	
	
	 @Column(name = "vcategoryname") 
		private String vcategoryname;
	 
	 @Column(name = "vtitle") 
		private String vtitle;
	 
	 @Column(name = "vdescripiton") 
		private String vdescripiton;
	 
	 @Column(name = "vlink") 
		private String vlink;
	 
	 @Column(name = "vpostby") 
		private String vpostby;	
	 
	 @Column(name = "vpostdate") 
		private String vpostdate;	 
	 
	 @Column(name = "vthumbnail") 
		private String vthumbnail;	 
	 
	 @Column(name = "vauthorname") 
		private String vauthorname;

	public long getVid() {
		return vid;
	}

	public void setVid(long vid) {
		this.vid = vid;
	}

	public String getVcategoryname() {
		return vcategoryname;
	}

	public void setVcategoryname(String vcategoryname) {
		this.vcategoryname = vcategoryname;
	}

	public String getVtitle() {
		return vtitle;
	}

	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}

	public String getVdescripiton() {
		return vdescripiton;
	}

	public void setVdescripiton(String vdescripiton) {
		this.vdescripiton = vdescripiton;
	}

	public String getVlink() {
		return vlink;
	}

	public void setVlink(String vlink) {
		this.vlink = vlink;
	}

	public String getVpostby() {
		return vpostby;
	}

	public void setVpostby(String vpostby) {
		this.vpostby = vpostby;
	}

	public String getVpostdate() {
		return vpostdate;
	}

	public void setVpostdate(String vpostdate) {
		this.vpostdate = vpostdate;
	}

	public String getVthumbnail() {
		return vthumbnail;
	}

	public void setVthumbnail(String vthumbnail) {
		this.vthumbnail = vthumbnail;
	}

	public String getVauthorname() {
		return vauthorname;
	}

	public void setVauthorname(String vauthorname) {
		this.vauthorname = vauthorname;
	}
	 
	 

	}
