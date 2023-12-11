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
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;

	private String optionText;

	@ManyToOne
	@JsonIgnoreProperties("option")
	@JoinColumn(name = "questionId")
	private Question question;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "option")
	@JsonIgnoreProperties({"option", "question"}) 
	private List<Answer> answers;// answers

	public Option(String optionText, Question question) {
		this.optionText = optionText;
		this.question = question;
	}

	public Option() {
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public List<Answer> getAnswer() {
		return answers;
	}

	public void setAnswer(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Options [optionId=" + optionId + ", question=" + question + ", optionText=" + optionText + "]";
	}

}
