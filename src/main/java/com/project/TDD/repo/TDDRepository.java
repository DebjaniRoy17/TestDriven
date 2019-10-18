package com.project.TDD.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.TDD.model.TDDModel;

@Repository("tddRepository")
public interface TDDRepository extends JpaRepository<TDDModel, Long>{

}
