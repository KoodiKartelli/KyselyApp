package com.example.kyselyapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kyselyapp.domain.Inquiry;
import com.example.kyselyapp.domain.Inquiryrepository;

@Controller
public class InquiryController {
    
    @Autowired
    Inquiryrepository inquiryRepository;

    @RequestMapping(value = "/addinquiry")
    public String addInquiry(Model model) {
         model.addAttribute("inquiry", new Inquiry());
         return "addinquiry";
    }

     @RequestMapping(value = "/save", method = RequestMethod.POST)
     public String save (Inquiry inquiry) {
        inquiryRepository.save(inquiry);
        return "redirect:inquirylist";
     }
     
     
     
     
    
}
