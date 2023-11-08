package com.example.kyselyapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kyselyapp.domain.Inquiry;
import com.example.kyselyapp.domain.Inquiryrepository;
import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

@CrossOrigin
@Controller
public class InquiryRestController{

	@Autowired
	private Inquiryrepository inquiryRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@RequestMapping(value = "/inquiries", method = RequestMethod.GET)
	public @ResponseBody List<Inquiry> inquiryListRest() {
		return (List<Inquiry>) inquiryRepository.findAll();
	}

	@RequestMapping(value = "/inquiries/{id}/questions", method = RequestMethod.GET)
	public @ResponseBody Optional<Inquiry> inquiryRest(@PathVariable("id") Long id) {
		return inquiryRepository.findById(id);
	}

	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>)questionRepository.findAll();
	}
}
	
	


