package com.DreamQuiz.DreamQuiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DreamQuiz.DreamQuiz.entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>  {

}
