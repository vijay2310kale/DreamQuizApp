package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.SubTopics;

import com.DreamQuiz.DreamQuiz.entity.Topicsnotespdf;

public interface TopisNotesRepository extends JpaRepository<Topicsnotespdf,Long> {

	@Transactional
	@Modifying
	
	
	@Query(nativeQuery = true, value = "SELECT title FROM topicsnotespdf")
		List<String> findalltopicsNotesPdf();

	
	@Query(nativeQuery = true, value = "SELECT * FROM topicsnotespdf where topicid=:topicid")
	List<Topicsnotespdf> topicnotesList(String topicid);
	
	

}
