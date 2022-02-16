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

public class Topics {
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	     private Long tid;
	     
	     @Column(name = "sid")
	     private Long sid;
	     
	     @Column(name = "topicname")
	     private String topicname;
	     
	     
	     @Column(name = "thumbnail") 
			private String thumbnail;
		 
		

		public String getThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}

		public Long getTid() {
			return tid;
		}

		public void setTid(Long tid) {
			this.tid = tid;
		}

		public Long getSid() {
			return sid;
		}

		public void setSid(Long sid) {
			this.sid = sid;
		}

		public String getTopicname() {
			return topicname;
		}

		public void setTopicname(String topicname) {
			this.topicname = topicname;
		}

	
	     
	     
	     
		

}
