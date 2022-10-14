package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {

	private int id;

	private String title;

	private Date timeLimit;

	private boolean isDone;
}
