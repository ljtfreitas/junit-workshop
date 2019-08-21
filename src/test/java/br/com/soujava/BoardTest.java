package br.com.soujava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void shouldAddNewTaskToBoard() {
		Board board = new Board();

        board.addTask("Whatever", LocalTime.parse("09:00"), Duration.ofHours(1));

        List<Task> tasks = board.tasks();

        assertEquals(1, tasks.size());
	}

}
