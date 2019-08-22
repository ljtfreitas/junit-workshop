package br.com.soujava;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@DisplayName("Exemplos de testes condicionais")
class ConditionsTest {

	@Test
	@Disabled("Esse teste está desabilitado...há um bug no código!")
	void disabledTest() {
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Esse teste roda apenas no Linux!")
	void testOnLinux() {
	}

	@Test
	@EnabledOnOs(OS.MAC)
	@DisplayName("Esse teste roda apenas no Mac!")
	void testOnMac() {
	}

	@Test
	@EnabledOnOs({ OS.LINUX, OS.MAC })
	@DisplayName("Esse teste roda apenas no Linux ou no Mac!")
	void testOnLinuxOrMac() {
	}

	@Test
	@EnabledOnJre(JRE.JAVA_8)
	@DisplayName("Esse teste roda apenas no Java 8!")
	void testOnJre8() {
	}

	@Test
	@EnabledOnJre(JRE.JAVA_9)
	@DisplayName("Esse teste roda apenas no Java 9!")
	void testOnJre9() {
	}

	@Test
	@EnabledIfEnvironmentVariable(named = "my.env.variable", matches = "whatever")
	@DisplayName("Esse teste roda apenas se houver uma variável de ambiente 'my.env.variable'!")
	void testWithEnvironmentVariable() {
	}

	@Test
	@EnabledIfSystemProperty(named = "my.system.property", matches = "whatever")
	@DisplayName("Esse teste roda apenas se houver uma system property da JVM chamada 'my.system.property'!")
	void testWithSystemProperty() {
	}

}
