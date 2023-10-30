package com.example.kyselyapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kyselyapp.domain.Inquiry;
import com.example.kyselyapp.domain.Inquiryrepository;

@SpringBootApplication
public class KyselyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyappApplication.class, args);
	}
	
@Bean
public CommandLineRunner demo(Inquiryrepository inquiryRepository) {
	return (args) ->{
		
		inquiryRepository.save(new Inquiry("Onko nuoriso pilalla", "No onko"));
		
	};
}

}
