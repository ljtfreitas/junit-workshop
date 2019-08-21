package br.com.soujava;

import java.time.LocalTime;

class HorribleTimeToDoSomethingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	final LocalTime horribleTime;

	public HorribleTimeToDoSomethingException(String message, LocalTime horribleTime) {
		super(message);
		this.horribleTime = horribleTime;
	}

}
