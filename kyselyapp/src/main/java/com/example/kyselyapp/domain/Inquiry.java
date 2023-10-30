package com.example.kyselyapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long inquiryid;

	String title;
	String description;
	
	public Inquiry(String inquiry, String description) {
		this.title = inquiry;
		this.description = description;
	}

	public Inquiry() {
		this.title = null;
		this.description = null;
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

	@Override
	public String toString() {
		return "Inquiry [inquiryid=" + inquiryid + ", title=" + title + ", description=" + description + "]";
	}
	
}
