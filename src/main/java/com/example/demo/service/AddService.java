package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;

@Service
public interface AddService {

	public void add(Todo todo);
}
