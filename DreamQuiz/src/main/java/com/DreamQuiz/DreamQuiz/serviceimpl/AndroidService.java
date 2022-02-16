package com.DreamQuiz.DreamQuiz.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DreamQuiz.DreamQuiz.Repository.ApplyfprmRepository;
import com.DreamQuiz.DreamQuiz.Repository.CurrentAfairsRepository;
import com.DreamQuiz.DreamQuiz.Repository.ExamdetailsRepository;
import com.DreamQuiz.DreamQuiz.Repository.OldPaperRepository;
import com.DreamQuiz.DreamQuiz.Repository.RegistrationRepository;
import com.DreamQuiz.DreamQuiz.Repository.SubjectRepository;
import com.DreamQuiz.DreamQuiz.Repository.TopicRepository;
import com.DreamQuiz.DreamQuiz.Repository.TopisNotesRepository;
import com.DreamQuiz.DreamQuiz.Repository.VideodetalsRepository;
import com.DreamQuiz.DreamQuiz.entity.Applyform;
import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;
import com.DreamQuiz.DreamQuiz.entity.Examdetails;
import com.DreamQuiz.DreamQuiz.entity.OldPaper;
import com.DreamQuiz.DreamQuiz.entity.Subject;
import com.DreamQuiz.DreamQuiz.entity.Topics;
import com.DreamQuiz.DreamQuiz.entity.Topicsnotespdf;
import com.DreamQuiz.DreamQuiz.entity.UserRegistration;
import com.DreamQuiz.DreamQuiz.entity.Videodetails;


@Service
public class AndroidService {
	
     @Autowired
	RegistrationRepository registrationRepository;
     @Autowired
     OldPaperRepository oldPaperRepository;
     
     @Autowired
     CurrentAfairsRepository currentAfairsRepository;
     
     @Autowired
     VideodetalsRepository videodetalsRepository;
     
     @Autowired
     ExamdetailsRepository examdetailsRepository;
     @Autowired
     SubjectRepository subjectRepository;
     
     @Autowired
     TopicRepository TopicsReposetory;
     
     @Autowired
     ApplyfprmRepository applyfprmRepository;
     
     
     @Autowired
 	TopisNotesRepository topisNotesRepository;
     
	public UserRegistration newregisteration(UserRegistration registration) {
		// TODO Auto-generated method stub
		return registrationRepository.save(registration);
	}

	public List<String> findemailfromdb() {
		
		return registrationRepository.findemailfrmdb();
	}

	public List<String> findmobilenofromdb() {
		// TODO Auto-generated method stub
		return registrationRepository.findemobilefrmdb();
	}

	public String finduserid(String umail, String umobile) {
		// TODO Auto-generated method stub
		return registrationRepository.finduserid(umail,umobile);
	}

	public String getotpfromdb(String user_id) {
		// TODO Auto-generated method stub
		return registrationRepository.getotp(user_id);
	}

	public String getpassbyphoneno(String phone_no) {
		// TODO Auto-generated method stub
		return registrationRepository.findbyphone_no(phone_no);
	}

	public long getuserid(String phone_no) {
		// TODO Auto-generated method stub
		return registrationRepository.getidnyphone(phone_no);
	}

	

	public UserRegistration getallbyphone_no(String phone_no) {
		// TODO Auto-generated method stub
		return registrationRepository.alldatabyphoneno(phone_no);
	}

	public void updatedata(UserRegistration getalldatabyphone) {
		registrationRepository.save(getalldatabyphone);
		
	}

	public UserRegistration getalldatabyuid(long uid) {
		// TODO Auto-generated method stub
		return registrationRepository.getalldatabyuid(uid);
	}

	public Optional<UserRegistration> getalldataofuser(Long user_id) {
		
		
		return registrationRepository.findById(user_id);
	}

	public List<Long> getalluid() {
		// TODO Auto-generated method stub
		return registrationRepository.selectalluid();
	}

	public List<OldPaper> getalloldpaper() {
		
		return oldPaperRepository.getalloldpaper();
	}

	public List<Long> findalluserid() {
		// TODO Auto-generated method stub
		return registrationRepository.findalluid();
	}

	public List<CurrentAffairs> getallCA() {
		// TODO Auto-generated method stub
		return currentAfairsRepository.getallCA();
	}

	public List<Videodetails> videoList(String vcategoryname) {
		// TODO Auto-generated method stub
		return videodetalsRepository.allvideolist(vcategoryname);
	}

	public List<Examdetails> Examdetails() {
		// TODO Auto-generated method stub
		return examdetailsRepository.allexamdetails();
	}

	public List<Subject> subjectList() {
		// TODO Auto-generated method stub
		return subjectRepository.selectallsubject();
	}

	public List<Topics> alltoipcbysid(long sid) {
		// TODO Auto-generated method stub
		return TopicsReposetory.alltoipcbysid(sid);
	}

	public Applyform saveApplyFormDetails(Applyform applyform) {
		return applyfprmRepository.save(applyform);
		
	}

	public List<Topicsnotespdf> topicnotesList(String topicid) {
		// TODO Auto-generated method stub
		return topisNotesRepository.topicnotesList(topicid);
	}

	
	

	

	
	

	

}



