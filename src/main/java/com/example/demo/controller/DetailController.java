package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Todo;
import com.example.demo.form.TodoForm;
import com.example.demo.repository.TodoMapper;

public class DetailController {

	@Autowired
	private TodoMapper todoMapper;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/detail/{id:.+}")
	public String getDetail(Model model, @ModelAttribute TodoForm form, @PathVariable("id") int id) {

		Todo todo = todoMapper.findOne(id);

		form = modelMapper.map(todo, TodoForm.class);

		model.addAttribute("form", form);

		return "details";
	}

}
