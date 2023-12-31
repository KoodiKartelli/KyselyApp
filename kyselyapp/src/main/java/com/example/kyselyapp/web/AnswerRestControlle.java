package com.example.kyselyapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kyselyapp.domain.Answer;
import com.example.kyselyapp.domain.AnswerRepository;
import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

@CrossOrigin
@Controller
public class AnswerRestControlle {

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionRepository questionRepository;

	// Palauttaa kaikki vastaukset JSON-muodossa
	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> answerListRest() {
		return (List<Answer>) answerRepository.findAll();
	}

	// Palauttaa kysymyjsen vastaukset JSON-muodossa
	@RequestMapping(value = "/questions/{id}/answers", method = RequestMethod.GET)
	public @ResponseBody Optional<Question> questionRest(@PathVariable("id") Long id) {
		return questionRepository.findById(id);
	}

	// Mahdollistaa uuden vastauksen tallentamisen
	@RequestMapping(value = "/questions/{id}/answers", method = RequestMethod.POST)
	public @ResponseBody Answer saveAnswerRest(@PathVariable("id") Long questionId, @RequestBody Answer answer) {
		Optional<Question> questionOptional = questionRepository.findById(questionId);
		answer.setQuestion(questionOptional.get());
		return answerRepository.save(answer);
	}

}
