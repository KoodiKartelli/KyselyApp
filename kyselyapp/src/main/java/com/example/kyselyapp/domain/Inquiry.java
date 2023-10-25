package com.example.kyselyapp.domain;

public class Inquiry {
	Long inquiryid;
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
	String inquiry;
}
