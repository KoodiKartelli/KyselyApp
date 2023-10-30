package com.example.kyselyapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;

	@RequestMapping(value = "/allquestions", method = RequestMethod.GET)
	public String questionList(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "questionlist";
	}

	@RequestMapping(value = "/addquestion")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "addquestion";
	}

	@RequestMapping(value="/save")
	public String saveQuestion(Question question) {
		questionRepository.save(question);
		return "redirect:allquestions";
	}

}