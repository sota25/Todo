package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoForm {

	@NotBlank
	private String title;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timeLimit;

	private boolean isDone;

}
