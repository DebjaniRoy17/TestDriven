package com.project.TDD.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.TDD.model.TDDModel;
import com.project.TDD.repo.TDDRepository;


//@ContextConfiguration(classes={TDDService.class, TDDRepository.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class TDDServiceTest {
	
	@Autowired
	TDDRepository tddRepository;
	
	@Test
	public void findAllTest() {
		System.out.println("*************ServiceTest FindAllTest****************");
		tddRepository.flush();
		
		TDDModel model = new TDDModel("Priyanka", "JP Morgan");
		tddRepository.save(model);
		
		TDDService service = new TDDService(tddRepository);
		
		System.out.println("tddRepository find all"+ tddRepository.findAll());
		
		TDDModel firstModel = service.findAll().get(1);
		
		assertEquals(model.getId(), firstModel.getId());
	}
	
	@Test
	public void findOneTest() {
		System.out.println("************ Service Test FindOneTest*************");
		tddRepository.flush();
		
		TDDModel model = new TDDModel("Priyanka2", "JP Morgan");
		tddRepository.save(model);
		
		TDDService service = new TDDService(tddRepository);
		
		assertEquals(service.findOne(1L).get().getName(), model.getName());
	}

}
