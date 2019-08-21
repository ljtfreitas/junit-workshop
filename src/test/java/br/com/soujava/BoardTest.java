package br.com.soujava;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes do quadro de tarefas")
class BoardTest {

	Board board;

	@BeforeEach
	void setup() {
		board = new Board();
	}

	@DisplayName("Deve adicionar uma nova tarefa no quadro")
	@Test
	void shouldAddNewTaskToBoard() {
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
		LocalTime tooEarlyTime = LocalTime.parse("08:00");

		TooEarlyException exception = assertThrows(TooEarlyException.class,
				() -> board.addTask("Whatever", tooEarlyTime, Duration.ofHours(1)));
		
		assertEquals(tooEarlyTime, exception.earlyTime);
	}

	@DisplayName("Nao deve permitir criar tarefas apos as 19:00")
	@Test
	void shouldThrowExceptionWhenTaskStartsTooLate() {
		LocalTime tooLateTime = LocalTime.parse("19:30");

		TooLateException exception = assertThrows(TooLateException.class,
				() -> board.addTask("Whatever", tooLateTime, Duration.ofHours(1)));

		assertEquals(tooLateTime, exception.lateTime);
	}
}
