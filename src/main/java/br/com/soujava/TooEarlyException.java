package br.com.soujava;

import java.time.LocalTime;

class TooEarlyException extends HorribleTimeToDoSomethingException {

	private static final long serialVersionUID = 1L;

	TooEarlyException(String message, LocalTime earlyTime) {
		super(message, earlyTime);
	}
}
