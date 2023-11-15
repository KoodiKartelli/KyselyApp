package com.example.kyselyapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long questionId;
	String text;

	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "inquiryid")
	private Inquiry inquiry;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("question")
	private List<Answer> answers;

	public Question(String text, Inquiry inquiry) {
		this.text = text;
		this.inquiry = inquiry;
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

	public Inquiry getInquiry() {
		return inquiry;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", text=" + text + ", inquiry=" + inquiry + "]";
	}

}
