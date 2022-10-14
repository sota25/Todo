package com.example.demo.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Todo;
import com.example.demo.form.TodoForm;
import com.example.demo.repository.TodoMapper;
import com.example.demo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AddController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private TodoMapper todoMapper;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/add")
	public String getAdd(Model model, @ModelAttribute TodoForm form) {

		Map<String, String> isDoneMap = todoService.getIdDone();

		model.addAttribute("isDoneMap", isDoneMap);
		return "add";
	}

	@PostMapping("/add")
	public String postAdd(Model model, @ModelAttribute @Validated TodoForm form, BindingResult result) {

		if (result.hasErrors()) {
			return getAdd(model, form);
		}

		log.info(form.toString());

		Todo todo = modelMapper.map(form, Todo.class);

		todoMapper.insertOne(todo);

		return "redirect:/";
	}
}
