package com.mpsweb.Meeting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mpsweb.Meeting.entites.Meetingdetails;

public interface MeetingDetailsRepository extends JpaRepository<Meetingdetails,Long> {


	@Transactional
	//@Modifying
	
	
	
		
	@Query(nativeQuery = true, value = "SELECT mid FROM meetingdetails ORDER BY mid DESC LIMIT 1")
	//@Query(nativeQuery = true, value = "SELECT mid ISNULL(mid,'0') AS mid FROM meetingdetails ORDER BY mid DESC LIMIT 1")
	long getlastinsertpid();
	
	
		
//"SELECT mid ISNULL(mid,'0') AS mid FROM meetingdetails ORDER BY mid DESC LIMIT 1"
}
