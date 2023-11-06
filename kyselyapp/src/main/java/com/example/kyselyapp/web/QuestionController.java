package com.example.kyselyapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kyselyapp.domain.Inquiry;
import com.example.kyselyapp.domain.Inquiryrepository;
import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired Inquiryrepository inquiryRepository;

	//Palauttaa yhden kyselyn kysymykset
	@RequestMapping(value="/questionlist/{id}", method = RequestMethod.GET)
	public String showQuestionsByInquiryId(@PathVariable("id") Long inquiryid, Model model){
		List<Question> questions = questionRepository.findByInquiryInquiryid(inquiryid);
		model.addAttribute("questions", questions);
		return "questionlist";
	    /*Optional<Inquiry> inquiryOptional = inquiryRepository.findById(inquiryId);
	    if(inquiryOptional.isPresent()){
	        Inquiry inquiry = inquiryOptional.get();
	        model.addAttribute("questions", inquiry.getQuestions());
	        return "questionlist";
	    } else {
	        return "error";
	    }*/
	}

	//Palauttaa kysymyksen luonti lomakkeen
	@RequestMapping(value = "/addquestion/{id}", method = RequestMethod.GET)
	public String addQuestionForm(@RequestParam("id") Long inquiryid, Model model) {
    model.addAttribute("inquiryid", inquiryid);
    model.addAttribute("question", new Question());
    return "addquestion";
}


	//Tallettaa lomakkeelta tulleet kysymyksen tiedot tietokantaan
	@RequestMapping(value="/savequestion", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
		questionRepository.save(question);
		return "redirect:/questionlist";
	}

}