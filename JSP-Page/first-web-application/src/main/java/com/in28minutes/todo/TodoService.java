package com.in28minutes.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo("Learn Web Application Develoment"));
		todos.add(new Todo("Learn Spring MVC"));
		todos.add(new Todo("Learn Spring Rest Service"));
	}

	public List<Todo> retrieveTodos() {
		return todos;
	}

	public void addTo(Todo todo) {
		todos.add(todo);
	}

	public void deleteTodo(Todo todo) {
		todos.remove(todo);
	}

	public boolean istodoValid(String newTodo) {
		if ((newTodo.trim().length() > 0) || (newTodo.matches(".*\\w.*")))
			return true;

		return false;
	}
}