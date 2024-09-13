package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")	//pra dizer que a url vai ter um parametro
	public ResponseEntity<Category> findById(@PathVariable Long id){	//para o string aceitar o id e considerar como parametro que vai chegar no url
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
}
