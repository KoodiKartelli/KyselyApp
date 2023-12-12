package com.example.kyselyapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kyselyapp.domain.Inquiry;
import com.example.kyselyapp.domain.Inquiryrepository;
import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired 
	 private Inquiryrepository inquiryRepository;

	// Palauttaa yhden kyselyn kysymykset
	@RequestMapping(value="/questionlist/{inquiryid}", method = RequestMethod.GET)
	public String showQuestionsByInquiryId(@PathVariable("inquiryid") Long inquiryid, Model model){
		Inquiry inquiry = inquiryRepository.findById(inquiryid).get();
		List<Question> questions = questionRepository.findByInquiryInquiryid(inquiryid);
		model.addAttribute("questions", questions);
		model.addAttribute("inquiry", inquiry);
		return "questionlist"; //questionlist.html
	}

	// Palauttaa kysymyksen luonti lomakkeen
	@RequestMapping(value = "/addquestion/{inquiryid}", method = RequestMethod.GET)
		public String addQuestionForm(@PathVariable("inquiryid") Long inquiryid, Model model) {
		Inquiry inquiry = inquiryRepository.findById(inquiryid).get();
		Question newQuestion = new Question();
		newQuestion.setInquiry(inquiry);
		model.addAttribute("question", newQuestion);
    	return "addquestion"; //addquestion.html
	}
	
	// Tallettaa lomakkeelta tulleet kysymyksen tiedot tietokantaan
	@RequestMapping(value="/savequestion/{inquiryid}", method = RequestMethod.POST)
		public String saveQuestion(@PathVariable("inquiryid") Long inquiryid, Question question, Model model) {
    	question.setInquiry(inquiryRepository.findById(inquiryid).get());
    	questionRepository.save(question);
    	return "redirect:/questionlist/{inquiryid}";
	}

}