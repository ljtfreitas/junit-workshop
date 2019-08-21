package br.com.soujava;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes do quadro de tarefas")
class BoardTest {

	@DisplayName("Deve adicionar uma nova tarefa no quadro")
	@Test
	void shouldAddNewTaskToBoard() {
		Board board = new Board();

		board.addTask("Whatever", LocalTime.parse("09:00"), Duration.ofHours(1));

		List<Task> tasks = board.tasks();

		assertEquals(1, tasks.size());

		Task newTask = tasks.get(0);

		assertAll(() -> assertEquals("Whatever", newTask.name),
				  () -> assertEquals(LocalTime.parse("09:00"), newTask.startTime),
				  () -> assertEquals(Duration.ofHours(1), newTask.duration));
	}

	@DisplayName("Nao deve permitir criar tarefas antes das 09:00")
	@Test
	void shouldThrowExceptionWhenTaskStartsEarly() {
		Board board = new Board();

		assertThrows(IllegalArgumentException.class,
				() -> board.addTask("Whatever", LocalTime.parse("08:00"), Duration.ofHours(1)));
	}

	@DisplayName("Nao deve permitir criar tarefas apos as 19:00")
	@Test
	void shouldThrowExceptionWhenTaskStartsTooLate() {
		Board board = new Board();

		assertThrows(IllegalArgumentException.class,
				() -> board.addTask("Whatever", LocalTime.parse("19:30"), Duration.ofHours(1)));
	}

}
