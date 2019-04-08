package com.anoki.SpringAnoki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anoki.SpringAnoki.exceptions.ContentNotFoundException;
import com.anoki.SpringAnoki.models.Content;
import com.anoki.SpringAnoki.repositories.ContentRepository;

@Service
public class ContentService {
	
	@Autowired
	ContentRepository contentRepo;

	public ContentService() {
	}
	
	public Iterable<Content> findAll(){
		return contentRepo.findAll();
	}
	
	public Content findById(Long id) {
		return contentRepo.findById(id).orElseThrow(ContentNotFoundException::new);
	}
	
	public List<Content> findByType(String type) {
		return contentRepo.findByType(type);
	}
	
	public List<Content> findByName(String name) {
		return contentRepo.findByName(name);
	}
	
	public Content bestSeller() {
		return contentRepo.findAllByOrderByCounterDesc().get(0);
		
	}

}
