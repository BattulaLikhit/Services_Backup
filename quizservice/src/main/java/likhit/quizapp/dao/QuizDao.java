package likhit.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import likhit.quizapp.model.Quiz;
import likhit.quizapp.model.Quizquestions;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
