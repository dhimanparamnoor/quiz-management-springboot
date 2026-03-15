package com.param.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.param.quizapp.dao.QuestionDao;
import com.param.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired 
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category){
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	
	public ResponseEntity<String> deleteQuestion(Integer id) {
		try {
			if(questionDao.existsById(id)) {
				questionDao.deleteById(id);
				return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Question Not Found",HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error Deleting Question",HttpStatus.BAD_REQUEST);
		}
	}
	
//	Update	
	public ResponseEntity<String> updateQuestion(Integer id,Question updatedQuestion) {
		try {
		Optional<Question> optionalQuestion = questionDao.findById(id);
		
		if(optionalQuestion.isPresent()) {
			Question existingQuestion = optionalQuestion.get();
			
			existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
			existingQuestion.setOption1(updatedQuestion.getOption1());
			existingQuestion.setOption2(updatedQuestion.getOption2());
			existingQuestion.setOption3(updatedQuestion.getOption3());
            existingQuestion.setOption4(updatedQuestion.getOption4());
            existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
            existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
            existingQuestion.setCategory(updatedQuestion.getCategory());
            
            questionDao.save(existingQuestion);
            
			return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Question Not Found",HttpStatus.BAD_REQUEST);
		}
		
	} catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>("Error Updating Question",HttpStatus.BAD_REQUEST);
	}
	}
}