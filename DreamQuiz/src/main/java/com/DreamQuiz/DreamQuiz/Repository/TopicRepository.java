package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.SubTopics;
import com.DreamQuiz.DreamQuiz.entity.Topics;

@Repository
public interface TopicRepository extends JpaRepository<Topics,Long> {

	
	
	@Transactional
	@Modifying
	
	@Query(nativeQuery = true, value = "SELECT * FROM topics where sid=:sid")
	List<Topics> getTopicBySid(Long sid);

	
	@Query(nativeQuery = true, value = "SELECT topicname FROM topics where sid=:sid")
	List<String> findtopicbysid(long sid);

}
