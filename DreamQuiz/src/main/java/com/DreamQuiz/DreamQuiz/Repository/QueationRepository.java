package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.Queations;


@Repository
public interface QueationRepository extends JpaRepository<Queations,Long> {

	//List<Queations> findBysubtopicid(@Param("subtopicid")Long subtopicid);
	
	
	@Transactional
	@Modifying
//@Query("SELECT new com.DreamQuiz.DreamQuiz.Dto.QueationList(qid,sid,tid,stid,equeations,hqueations) from Queations WHERE stid=:stid")
	
	@Query(nativeQuery = true, value = "SELECT * FROM queations where stid=:stid")
	List<Queations> getDatabysubtopicidList(Long stid);

}

 