package com.eg;

import io.reactivex.subjects. AsyncSubject;
public class AsyncSubject  {
   public static void main(String[] args) {   
      final StringBuilder result1 = new StringBuilder();
      final StringBuilder result2 = new StringBuilder();         

      AsyncSubject<String> subject =  AsyncSubject.create(); 
      subject.subscribe(value -> result1.append(value) ); 
      subject.onNext("a"); 
      subject.onNext("b"); 
      subject.onNext("c"); 
      subject.subscribe(value -> result2.append(value)); 
      subject.onNext("d"); 
      subject.onComplete();

      //Output will be d being the last item emitted
      System.out.println(result1);
      //Output will be d being the last item emitted     
      System.out.println(result2);
   }
}