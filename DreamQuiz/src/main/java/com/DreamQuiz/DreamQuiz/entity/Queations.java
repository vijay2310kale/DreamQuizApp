package com.DreamQuiz.DreamQuiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Queations {
	
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		  private Long qid;
	      
	     @Column(name = "sid")
	     private Long sid;
	    
	     @Column(name = "tid")
	     private Long tid;
	    
	     @Column(name = "stid")
	     private Long stid;
	    
	    @Column(name = "equeation") 
	     private String equeation;

		@Column(name= "hqueation")
		private String  hqueation ;

		
		@Column(name= "eoptinA")
		private String  eoptionA;

		
		@Column(name= "eoptinB")
		private String  eoptinB ;

		@Column(name= "eoptinC")
		private String  eoptinC ;

		@Column(name= "eoptinD")
		private String  eoptinD ;

		@Column(name= "hoptinA")
		private String  hoptinA ;

		@Column(name= "hoptinB")
		private String  hoptinB ;

		@Column(name= "hoptinC")
		private String  hoptinC ;

		@Column(name= "hoptinD")
		private String  hoptinD ;

		@Column(name= "currectAns")
		private String  currectAns ;

		@Column(name= "eexplanation")
		private String  eexplanation ;

		@Column(name= "hexplanation")
		private String  hexplanation ;

		@Column(name= "imgQeation")
		private String  imgQeation;
		
		@Column(name= "imgOptionA")
		private String  imgOptionA ;
		
		@Column(name= "imgOptionB")
		private String  imgOptionB ;
		
		@Column(name= "imgOptionC")
		private String  imgOptionC ;
		
		@Column(name= "imgOptionD")
		private String  imgOptionD ;

		public Long getQid() {
			return qid;
		}

		public void setQid(Long qid) {
			this.qid = qid;
		}

		public Long getSid() {
			return sid;
		}

		public void setSid(Long sid) {
			this.sid = sid;
		}

		public Long getTid() {
			return tid;
		}

		public void setTid(Long tid) {
			this.tid = tid;
		}

		public Long getStid() {
			return stid;
		}

		public void setStid(Long stid) {
			this.stid = stid;
		}

		public String getEqueation() {
			return equeation;
		}

		public void setEqueation(String equeation) {
			this.equeation = equeation;
		}

		public String getHqueation() {
			return hqueation;
		}

		public void setHqueation(String hqueation) {
			this.hqueation = hqueation;
		}

		public String getEoptionA() {
			return eoptionA;
		}

		public void setEoptionA(String eoptionA) {
			this.eoptionA = eoptionA;
		}

		public String getEoptinB() {
			return eoptinB;
		}

		public void setEoptinB(String eoptinB) {
			this.eoptinB = eoptinB;
		}

		public String getEoptinC() {
			return eoptinC;
		}

		public void setEoptinC(String eoptinC) {
			this.eoptinC = eoptinC;
		}

		public String getEoptinD() {
			return eoptinD;
		}

		public void setEoptinD(String eoptinD) {
			this.eoptinD = eoptinD;
		}

		public String getHoptinA() {
			return hoptinA;
		}

		public void setHoptinA(String hoptinA) {
			this.hoptinA = hoptinA;
		}

		public String getHoptinB() {
			return hoptinB;
		}

		public void setHoptinB(String hoptinB) {
			this.hoptinB = hoptinB;
		}

		public String getHoptinC() {
			return hoptinC;
		}

		public void setHoptinC(String hoptinC) {
			this.hoptinC = hoptinC;
		}

		public String getHoptinD() {
			return hoptinD;
		}

		public void setHoptinD(String hoptinD) {
			this.hoptinD = hoptinD;
		}

		public String getCurrectAns() {
			return currectAns;
		}

		public void setCurrectAns(String currectAns) {
			this.currectAns = currectAns;
		}

		public String getEexplanation() {
			return eexplanation;
		}

		public void setEexplanation(String eexplanation) {
			this.eexplanation = eexplanation;
		}

		public String getHexplanation() {
			return hexplanation;
		}

		public void setHexplanation(String hexplanation) {
			this.hexplanation = hexplanation;
		}

		public String getImgQeation() {
			return imgQeation;
		}

		public void setImgQeation(String imgQeation) {
			this.imgQeation = imgQeation;
		}

		public String getImgOptionA() {
			return imgOptionA;
		}

		public void setImgOptionA(String imgOptionA) {
			this.imgOptionA = imgOptionA;
		}

		public String getImgOptionB() {
			return imgOptionB;
		}

		public void setImgOptionB(String imgOptionB) {
			this.imgOptionB = imgOptionB;
		}

		public String getImgOptionC() {
			return imgOptionC;
		}

		public void setImgOptionC(String imgOptionC) {
			this.imgOptionC = imgOptionC;
		}

		public String getImgOptionD() {
			return imgOptionD;
		}

		public void setImgOptionD(String imgOptionD) {
			this.imgOptionD = imgOptionD;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
