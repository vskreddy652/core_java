package com.eg;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
//Using defaultIfEmpty operator to operate on an Observable
public class ConditionalOperator7b  {
 public static void main(String[] args) {    
	 Observable
     .create(emitter -> {
         for(int i=0; i<= 6; i++) {
             Thread.sleep(1000);
             emitter.onNext(i);
         }
         emitter.onComplete();
     })
     .skipWhile(new Predicate<Object>() {
         @Override
         public boolean test(Object o) throws Exception {
             return (((Integer)o < 2));
         }
     })
     .subscribe(new Observer<Object>() {
         @Override
         public void onSubscribe(Disposable d) {

         }

         @Override
         public void onNext(Object o) {
             System.out.println("onNext: " + o);
         }

         @Override
         public void onError(Throwable e) {

         }

         @Override
         public void onComplete() {

         }
     }); 
 }
}