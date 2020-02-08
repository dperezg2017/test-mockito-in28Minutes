package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {


	@Test
	public void testRetrievetodosRelatedToString_usingAMock() {


		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance","Learn Spring MVC");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}