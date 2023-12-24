package com.submit.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormDto {
	private int id;
	private String firstName;
	private String lastName;
	private Timestamp dob;
	private String gender;

}
