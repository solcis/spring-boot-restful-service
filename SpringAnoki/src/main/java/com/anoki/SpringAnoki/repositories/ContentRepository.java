package com.anoki.SpringAnoki.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anoki.SpringAnoki.models.Content;

public interface ContentRepository extends CrudRepository<Content, Long> {
	
	List<Content> findByName(String name);
	
	List<Content> findByType(String type);
	
	List<Content> findAllByOrderByCounterDesc();

}
