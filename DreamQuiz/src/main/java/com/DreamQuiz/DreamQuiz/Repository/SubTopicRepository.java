package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.SubTopics;

@Repository
public interface SubTopicRepository extends JpaRepository<SubTopics,Long> {

	
	
	
	@Transactional
	@Modifying
	
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM sub_topics where tid=:tid")
	List<SubTopics> getSubTopicsbytid(Long tid);

}
