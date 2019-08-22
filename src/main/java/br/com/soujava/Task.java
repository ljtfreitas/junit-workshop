package br.com.soujava;

import static java.lang.Thread.sleep;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

class Task {

	final String id;
	final String name;
	final LocalTime startTime;
	final Duration duration;

	Task(String name, LocalTime startTime, Duration duration) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.startTime = startTime;
		this.duration = duration;
	}

	TaskResult execute() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {}

		return new TaskResult(String.format("Task [%s] executed", name));
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Task) {
			return ((Task) obj).id.equals(id);
		} else {
			return false;
		}
	}

}
