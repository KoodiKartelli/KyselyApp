package com.example.kyselyapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kyselyapp.domain.Answer;
import com.example.kyselyapp.domain.AnswerRepository;
import com.example.kyselyapp.domain.Inquiry;
import com.example.kyselyapp.domain.Inquiryrepository;
import com.example.kyselyapp.domain.Question;
import com.example.kyselyapp.domain.QuestionRepository;

@SpringBootApplication
public class KyselyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyappApplication.class, args);
	}
	
@Bean

public CommandLineRunner demo(Inquiryrepository inquiryRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
    return (args) -> {
        List<Question> questions1 = new ArrayList<>();

        Inquiry inquiry1 = new Inquiry("Haaga-Helian lounaskysely", "Kysely liittyen Haaga-Helian lounaan laatuun", questions1);

		Question question1 = new Question("Kuinka usein käyt kouluruokailussa?", inquiry1);
        questions1.add(question1);
        Question question2 = new Question("Onko hintalaatusuhde mielestäsi hyvä?", inquiry1);
        questions1.add(question2);
        Question question3 = new Question("Esitä ruokatoiveita tai kerro lempiruokasi.", inquiry1);
        questions1.add(question3);

        inquiryRepository.save(inquiry1);

        Answer answer1 = new Answer("Kerran viikossa", question1);
        answerRepository.save(answer1);

        Answer answer2 = new Answer("Kyllä", question2);
        answerRepository.save(answer2);

        Answer answer3 = new Answer("Toivisin enemmän kasvisvaihtoehtoja", question3);
        answerRepository.save(answer3);
        //questions1.add(new Question("Onko hintalaatusuhde mielestäsi hyvä?", inquiry1));
        //questions1.add(new Question("Esitä ruokatoiveita tai kerro lempiruokasi.", inquiry1));
        
        List<Question> questions2 = new ArrayList<>();
        
        Inquiry inquiry2 = new Inquiry("Jouluelokuvakysely", "Kysely parhaimmista jouluelokuvista.", questions2);
        
        questions2.add(new Question("Mikä on maailman paras jouluelokuva?", inquiry2));
        questions2.add(new Question("Mitä elokuvaa et suosittelisi kenellekään?", inquiry2));
        questions2.add(new Question("Miksi juuri nämä elokuvat ovat parhaimpia?", inquiry2));
        
        inquiryRepository.save(inquiry2);
        
        List<Question> questions3 = new ArrayList<>();
        
        Inquiry inquiry3 = new Inquiry("Kinkkiset kysymykset -kysely", "Maailman ärsyttävimmät kysymykset, joita kaikki vihaa, mutta niitä kysytään silti.", questions3);
        
        questions3.add(new Question("Kuuluuko ananas pizzaan?", inquiry3));
        questions3.add(new Question("Kissat vai koirat?", inquiry3));
        questions3.add(new Question("Valitse supervoimasi.", inquiry3));
        
        inquiryRepository.save(inquiry3);
    };

}

}
