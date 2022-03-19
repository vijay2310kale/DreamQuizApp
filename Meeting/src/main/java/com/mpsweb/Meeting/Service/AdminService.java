package com.mpsweb.Meeting.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpsweb.Meeting.Repository.MeetingDetailsRepository;
import com.mpsweb.Meeting.Repository.NewRegiRepository;
import com.mpsweb.Meeting.Repository.BannerRepository;
import com.mpsweb.Meeting.entites.Banner;
import com.mpsweb.Meeting.entites.Meetingdetails;
import com.mpsweb.Meeting.entites.NewRegister;

@Service
public class AdminService {
	
	@Autowired
	NewRegiRepository newRegiRepository;
	
	@Autowired
	MeetingDetailsRepository meetingDetailsRepository;
	
	@Autowired
	BannerRepository BannerRepository;
	
	
	public void savenewregi(NewRegister newRegister) {
     newRegiRepository.save(newRegister);
			
		}
	public void SaveMeetingdetails(Meetingdetails meetingdetails) {
		meetingDetailsRepository.save(meetingdetails);
		
	}
	public long getlastinsertpid() {
		// TODO Auto-generated method stub
		return meetingDetailsRepository.getlastinsertpid();
	}
	public long getlastnewregisterpid() {
		// TODO Auto-generated method stub
		return newRegiRepository.getlastinsertpid2();
	}
	public List<NewRegister> Adminfindallclient() {
		// TODO Auto-generated method stub
		return newRegiRepository.findAll();
	}
	public List<Meetingdetails> AdminfindallMeeting() {
		// TODO Auto-generated method stub
		return meetingDetailsRepository.findAll();
	}
	public  void SaveBanner(Banner banner) {
		BannerRepository.saveAndFlush(banner);
		
	}
	public Optional<Meetingdetails> adminfindmeetingdatabybid(long bid) {
		// TODO Auto-generated method stub
		return meetingDetailsRepository.findById(bid);
	}
	public Meetingdetails getmeetingbyid(Long mid) {
		// TODO Auto-generated method stub
		return meetingDetailsRepository.findById(mid).get();
	}
	public NewRegister getclientbyid(Long uid) {
		// TODO Auto-generated method stub
		return newRegiRepository.findById(uid).get();
	}
	public void SaveUserdetails(NewRegister newRegister) {
		newRegiRepository.save(newRegister);
	}
	
}
