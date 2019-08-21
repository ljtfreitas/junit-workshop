package br.com.soujava;

import java.time.LocalTime;

class TooLateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	final LocalTime lateTime;

	TooLateException(String message, LocalTime lateTime) {
		super(message);
		this.lateTime = lateTime;
	}
}
