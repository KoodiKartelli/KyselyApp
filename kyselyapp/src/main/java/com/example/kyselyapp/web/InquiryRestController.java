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
<<<<<<< HEAD
	private Inquiryrepository inquiryRepository;

	@RequestMapping(value="/inquiries/{id}/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> findQuestionsByInquiryId(@PathVariable("id") Long inquiryId){
		Optional<Inquiry> inquiryOptional = inquiryRepository.findById(inquiryId);
		Inquiry inquiry = inquiryOptional.get();
		return inquiry.getQuestions();
	}
	
=======
	private Inquiryrepository irepository;
	
	
	
	

/*
@RequestMapping(value="/inquiry", method = RequestMethod.GET)
public @ResponseBody List<Inquiry> inquiryListRest(){
	return (List<Inquiry>) irepository.findAll();
}

@RequestMapping(value="/inquiry/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Inquiry> findInquiryRest(@PathVariable("id") Long inquiryid){
	return irepository.findById(inquiryid);
	}

@RequestMapping(value = "/inquirylist")
public String inquirylist(Model model) {
	List<Inquiry> inquiry = (List<Inquiry>) irepository.findAll();
	model.addAttribute("inquiry", inquiry);
	return "inquirylist";
}
*/
>>>>>>> a7e4ced15f303c94d1d763171a83d197b2d49836
}