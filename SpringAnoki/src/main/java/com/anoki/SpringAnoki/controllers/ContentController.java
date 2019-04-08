package com.anoki.SpringAnoki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anoki.SpringAnoki.models.Content;
import com.anoki.SpringAnoki.services.ContentService;

@RestController
@RequestMapping("/api/content")
public class ContentController {
	
	@Autowired
	ContentService contentService;
	
	@GetMapping
	public Iterable<Content> findAll(){
		return contentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Content findById(@PathVariable Long id) {
		return contentService.findById(id);
	}
	
	@GetMapping("/categories/{type}")
	public List<Content> findByType(@PathVariable String type) {
		return contentService.findByType(type);
	}
	
	@GetMapping("/titles/{name}")
	public List<Content> findByName(@PathVariable String name) {
		return contentService.findByName(name);
	}
	
	@GetMapping("/best_seller")
	public Content bestSeller() {
		return contentService.bestSeller();
	}

}
