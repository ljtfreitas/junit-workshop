package br.com.soujava;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes de tarefas")
class TaskTest {

	@DisplayName("Deve executar a tarefa sem exceder o tempo limite")
	@Test
	void shouldExecuteTaskWithoutExceedTimeout() {
		Task task = new Task("Do something", LocalTime.parse("09:00"), Duration.ofHours(1));

		assertTimeout(Duration.ofSeconds(2), () -> task.execute());
	}

}
