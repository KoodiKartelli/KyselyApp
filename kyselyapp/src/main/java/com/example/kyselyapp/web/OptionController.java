package com.example.kyselyapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kyselyapp.domain.Option;
import com.example.kyselyapp.domain.OptionRepository;
import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

public class OptionController {
    
    @Autowired
	private QuestionRepository questionRepository;

    @Autowired
	private OptionRepository optionRepository;

    //Luo vastausvaihtoehdon kysymykselle
    @RequestMapping(value = "/addoption/{questionId}", method = RequestMethod.GET)
	public String addOptionForm(@PathVariable("questionId") Long questionId, Model model) {
	    Question question = questionRepository.findById(questionId).get();
	    Option newOption = new Option();
	    newOption.setQuestion(question);
	    model.addAttribute("option", newOption);
        return "addoption"; //addquestion.html
}
    
    //Tallettaa lomakkeelta tulleet vastausvaihtoehdon tiedot tietokantaan
    @RequestMapping(value="/saveoption/{questionId}", method = RequestMethod.POST)
	public String saveOption(@PathVariable("questionId") Long questionId, Option option, Model model) {
    	option.setQuestion(questionRepository.findById(questionId).get());
    	optionRepository.save(option);
    	return "redirect:/questionlist/{inquiryid}";
}
    //Palauttaa yhden kysymyksen vastausvaihtoehdot
	@RequestMapping(value="/optionlist/{questionId}", method = RequestMethod.GET)
	public String showQuestionsByInquiryId(@PathVariable("questionId") Long questionId, Model model){
		Question question = questionRepository.findById(questionId).get();
		List<Option> options = optionRepository.findByQuestionQuestionId(questionId);
		model.addAttribute("options", options);
		model.addAttribute("question", question);
		return "optionlist";
	}

}
