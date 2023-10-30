package com.example.kyselyapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
<<<<<<< HEAD
public CommandLineRunner demo(Inquiryrepository inquiryRepository, QuestionRepository questionRepository) {
    return (args) -> {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Kysymys 1"));
        questions.add(new Question("Kysymys 2"));
        questions.add(new Question("Kysymys 3"));

        Inquiry inquiry = new Inquiry("Onko nuoriso pilalla", "No onko", questions);

        inquiryRepository.save(inquiry);
    };
=======
public CommandLineRunner demo(Inquiryrepository inquiryRepository) {
	return (args) ->{
		
		inquiryRepository.save(new Inquiry("Onko nuoriso pilalla", "No onko"));
		
	};
>>>>>>> a7e4ced15f303c94d1d763171a83d197b2d49836
}


}
