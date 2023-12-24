package com.submit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.submit.dto.FormDto;
import com.submit.service.FormService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FormController {

	// CRUD create post, read get , update put , delete delte

	@Autowired
	private FormService formService;

	@PostMapping("/create-form")
	public FormDto createForm(@RequestBody FormDto formDto) {
		log.info("inside createForm() , data : {}", formDto);
		return formService.createForm(formDto);

	}

	@GetMapping("/get-all")
	public List<FormDto> getAllForm() {
		log.info("trying to get");
		return formService.getAllForm();

	}

	@GetMapping("/get-all/{firstName}")
	public List<FormDto> getAllFormByFirstname(@PathVariable(name = "firstName") String firstname) {
		log.info("trying to get by first name");
		return formService.getAllFormByFirstName(firstname);

	}

	@PutMapping("/update/{id}")
	public FormDto updateForm(@RequestBody FormDto dto, @PathVariable int id) {
		return formService.updateForm(dto, id);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return formService.deleteForm(id);
	}

}
