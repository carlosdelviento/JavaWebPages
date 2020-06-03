package com.in28minutes.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28minutes.todo.TodoService;

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

	// private TodoService todoValidationService = new TodoService();
	private TodoService todoService = new TodoService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newTodo = request.getParameter("todo").trim();

		boolean isTodoValid = todoService.istodoValid(newTodo);

		if (isTodoValid) {
			todoService.addTo(new Todo(newTodo));
			response.sendRedirect("/todo.do");
		} else {
			request.setAttribute("todos", todoService.retrieveTodos());
			request.setAttribute("errorMessage", "Invalid Todo Text!");
			request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
		}
	}

}