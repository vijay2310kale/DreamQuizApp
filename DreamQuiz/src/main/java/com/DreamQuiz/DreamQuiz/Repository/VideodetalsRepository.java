package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.Videodetails;


@Repository
public interface VideodetalsRepository extends JpaRepository<Videodetails,Long> {

	@Transactional
	@Modifying
	
	
	@Query(nativeQuery = true, value = "SELECT vtitle FROM videodetails")
	List<String> videotitlefromdb();

	
	@Query(nativeQuery = true, value = "SELECT * FROM videodetails")
	List<Videodetails> allvideolist();
	
	

}
