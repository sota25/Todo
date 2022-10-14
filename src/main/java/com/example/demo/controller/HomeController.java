package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoMapper;

@Controller
public class HomeController {

	@Autowired
	private TodoMapper todoMapper;

	@GetMapping("/")
	public String getHome(Model model) {
		List<Todo> notDoneTodo = todoMapper.findNotDone();
		List<Todo> isDoneTodo = todoMapper.findIsDone();
		
		System.out.println(notDoneTodo);
		System.out.println(isDoneTodo);

		
		model.addAttribute("notDoneTodo",notDoneTodo);

		model.addAttribute("isDoneTodo",isDoneTodo);

		return "home";
	}

	@PostMapping("/")
	public String postDeleteTodo(Model model) {

		return "redirect:/";
	}

}
