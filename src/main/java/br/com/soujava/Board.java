package br.com.soujava;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

class Board {

	private List<Task> tasks = new LinkedList<>();

	Task addTask(String name, LocalTime startTime, Duration duration) {
		Task newTask = new Task(name, startTime, duration);
		
		tasks.add(newTask);
		
		return newTask;
	}

	List<Task> tasks() {
		return tasks;
	}
}
