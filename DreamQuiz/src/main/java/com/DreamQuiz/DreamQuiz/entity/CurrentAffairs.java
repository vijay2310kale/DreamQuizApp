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

public class CurrentAffairs {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long caid;

	 @Column(name = "categoryname") 
		private String categoryname;
	 
	 @Column(name = "title") 
		private String title;
	 
	 @Column(name = "descripiton") 
		private String descripiton;
	 
	 @Column(name = "pdffile") 
		private String pdffile;

	public Long getCaid() {
		return caid;
	}

	public void setCaid(Long caid) {
		this.caid = caid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescripiton() {
		return descripiton;
	}

	public void setDescripiton(String descripiton) {
		this.descripiton = descripiton;
	}

	public String getPdffile() {
		return pdffile;
	}

	public void setPdffile(String pdffile) {
		this.pdffile = pdffile;
	}
	
}
