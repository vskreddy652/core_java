package com.eg;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
public class SubjectExamplee12  {
   public static void main(String[] args) {   
     Observable<Integer> source1 = Observable.fromArray(1,2,3,4,5);
     Observable<Integer> source2 = Observable.fromArray(6,7,8,9,10);

      PublishSubject<Integer> subject = PublishSubject.create(); 
      subject.subscribe(value -> {System.out.println(value);} ); 
      
      source1.subscribe(subject);
      source2.subscribe(subject);
   }
}
