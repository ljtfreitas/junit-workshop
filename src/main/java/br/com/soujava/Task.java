package br.com.soujava;

import java.time.Duration;
import java.time.LocalTime;

class Task {

	final String name;
	final LocalTime startTime;
	final Duration duration;

	Task(String name, LocalTime startTime, Duration duration) {
		this.name = name;
		this.startTime = startTime;
		this.duration = duration;
	}

}
