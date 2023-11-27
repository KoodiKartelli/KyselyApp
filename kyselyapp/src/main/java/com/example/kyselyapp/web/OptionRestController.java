package com.example.kyselyapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kyselyapp.domain.Option;
import com.example.kyselyapp.domain.OptionRepository;
import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

@CrossOrigin
@Controller
public class OptionRestController {

    @Autowired
	private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;
    
    //Palauttaa tietyn kysymyksen vastausvaihtoehdot
    @RequestMapping(value = "/questions/{id}/options", method = RequestMethod.GET)
    public @ResponseBody Optional<Question> optionRest(@PathVariable("id") Long questionId) {
        return questionRepository.findById(questionId);
    }

    //Saattaa olla turha
    @RequestMapping(value = "/questions/{id}/options", method = RequestMethod.POST)
    public @ResponseBody Option saveOptionRest(@PathVariable("id") Long questionId, @RequestBody Option option) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        option.setQuestion(questionOptional.get());
        return optionRepository.save(option);
    }
}
