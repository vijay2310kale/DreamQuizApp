package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.CurrentAffairs;

@Repository
public interface CurrentAfairsRepository extends JpaRepository<CurrentAffairs,Long> {


	
	@Transactional
	@Modifying
	
	@Query(nativeQuery = true, value = "SELECT title FROM current_affairs")
	List<String> findallcrpdftitle();

	
	@Query(nativeQuery = true, value = "SELECT * FROM current_affairs")
	List<CurrentAffairs> getallCA();
	
	
	
	
	

}
