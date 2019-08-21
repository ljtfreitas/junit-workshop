package br.com.soujava;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

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

	@TestFactory
    @DisplayName("Testes de horarios de descanso")
    Stream<DynamicTest> tasksInBreakTimes() {
        return Stream.of(TaskArguments.of("08:30", 1), TaskArguments.of("18:30", 1), TaskArguments.of("16:00", 5))
                .map(task -> 
                		dynamicTest("Nao deve permitir uma tarefa comecando as " + task.time + " com " + task.duration.toHours() + "h de duracao",
                				() -> assertThrows(HorribleTimeToDoSomethingException.class, () -> board.addTask("Whatever", task.time, task.duration))));
    }
	
	@DisplayName("Deve remover uma tarefa do quadro")
	@Test
	void shouldRemoveTaskFromBoard() {
		Task newTask = board.addTask("Do Something", LocalTime.parse("14:00"), Duration.ofHours(2));

		board.remove(newTask);

		assertTrue(board.tasks().isEmpty());
	}
	
	static class TaskArguments {

		final LocalTime time;
		final Duration duration;
		
		private TaskArguments(LocalTime time, Duration duration) {
			this.time = time;
			this.duration = duration;
		}

		static TaskArguments of(String time, int hours) {
			return new TaskArguments(LocalTime.parse(time), Duration.ofHours(hours));
		}
	}
}
