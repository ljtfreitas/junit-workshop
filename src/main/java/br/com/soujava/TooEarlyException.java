package br.com.soujava;

import java.time.LocalTime;

class TooEarlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	final LocalTime earlyTime;

	TooEarlyException(String message, LocalTime earlyTime) {
		super(message);
		this.earlyTime = earlyTime;
	}
}
