package com.example.kyselyapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long questionId;
	String text;

	@ManyToOne
	@JsonIgnoreProperties("inquiries")
	@JoinColumn(name = "inquiryid")
	private Inquiry inquiry;

	public Question(String text) {
		super();
		this.text = text;
	}
	
	public Question() {
		
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", text=" + text + "]";
	}

}
