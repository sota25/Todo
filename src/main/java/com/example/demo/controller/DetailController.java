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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Todo;
import com.example.demo.form.TodoForm;
import com.example.demo.repository.TodoMapper;
import com.example.demo.service.TodoService;

@Controller
public class DetailController {

	@Autowired
	private TodoService service;

	@Autowired
	private TodoMapper todoMapper;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/{id:.+}")
	public String getDetail(Model model, @ModelAttribute TodoForm form, @PathVariable("id") int id) {

		Todo todo = todoMapper.findOne(id);
		System.out.println(todo);

		form = modelMapper.map(todo, TodoForm.class);
		System.out.println(form);

		model.addAttribute("todoForm", form);

		Map<String, String> isDoneMap = service.getIdDone();
		model.addAttribute("isDoneMap", isDoneMap);

		return "details";
	}

	@PostMapping("/{id:.+}")
	public String postDetail(Model model, @ModelAttribute @Validated TodoForm form, BindingResult result,
			@PathVariable("id") int id) {

		if (result.hasErrors()) {
			return getDetail(model, form, id);
		}

		Todo todo = todoMapper.findOne(id);

		todo.setTitle(form.getTitle());
		todo.setTimeLimit(form.getTimeLimit());
		todo.setDone(form.isDone());

		todoMapper.updateOne(todo);

		return "redirect:/";
	}

}
