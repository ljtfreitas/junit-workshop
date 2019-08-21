package br.com.soujava;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

class Board {

	private static final LocalTime FIRST_HOUR_OF_DAY = LocalTime.parse("09:00");
	private static final LocalTime LAST_HOUR_OF_DAY = LocalTime.parse("19:00");

	private final List<Task> tasks = new LinkedList<>();

	Task addTask(String name, LocalTime startTime, Duration duration) {
		if (startTime.isBefore(FIRST_HOUR_OF_DAY)) {
            throw new TooEarlyException(startTime + " it's too early...Go to bed", startTime);
        }
		if (startTime.plus(duration).isAfter(LAST_HOUR_OF_DAY)) {
            throw new TooLateException(startTime + " it's later...Go to TV", startTime);
        }

		Task newTask = new Task(name, startTime, duration);
		
		tasks.add(newTask);
		
		return newTask;
	}

	void remove(Task task) {
		tasks.remove(task);
	}

	List<Task> tasks() {
		return tasks;
	}

}
