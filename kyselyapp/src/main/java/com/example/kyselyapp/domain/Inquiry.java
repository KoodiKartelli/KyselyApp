package com.example.kyselyapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long inquiryid;

	String title;
	String description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inquiry")
	@JsonIgnoreProperties("inquiry")
	private List<Question> questions;

	public Inquiry(String title, String description, List<Question> questions) {
		this.title = title;
		this.description = description;
		this.questions = questions;
	}
	
	

	public Inquiry() {

	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getInquiryid() {
		return inquiryid;
	}
	public void setInquiryid(Long inquiryid) {
		this.inquiryid = inquiryid;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Inquiry [inquiryid=" + inquiryid + ", title=" + title + ", description=" + description + "]";
	}
	
}
