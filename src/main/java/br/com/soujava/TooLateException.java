package br.com.soujava;

import java.time.LocalTime;

class TooLateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	LocalTime lateTime;

	TooLateException(String message) {
		super(message);
	}
}
