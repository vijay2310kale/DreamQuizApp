package com.DreamQuiz.DreamQuiz.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DreamQuiz.DreamQuiz.Repository.SubjectRepository;
import com.DreamQuiz.DreamQuiz.Repository.TopicRepository;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;

@Service
public class AdminServices {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	TopicRepository topicRepository;
	
	
	
	public List<Subject> findalaSubject() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	public void addNewSubject(Subject subject) {
		subjectRepository.save(subject);
		
	}

	

	public List<Topics> findTopicsbySubjectid(long sid) {
		// TODO Auto-generated method stub
		return topicRepository.getTopicBySid(sid);
	}

}
