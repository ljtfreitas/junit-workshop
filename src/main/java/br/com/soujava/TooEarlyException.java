package br.com.soujava;

import java.time.LocalTime;

class TooEarlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	LocalTime earlyTime;

	TooEarlyException(String message) {
		super(message);
	}
}
