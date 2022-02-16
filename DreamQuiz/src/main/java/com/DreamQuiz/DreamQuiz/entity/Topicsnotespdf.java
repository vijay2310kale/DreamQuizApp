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


public class Topicsnotespdf {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long pid;
	
	@Column(name = "categoryname") 
	private String categoryname;
 
 @Column(name = "title") 
	private String title;
 
 @Column(name = "descripiton") 
	private String descripiton;
 
 @Column(name = "pdffile") 
	private String pdffile;
 
 
 @Column(name = "topicid") 
	private String topicid;

 
 @Column(name = "thumbnail") 
	private String thumbnail;


public Long getPid() {
	return pid;
}


public void setPid(Long pid) {
	this.pid = pid;
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


public String getThumbnail() {
	return thumbnail;
}


public String getTopicid() {
	return topicid;
}


public void setTopicid(String topicid) {
	this.topicid = topicid;
}


public void setThumbnail(String thumbnail) {
	this.thumbnail = thumbnail;
}




}
