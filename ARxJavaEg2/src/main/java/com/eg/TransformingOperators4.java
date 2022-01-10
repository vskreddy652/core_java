package com.eg;

import io.reactivex.Observable;
//Using map operator to transform an Observable
public class TransformingOperators4  { 
 public static void main(String[] args) {    
    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    final StringBuilder result = new StringBuilder();
    Observable<String> observable = Observable.fromArray(letters);
    observable
       .map(String::toUpperCase)
       .subscribe( letter -> result.append(letter));
       //.subscribe( letter -> result.append(letter), (v)->{});
    System.out.println(result);
 }
}
