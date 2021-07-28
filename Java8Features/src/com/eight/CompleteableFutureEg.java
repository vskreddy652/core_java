package com.eight;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompleteableFutureEg {
	public static void main(String[] args) {
		try {
			List<Integer> list = Arrays.asList(5, 9, 14);
			list.stream()
			.map(num -> CompletableFuture.supplyAsync(() -> getNumber(num)).thenApply(n -> n * n))
			.map(t -> t.join())
			.forEach(s -> System.out.println(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int getNumber(int a) {
		return a * a;
	}
}
