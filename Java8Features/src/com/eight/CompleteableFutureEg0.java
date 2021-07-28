package com.eight;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompleteableFutureEg0 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> welcomeText = CompletableFuture
				.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(5);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Kumar";
		}).thenApply(name -> {
		    return "Hello " + name;
		}).thenApply(greeting -> {
			System.out.println("Hellooooooooooooooooo");
		    return greeting + ", Welcome to all of you";
		});

		
		/* thenApply() takes previous return, processes and further returns
		 thenAccept() takes previous return, processes, further does not return
		 thenRun() doesn’t even have access to the Future’s result. 
		 It takes a Runnable and returns CompletableFuture<Void>
		 */
		
		System.out.println("Is this printed");
		System.out.println(welcomeText.get());


	}
}
