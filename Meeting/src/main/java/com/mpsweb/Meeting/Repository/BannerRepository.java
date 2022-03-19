package com.mpsweb.Meeting.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mpsweb.Meeting.entites.Banner;
import com.mpsweb.Meeting.entites.Meetingdetails;
import com.mpsweb.Meeting.entites.NewRegister;


public interface BannerRepository extends JpaRepository<Banner,Long> {

	

	
	@Transactional
	//@Modifying
	
//	
//	
//	void save(String bannerfilepath);
	@Query(nativeQuery = true, value = "SELECT * FROM banner where bannerid=:bannerid")
	List<Banner> allBannerList(String bannerid);
	
	
	
	
}
