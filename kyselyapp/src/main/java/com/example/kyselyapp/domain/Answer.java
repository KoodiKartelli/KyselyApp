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
	@JsonIgnoreProperties({"answer", "question"})
	@JoinColumn(name = "optionId")
	private Option option;

	public Answer(String answer, Question question, Option option) {
		super();
		this.answer = answer;
		this.question = question;
		this.option = option;
	}

	public Answer(String answer, Question question) {
		super();
		this.answer = answer;
		this.question = question;
	}

	public Answer(Question question, Option options) {
		super();
		this.question = question;
		this.option = options;
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

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", answer=" + answer + ", question=" + question + "]";
	}

}
