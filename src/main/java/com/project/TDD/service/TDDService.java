package com.project.TDD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TDD.model.TDDModel;
import com.project.TDD.repo.TDDRepository;

@Service
public class TDDService {
	
	
	private TDDRepository tddRepository;
	
	public TDDService(TDDRepository tddRepository) {
		
		this.tddRepository = tddRepository;
	}

	public List<TDDModel> findAll(){
		return tddRepository.findAll();
	}
	
	public Optional<TDDModel> findOne(Long id) {
		return tddRepository.findById(id);
	}

}
