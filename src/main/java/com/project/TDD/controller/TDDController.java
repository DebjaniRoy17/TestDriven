package com.project.TDD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.TDD.model.TDDModel;
import com.project.TDD.service.TDDService;

@RestController
public class TDDController {
	
	@Autowired
	TDDService tddService;
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<TDDModel> findAll(){
		
		return tddService.findAll();
		
	}
	
	@RequestMapping(value="/findOne/{id}",method=RequestMethod.GET)
	public Optional<TDDModel> findOne(@PathVariable("id") Long id){
		return tddService.findOne(id);
	}
}
