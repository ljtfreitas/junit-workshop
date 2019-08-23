package br.com.soujava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTest {

	@Test
	@Order(1)
	void test1() {
		fail("Esse é o primeiro teste...");
	}

	@Test
	@Order(1)
	void test2() {
		fail("Esse é o segundo teste...");
	}

	@Test
	@Order(1)
	void test3() {
		fail("Esse é o terceiro teste...");
	}
}
