package likhit.quizapp.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quiz {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
       private String title;
       @ManyToMany
       private List<Quizquestions>questions;
       
}


