package com.eg;
import java.util.concurrent.TimeUnit;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

public class MayBeObservable2 {
   public static void main(String[] args) throws InterruptedException {
      //Create an observer
      Disposable disposable = Maybe.just("Hello World")
         .delay(2, TimeUnit.SECONDS, Schedulers.io())
         //.subscribe((v)->{})
         .subscribeWith(new DisposableMaybeObserver<String>() {
         @Override
         public void onError(Throwable e) { 
            e.printStackTrace();
         }

         @Override
         public void onSuccess(String value) {
            System.out.println(value);
         }

         @Override
         public void onComplete() {
            System.out.println("Done!");
         }
      }); 
      Thread.sleep(3000);
      //start observing
      disposable.dispose();
   }
}
