package by.jprof.app;

import by.jprof.api.GreetingsService;

import java.util.ServiceLoader;

public class Main {
	public static void main(String[] args) {
		final ServiceLoader<GreetingsService> loader = ServiceLoader.load(GreetingsService.class);

		for (GreetingsService greetingsService : loader) {
			System.out.println(greetingsService.greet("world"));
		}
	}
}
