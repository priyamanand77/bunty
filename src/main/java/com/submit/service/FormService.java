package com.submit.service;

import java.util.List;

import com.submit.dto.FormDto;

public interface FormService {

	// 1. create form

	FormDto createForm(FormDto dto);

	// 2 get all form

	List<FormDto> getAllForm();

	// 3. get form by first_name

	List<FormDto> getAllFormByFirstName(String firstName);

	// 4. update form
	FormDto updateForm(FormDto dto, int id);
	// 5. delete form

	String deleteForm(int id);

}
