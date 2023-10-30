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

@Controller
public class InquiryRestController{
	@Autowired
	private Inquiryrepository repository;
	


@RequestMapping(value="/inquiry", method = RequestMethod.GET)
public @ResponseBody List<Inquiry> inquiryListRest(){
	return (List<Inquiry>) repository.findAll();
}

@RequestMapping(value="/inquiry/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Inquiry> findInquiryRest(@PathVariable("id") Long inquiryid){
	return repository.findById(inquiryid);
	}

@RequestMapping(value = "/inquirylist")
public String inquirylist(Model model) {
	List<Inquiry> inquiry = (List<Inquiry>) repository.findAll();
	model.addAttribute("inquiry", inquiry);
	return "inquirylist";
}

}