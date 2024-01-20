module by.jprof.impl.be {
	requires by.jprof.api;
	provides by.jprof.api.GreetingsService with by.jprof.impl.be.GreetingsServiceBe;
}
