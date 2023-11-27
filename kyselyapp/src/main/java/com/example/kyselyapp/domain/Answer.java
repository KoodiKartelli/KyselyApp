package com.example.kyselyapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long answerId;
	String answer;

	@ManyToOne
	@JsonIgnoreProperties("answers")
	@JoinColumn(name = "questionId")
	private Question question;

	@ManyToOne
	@JsonIgnoreProperties("answer")
	@JoinColumn(name = "optionId")
	private Option options;

	public Answer(String answer, Question question) {
		super();
		this.answer = answer;
		this.question = question;
	}

	public Answer(Question question, Option options) {
		super();
		this.question = question;
		this.options = options;
	}

	public Answer() {
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Option getOptions() {
		return options;
	}

	public void setOptions(Option options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", answer=" + answer + ", question=" + question + "]";
	}

}
