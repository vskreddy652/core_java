package com.eg;
import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubject9  {
   public static void main(String[] args) {   
      final StringBuilder result1 = new StringBuilder();
      final StringBuilder result2 = new StringBuilder();         
      BehaviorSubject<String> subject =  BehaviorSubject.create(); 
      subject.subscribe(value -> result1.append(value) ); 
      subject.onNext("a"); 
      subject.onNext("b"); 
      subject.onNext("c"); 
      subject.subscribe(value -> result2.append(value)); 
      subject.onNext("d"); 
      subject.onComplete();
      //Output will be abcd
      System.out.println(result1);
      //Output will be cd being BehaviorSubject 
      //(c is last item emitted before subscribe)
      System.out.println(result2);
   }
}