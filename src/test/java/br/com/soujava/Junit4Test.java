package br.com.soujava;

import org.junit.Assert;
import org.junit.Test;

public class Junit4Test {

	@Test
	public void failWithJunit4() {
		Assert.fail("running on junit 4...");
	}
}
