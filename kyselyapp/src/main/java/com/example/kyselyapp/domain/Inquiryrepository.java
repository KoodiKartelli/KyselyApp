package com.example.kyselyapp.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Inquiryrepository extends CrudRepository<Inquiry, Long> {
    
	List<Inquiry> findByTitle(String title);
}