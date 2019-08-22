package br.com.soujava;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@DisplayName("Testes de tarefas")
class TaskTest {

	@DisplayName("Deve executar a tarefa sem exceder o tempo limite")
	@Test
	@Timeout(unit = TimeUnit.SECONDS, value = 2)
	void shouldExecuteTaskWithoutExceedTimeout() {
		Task task = new Task("Do something", LocalTime.parse("09:00"), Duration.ofHours(1));

		TaskResult result = task.execute();
		
		assertNotNull(result.description);
	}

}
