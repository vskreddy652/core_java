package com.eg;

import io.reactivex.Observable;
//Using fromArray operator to create an Observable
public class CreatingOperators3  {
 public static void main(String[] args) { 
    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    final StringBuilder result = new StringBuilder();
    Observable<String> observable = Observable.fromArray(letters);
    observable
       .map(String::toUpperCase)
       .subscribe( letter -> result.append(letter));
    System.out.println(result);
 }
}
