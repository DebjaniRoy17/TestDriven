package com.project.TDD.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.project.TDD.model.TDDModel;
import com.project.TDD.service.TDDService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TDDControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TDDService tddService;
	
	
	public List<TDDModel> getList(){
		List<TDDModel> list = new ArrayList<TDDModel>();
		
		list.add(new TDDModel(1L,"Debjani","TCS"));
		list.add(new TDDModel(2L,"Nirupam","Segula"));
		
		return list;
	}
	
	@Test
	public void findAllTest() throws Exception {
		
		System.out.println("*************ControllerTest FindAllTest****************");
		
		
		when(tddService.findAll()).thenReturn(getList());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findAll").contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(2))).andDo(print());
		
	}
	
	@Test
	public void findOneTest() throws Exception {
		
		System.out.println("********** Controller Test findOneTest************");
		
		Long id = 1L;
		when(tddService.findOne(id)).thenReturn(Optional.of(getList().get(0)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/findOne/{id}",1L).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is(200))
		.andExpect(jsonPath("name", is("Debjani")))
		.andDo(print());
		
		
	}
}
