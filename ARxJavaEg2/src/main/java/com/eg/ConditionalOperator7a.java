package com.eg;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
//Using defaultIfEmpty operator to operate on an Observable
public class ConditionalOperator7a  {
 public static void main(String[] args) {    
     Observable<Integer> observable1 = Observable
             .create(emitter -> {
                 for(int i=0; i<= 6; i++) {
                     Thread.sleep(1000);
                     emitter.onNext(i);
                 }
                 emitter.onComplete();
             });

     Observable<Integer> observable2 = Observable
             .timer(3, TimeUnit.SECONDS)
             .flatMap(__ -> Observable.just(11, 12, 13, 14, 15, 16));

     observable1.skipUntil(observable2).subscribe((v)->{System.out.println(v);});
             
 }
}