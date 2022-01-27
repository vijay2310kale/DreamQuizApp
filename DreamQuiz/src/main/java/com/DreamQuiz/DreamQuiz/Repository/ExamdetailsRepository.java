package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.Examdetails;

public interface ExamdetailsRepository extends JpaRepository<Examdetails,Long> {

	
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "SELECT examname FROM examdetails")
	List<String> examnamefromdb();
	@Query(nativeQuery = true, value = "SELECT * FROM examdetails")
	List<Examdetails> allexamdetails();

}
