package com.DreamQuiz.DreamQuiz.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DreamQuiz.DreamQuiz.Repository.CurrentAfairsRepository;
import com.DreamQuiz.DreamQuiz.Repository.ExamdetailsRepository;
import com.DreamQuiz.DreamQuiz.Repository.OldPaperRepository;
import com.DreamQuiz.DreamQuiz.Repository.SubjectRepository;
import com.DreamQuiz.DreamQuiz.Repository.TopicRepository;
import com.DreamQuiz.DreamQuiz.Repository.VideodetalsRepository;
import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
import com.DreamQuiz.DreamQuiz.entity.Examdetails;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;

@Service
public class AdminServices {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	OldPaperRepository oldPaperRepository;
	@Autowired
	ExamdetailsRepository examdetailsRepository;
	@Autowired
	VideodetalsRepository videodetalsRepository;
	 @Autowired
     CurrentAfairsRepository currentAfairsRepository;
	
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

	public List<OldPaper> Adminfindalloldpaper() {
		// TODO Auto-generated method stub
		return oldPaperRepository.findAll();
	}

	public void AddNewoldpaperpdf(OldPaper oldPaper) {
		oldPaperRepository.save(oldPaper);
	}

	public List<Examdetails> Addnewexamdetails() {
		// TODO Auto-generated method stub
		return examdetailsRepository.findAll();
	}

	public List<Videodetails> findallvideodetails() {
		// TODO Auto-generated method stub
		return  videodetalsRepository.findAll();
	}

	public List<CurrentAffairs> adminfindallCADetails() {
		// TODO Auto-generated method stub
		return  currentAfairsRepository.findAll();
	}

}
