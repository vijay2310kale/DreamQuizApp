//package com.DreamQuiz.DreamQuiz.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Lob;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Doc {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private Long id;
//	private String docname;
//	private String doctype;
//	@Lob
//	private byte[] data;
//	public Doc() {
//		super();
//	}
//	public Doc(String docname, String doctype, byte[] data) {
//		super();
//		this.docname = docname;
//		this.doctype = doctype;
//		this.data = data;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getDocname() {
//		return docname;
//	}
//	public void setDocname(String docname) {
//		this.docname = docname;
//	}
//	public String getDoctype() {
//		return doctype;
//	}
//	public void setDoctype(String doctype) {
//		this.doctype = doctype;
//	}
//	public byte[] getData() {
//		return data;
//	}
//	public void setData(byte[] data) {
//		this.data = data;
//	}
//
//}
