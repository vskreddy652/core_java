package com.eg;

import io.reactivex.subjects.PublishSubject;
public class PublishSubject11  {
   public static void main(String[] args) {   
      final StringBuilder result1 = new StringBuilder();
      final StringBuilder result2 = new StringBuilder();         

      PublishSubject<String> subject = PublishSubject.create(); 
      subject.subscribe(value -> result1.append(value) ); 
      subject.onNext("a"); 
      subject.onNext("b"); 
      subject.onNext("c"); 
      subject.subscribe(value -> result2.append(value)); 
      subject.onNext("d"); 
      subject.onComplete();

      //Output will be abcd 
      System.out.println(result1);
      //Output will be d only
      //as subscribed after c item emitted.
      System.out.println(result2);
   }
}
