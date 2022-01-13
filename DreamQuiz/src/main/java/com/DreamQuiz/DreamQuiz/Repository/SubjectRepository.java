package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.Queations;
import com.DreamQuiz.DreamQuiz.entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>  {

	
	@Transactional
	@Modifying

	@Query(nativeQuery = true, value = "SELECT subject_name FROM subject")
	List<String> findonlysubject();

}
