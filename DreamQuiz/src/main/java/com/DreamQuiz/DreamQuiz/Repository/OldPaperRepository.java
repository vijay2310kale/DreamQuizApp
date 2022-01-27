package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.OldPaper;


@Repository
public interface OldPaperRepository  extends JpaRepository<OldPaper,Long> {

	
	
	
	
	@Transactional
	@Modifying
	
	@Query(nativeQuery = true, value = "SELECT optitle FROM old_paper ")
	List<String> selectoldpapertitle();

	@Query(nativeQuery = true, value = "SELECT * FROM old_paper")
	List<OldPaper> getalloldpaper();
	
}
