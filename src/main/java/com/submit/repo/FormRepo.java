package com.submit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.submit.model.Form;

public interface FormRepo extends JpaRepository<Form, Integer>{

	List<Form> findAllByfirstName(String firstName);
}
