package com.example;

import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Javalin createApp() {
		// Javalin app = Javalin.create(config -> {
		// 	config.enableCorsForAllOrigins();
		// 	config.defaultContentType = "application/json";
		// });
		
		// app.get("/", ctx -> ctx.result("Hello World!"));
		
		// return app;
		return Javalin.create().get("/hello", ctx -> ctx.result("Hello World!"));
	}

	public static void main(String[] args) {
		Javalin app = createApp();
		app.start(7000);
		System.out.println("Server started on port 7000");
	}
}
