package com.DreamQuiz.DreamQuiz.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DreamQuiz.DreamQuiz.Repository.QueationRepository;
import com.DreamQuiz.DreamQuiz.Repository.SubTopicRepository;
import com.DreamQuiz.DreamQuiz.Repository.SubjectRepository;
import com.DreamQuiz.DreamQuiz.Repository.TopicRepository;
import com.DreamQuiz.DreamQuiz.entity.Queations;
import com.DreamQuiz.DreamQuiz.entity.SubTopics;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;

@Service
public class AddQuestionServiceImpl {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	QueationRepository queationRepository;
	@Autowired
	SubTopicRepository subTopicRepository;

	
	
	public Subject addNewSubject(Subject subject) {
		
		return subjectRepository.save(subject);
	}

	public Topics addnewtopic(Topics topics) {
		
		return topicRepository.save(topics);
			
		
	}

	public SubTopics addnewsubtopic(SubTopics subTopics) {
	
		return subTopicRepository.save(subTopics);
	}

	public Queations addnewqueation(Queations queations) {
		
		
		return queationRepository.save(queations);
		
		
	}

	public List<Subject> getstudent() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	public Optional<Topics> findTpicsbySubjectid(long sid) {
		// TODO Auto-generated method stub
		
		System.out.println("service sid is "+sid);
		return topicRepository.findById(sid);
	}

	public Optional<SubTopics> findSubTopicsBytopicId(long tid) {
		
		return subTopicRepository.findById(tid);
	}

	
	
	
	
	      public List<Queations> getBysubtopicid(Long stid) {
			 return queationRepository.getDatabysubtopicidList(stid); 

	   // return queationRepository.findAll();
	 }

		
		

		public List<Topics> getTopicbysid(Long sid) {
			
			return topicRepository.getTopicBySid(sid);
		}

		public List<SubTopics> getSubTopicsbytid(Long tid) {
			// TODO Auto-generated method stub
			return subTopicRepository.getSubTopicsbytid(tid);
		}

		public List<String> getallsubject() {
			// TODO Auto-generated method stub
			return subjectRepository.findonlysubject();
		}

		public List<String> getAllTpoicfromdb(long sid) {
			// TODO Auto-generated method stub
			return topicRepository.findtopicbysid(sid);
		}

		public List<String> findsubtopicfromdb(long tid) {
			// TODO Auto-generated method stub
			return subTopicRepository.subtopicfromdb(tid);
		}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
