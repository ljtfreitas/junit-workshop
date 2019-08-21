package br.com.soujava;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.time.Duration;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

class HorribleTimesToDoSomethingArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(arguments("08:30", Duration.ofHours(1)),
				  		 arguments("19:30", Duration.ofHours(2)),
				  		 arguments("18:30", Duration.ofHours(1)),
				  		 arguments("16:00", Duration.ofHours(4)));
	}
}
