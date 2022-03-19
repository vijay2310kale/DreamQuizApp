package com.DreamQuiz.DreamQuiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DreamQuiz.DreamQuiz.entity.NewRegister;

public interface NewRegiRepository extends JpaRepository<NewRegister,Long> {

	@Transactional
	@Modifying
	
	@Query(nativeQuery = true, value = "SELECT * FROM new_register where loginid=:loginid")
	NewRegister getallbyloginid(String loginid);

	
	@Query(nativeQuery = true, value = "SELECT loginid FROM new_register")
	List<String> findloginidfromdb();

//	@Query(nativeQuery = true, value = "SELECT password FROM new_register where loginid=:loginid")
//	String getpassbyloginid(String loginid);

}
