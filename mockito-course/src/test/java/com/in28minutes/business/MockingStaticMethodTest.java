package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


/*@RunWith(MockitoJUnitRunner.class) = MockitoJUnit.rule()ublic MockitoRule mockitoRule */
public class MockingStaticMethodTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	TodoService todoServiceMock;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;


	@Test
	public void testRetrievetodosRelatedToString_usingAMock() {

		//TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring",
				"Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		//TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}


	@Test
	public void testDeletetodosRelatedToString_usingAMock() {

		//TodoService todoServiceMock = mock(TodoService.class);


		//Given
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring",
				"Learn to Dance");

		BDDMockito.given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceMock);

		//when
		todoBusinessImpl
				.deleteTodosNotRelatedToSpring("Dummy");

		//then

		BDDMockito.then(todoServiceMock).should().deleteTodo("Learn Spring MVC");

		BDDMockito.then(todoServiceMock).should(never()).deleteTodo("Learn Spring");

		BDDMockito.then(todoServiceMock).should(never()).deleteTodo("Learn to Dance");

	}

	@Test
	public void testDeletetodosRelatedToString_usingAMock_2() {

		TodoService todoServiceMock = mock(TodoService.class);

		//Declare Argument Captor

		//ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		//Given
		List<String> todos = Arrays.asList("Learn to Rock and Roll","Learn Spring",
				"Learn to Dance");

		BDDMockito.given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceMock);

		//when
		todoBusinessImpl
				.deleteTodosNotRelatedToSpring("Dummy");


		//then
		BDDMockito.then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
	}
}

















