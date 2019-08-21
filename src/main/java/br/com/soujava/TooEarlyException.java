package br.com.soujava;

class TooEarlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	TooEarlyException(String message) {
		super(message);
	}
}
