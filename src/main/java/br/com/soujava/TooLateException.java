package br.com.soujava;

import java.time.LocalTime;

class TooLateException extends HorribleTimeToDoSomethingException {

	private static final long serialVersionUID = 1L;

	TooLateException(String message, LocalTime lateTime) {
		super(message, lateTime);
	}
}
