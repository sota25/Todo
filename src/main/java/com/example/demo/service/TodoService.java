package com.example.demo.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	public Map<String, String> getIdDone() {

		Map<String, String> isDoneMap = new LinkedHashMap<>();

		isDoneMap.put("完了フラグ", "true");

		return isDoneMap;
	}
}
