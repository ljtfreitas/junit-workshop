package br.com.soujava;

class TooLateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	TooLateException(String message) {
		super(message);
	}
}
