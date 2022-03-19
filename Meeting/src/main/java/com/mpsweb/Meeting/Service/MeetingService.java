
package com.mpsweb.Meeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpsweb.Meeting.Repository.BannerRepository;
import com.mpsweb.Meeting.Repository.MbGenIdRepository;
import com.mpsweb.Meeting.Repository.MeetingDetailsRepository;
import com.mpsweb.Meeting.Repository.NewRegiRepository;
import com.mpsweb.Meeting.Repository.RegistrationRepository;
import com.mpsweb.Meeting.entites.Banner;
import com.mpsweb.Meeting.entites.Mbgenarateuid;
import com.mpsweb.Meeting.entites.Mbregistration;
import com.mpsweb.Meeting.entites.Meetingdetails;
import com.mpsweb.Meeting.entites.NewRegister;

@Service
public class MeetingService {
	
	@Autowired
	NewRegiRepository newRegiRepository;
	
	@Autowired
	MeetingDetailsRepository meetingDetailsRepository;

	@Autowired
	BannerRepository bannerRepository;
	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	MbGenIdRepository mbGenIdRepository;
	
	public NewRegister getallbyloginid(String loginid) {
		return newRegiRepository.getallbyloginid(loginid);
		 
	}

	public List<String> findloginidfromdb() {
		// TODO Auto-generated method stub
		return newRegiRepository.findloginidfromdb();
	}

	public NewRegister updatedivceid(NewRegister getallbyloginid) {
		return newRegiRepository.save(getallbyloginid);
		
	}

	public List<Meetingdetails> getallmeeting() {
		// TODO Auto-generated method stub
		return meetingDetailsRepository.findAll();
	}

	public List<Banner> allBannerList(String bannerid) {
		// TODO Auto-generated method stub
		return bannerRepository.allBannerList(bannerid);
	}

	public long lastgeprimaryid() {
		// TODO Auto-generated method stub
		return registrationRepository.lastgeprimaryid();
	}

	public List<String> getallmobilenumber() {
		// TODO Auto-generated method stub
		return registrationRepository.getallmobilenumber();
	}

	public void saveuserinfo(Mbregistration registration) {
		registrationRepository.save(registration);
		
	}

	public Mbregistration getdatabymno(String mobileno) {
		// TODO Auto-generated method stub
		return registrationRepository.getdatabymno(mobileno);
	}

	public void saveandgenuid(Mbgenarateuid mbgenarateuid) {
		mbGenIdRepository.save(mbgenarateuid);
		
	}

	public List<Mbgenarateuid> listbyuserid(String userid) {
		// TODO Auto-generated method stub
		return mbGenIdRepository.listbyuserid(userid);
	}
}
