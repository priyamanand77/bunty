package com.submit.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.submit.dto.FormDto;
import com.submit.model.Form;

@Component
public class Utility {

	// model-mapper

	public Form dtoToEntity(FormDto dto) {
		Form entity = new Form();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public FormDto entityTodto(Form entity) {
		FormDto dto = new FormDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
