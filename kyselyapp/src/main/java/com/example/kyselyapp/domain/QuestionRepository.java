package com.example.kyselyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findByText(String text);
	List<Question> findByInquiryInquiryid(Long inquiryid);
}
