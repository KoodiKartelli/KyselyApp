package com.example.kyselyapp.domain;

public class Inquiry {
	Long inquiryid;
	String inquiry;
	String description;
	
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
	public String getInquiry() {
		return inquiry;
	}
	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}
	
}
