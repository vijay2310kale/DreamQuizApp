package com.mpsweb.Meeting.Repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mpsweb.Meeting.entites.Mbregistration;

public interface RegistrationRepository extends JpaRepository<Mbregistration,Long>{

	
	
	
	

	@Transactional
	//@Modifying
		
	@Query(nativeQuery = true, value = "SELECT uid FROM mbregistration ORDER BY uid DESC LIMIT 1")
    long lastgeprimaryid();

	
	
	@Query(nativeQuery = true, value = "SELECT mobileno FROM mbregistration")
	List<String> getallmobilenumber();


	@Query(nativeQuery = true, value = "SELECT * FROM mbregistration where mobileno=:mobileno")
	Mbregistration getdatabymno(String mobileno);



	
	
}
