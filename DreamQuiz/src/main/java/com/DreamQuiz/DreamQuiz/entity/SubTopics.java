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

public class SubTopics {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	     private Long stid;
	    
	    @Column(name = "sid") 
	     private Long sid;
	    
	     @Column(name = "tid") 
	     private Long tid;
	    
	    
	     @Column(name = "subtopicname") 
	     private String subtopicname;


		public Long getStid() {
			return stid;
		}


		public void setStid(Long stid) {
			this.stid = stid;
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


		public String getSubtopicname() {
			return subtopicname;
		}


		public void setSubtopicname(String subtopicname) {
			this.subtopicname = subtopicname;
		}
	    
	     
	     
	     
	    

}
