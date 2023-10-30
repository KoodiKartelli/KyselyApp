package com.example.kyselyapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kyselyapp.domain.Inquiry;
import com.example.kyselyapp.domain.Inquiryrepository;
import com.example.kyselyapp.domain.Question;

@Controller
public class InquiryRestController{
	@Autowired
	private Inquiryrepository inquiryRepository;
	
	@RequestMapping(value="/inquiries/{id}/questions", method = RequestMethod.GET)
	public String showQuestionsByInquiryId(@PathVariable("id") Long inquiryId, Model model){
	    Optional<Inquiry> inquiryOptional = inquiryRepository.findById(inquiryId);
	    if(inquiryOptional.isPresent()){
	        Inquiry inquiry = inquiryOptional.get();
	        model.addAttribute("questions", inquiry.getQuestions());
	        return "questionlist"; // Olettaen, että sivun nimi on 'questionlist.html'
	    } else {
	        // Palauta virheviesti tai ohjaa virhesivulle
	        return "error";
	    }
	}
}
/*@RequestMapping(value="/inquiries/{id}/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> findQuestionsByInquiryId(@PathVariable("id") Long inquiryId){
		Optional<Inquiry> inquiryOptional = inquiryRepository.findById(inquiryId);
		Inquiry inquiry = inquiryOptional.get();
		return inquiry.getQuestions();
	}}*/
	
	


