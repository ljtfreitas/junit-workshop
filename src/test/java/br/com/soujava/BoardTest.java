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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@DisplayName("Nao deve permitir criar tarefas em horarios de descanso")
    @ParameterizedTest
    @ValueSource(strings = {"08:30", "19:30"})
    void shouldThrowExceptionWhenTaskStartsInBreakTimes(String time) {
        LocalTime horribleTimeToDoSomething = LocalTime.parse(time);

        HorribleTimeToDoSomethingException exception = assertThrows(HorribleTimeToDoSomethingException.class,
                () -> board.addTask("Whatever", horribleTimeToDoSomething, Duration.ofHours(1)));
        
        assertEquals(horribleTimeToDoSomething, exception.horribleTime);
    }
}
