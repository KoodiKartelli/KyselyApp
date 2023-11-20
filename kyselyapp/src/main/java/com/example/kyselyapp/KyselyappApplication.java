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
        Question question4 = new Question("Mitä juot ruuan kanssa?", inquiry1);
        questions1.add(question4);

        inquiryRepository.save(inquiry1);

        Answer answer1 = new Answer("Kerran viikossa", question1);
        answerRepository.save(answer1);
        Answer answer2 = new Answer("Viisi kertaa viikossa", question1);
        answerRepository.save(answer2);
        Answer answer3 = new Answer("Silloin tällöin, jos on hyvää ruokaa", question1);
        answerRepository.save(answer3);
        Answer answer4 = new Answer("En ikinä", question1);
        answerRepository.save(answer4);
        
        Answer answer5 = new Answer("Kyllä", question2);
        answerRepository.save(answer5);
        Answer answer6 = new Answer("Haluaisin kasvissyöjänä joskus maksaa muustakin kuin kikherneistä", question2);
        answerRepository.save(answer6);
        Answer answer7 = new Answer("Yleisesti joo, mutta ruokaa pitäisi saada ottaa enemmän silloin kun on esim. pinaattilettuja ja niiden määrää on rajoitettu", question2);
        answerRepository.save(answer7);
        Answer answer8 = new Answer("Ei. Ruoka voisi olla laadukkaampaa ja vaihtoehdot monipuolisempia.", question2);
        answerRepository.save(answer8);
        
        Answer answer9 = new Answer("Toivisin enemmän kasvisvaihtoehtoja", question3);
        answerRepository.save(answer9);
        Answer answer10 = new Answer("UUNIMAKKARA", question3);
        answerRepository.save(answer10);
        Answer answer11 = new Answer("Mehu takaisin", question3);
        answerRepository.save(answer11);
        Answer answer12 = new Answer("Kalapuikot", question3);
        answerRepository.save(answer12);
        
        Answer answer13 = new Answer("Vettä", question4);
        answerRepository.save(answer13);
        Answer answer14 = new Answer("Maitoa", question4);
        answerRepository.save(answer14);
        Answer answer15 = new Answer("Sitruunavettä", question4);
        answerRepository.save(answer15);
        
        List<Question> questions2 = new ArrayList<>();
        
        Inquiry inquiry2 = new Inquiry("Jouluelokuvakysely", "Kysely parhaimmista jouluelokuvista.", questions2);
        
        Question question5 = new Question("Mikä on maailman paras jouluelokuva?", inquiry2);
        questions2.add(question5);
        Question question6 = new Question("Mitä elokuvaa et suosittelisi kenellekään?", inquiry2);
        questions2.add(question6);
        Question question7 = new Question("Miksi juuri nämä elokuvat ovat parhaimpia?", inquiry2);
        questions2.add(question7);

        inquiryRepository.save(inquiry2);
        
        Answer answer16 = new Answer("Joulupukki ja noitarumpu", question5);
        answerRepository.save(answer16);
        Answer answer17 = new Answer("Lumiukko", question5);
        answerRepository.save(answer17);
        
        Answer answer18 = new Answer("Lumiukko...", question6);
        answerRepository.save(answer18);
        Answer answer19 = new Answer("Jouluprinssi", question6);
        answerRepository.save(answer19);
        
        Answer answer21 = new Answer("Se vaan on.", question7);
        answerRepository.save(answer21);
        Answer answer22 = new Answer("WALKING IN THE AAIIRRR", question7);
        answerRepository.save(answer22);
        
        List<Question> questions3 = new ArrayList<>();
        
        Inquiry inquiry3 = new Inquiry("Kinkkiset kysymykset -kysely", "Maailman ärsyttävimmät kysymykset, joita kaikki vihaa, mutta niitä kysytään silti.", questions3);
        
        Question question8 = new Question("Kuuluuko ananas pizzaan?", inquiry3);
        questions3.add(question8);
        Question question9 = new Question("Kissat vai koirat?", inquiry3); 
        questions3.add(question9);
        Question question10 = new Question("Valitse supervoimasi.", inquiry3);
        questions3.add(question10);
        
        inquiryRepository.save(inquiry3);
        
        Answer answer23 = new Answer("No hyi", question8);
        answerRepository.save(answer23);
        Answer answer24 = new Answer("Kuuluu", question8);
        answerRepository.save(answer24);
        Answer answer25 = new Answer("Riippuu pizzasta, eli joo kai", question8);
        answerRepository.save(answer25);
        
        Answer answer26 = new Answer("Kissat!!!", question9);
        answerRepository.save(answer26);
        Answer answer27 = new Answer("Koirat", question9);
        answerRepository.save(answer27);
        Answer answer28 = new Answer("KOIRAT", question9);
        answerRepository.save(answer28);
        		
        Answer answer29 = new Answer("Telekinesia", question10);
        answerRepository.save(answer29);
        Answer answer30 = new Answer("Muodon muuttaminen", question10);
        answerRepository.save(answer30);
        Answer answer31 = new Answer("Lentäminen", question10);
        answerRepository.save(answer31);
    };

}

}
