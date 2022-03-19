package com.mpsweb.Meeting.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mpsweb.Meeting.entites.Mbgenarateuid;
import com.mpsweb.Meeting.entites.NewRegister;

public interface MbGenIdRepository extends JpaRepository<Mbgenarateuid,Long> {

	
	
	@Transactional
	//@Modifying
		
	@Query(nativeQuery = true, value = "SELECT * FROM mbgenarateuid WHERE userid=:userid")
	List<Mbgenarateuid> listbyuserid(String userid);

}
