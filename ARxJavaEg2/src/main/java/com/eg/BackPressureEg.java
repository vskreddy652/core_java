package com.eg;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class BackPressureEg {
	public static void main(String[] args) {
		Flowable<Integer> flow = Observable.range(1, 1_000_000).toFlowable(BackpressureStrategy.DROP);
	
		flow.subscribe((v)->{System.out.println(v);});
	}
}