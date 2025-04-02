package likhit.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import likhit.quizapp.model.Quizquestions;

@Repository
public interface QuestionsDao extends JpaRepository<Quizquestions, Integer> {

	List<Quizquestions> findByCategory(String catogery);  //-> intelligent JPA
    @Query(value="select q from Quizquestions q where q.category=:catogery order by rand() limit :questions")
	List<Quizquestions> findRandomQuestionsByCatogery(String catogery, int questions);
}
