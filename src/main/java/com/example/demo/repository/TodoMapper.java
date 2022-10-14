package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Todo;

@Mapper
public interface TodoMapper {

	public int insertOne(Todo todo);

	public List<Todo> findAll();
	
	public List<Todo> findIsDone();
	
	public List<Todo> findNotDone();

	public Todo findOne(int id);

	public int updateOne(Todo todo);

	public int deleteOne(int id);
}
