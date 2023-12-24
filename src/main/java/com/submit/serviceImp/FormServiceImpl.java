package com.submit.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.submit.dto.FormDto;
import com.submit.exception.FormException;
import com.submit.model.Form;
import com.submit.repo.FormRepo;
import com.submit.service.FormService;
import com.submit.utility.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FormServiceImpl implements FormService {

	@Autowired
	private Utility utility;

	@Autowired
	private FormRepo formRepo;

	@Override
	public FormDto createForm(FormDto dto) {
		try {
			log.info("inside FormServiceImpl , data : {}", dto);
			Form entity = utility.dtoToEntity(dto);
			log.info("after converting to entity : dto {} and entity {}", dto, entity);
			log.info("trying to insert into db");
			Form save = formRepo.save(entity);
			log.info("successfully saved into db");
			FormDto entityTodto = utility.entityTodto(save);
			return entityTodto;

		} catch (Exception e) {
			log.error("error msg :", e);
			throw new FormException("unable to insert into db");
		}
	}

	@Override
	public List<FormDto> getAllForm() {
		log.info("trying to fetch from db");
		List<Form> findAll = formRepo.findAll();
		return findAll.stream().map(e -> utility.entityTodto(e)).collect(Collectors.toList());

	}

	@Override
	public List<FormDto> getAllFormByFirstName(String firstName) {
		return formRepo.findAllByfirstName(firstName).stream().map(utility::entityTodto).collect(Collectors.toList());
	}

	@Override
	public FormDto updateForm(FormDto dto, int id) {
		try {

			Form db = formRepo.findById(id).orElseThrow(() -> new FormException("Unable to feach data"));
			if (dto.getFirstName() != null) {
				db.setFirstName(dto.getFirstName());
			}
			if (dto.getLastName() != null) {
				db.setLastName(dto.getLastName());
			}
			if (dto.getDob() != null) {
				db.setDob(dto.getDob());
			}
			if (dto.getGender() != null) {
				db.setGender(dto.getGender());
			}
			Form save = formRepo.save(db);

			return utility.entityTodto(save);

		} catch (Exception e) {
			log.error("error = ", e);
			throw new FormException("Unable to update");
		}
	}

	@Override
	public String deleteForm(int id) {

		try {
			formRepo.deleteById(id);
			return "success";
		} catch (Exception e) {
			log.error("error = ", e);
			return "failed";
		}

	}

}
