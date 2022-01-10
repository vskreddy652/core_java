package com.eg;

import io.reactivex.Observable;
//Using defaultIfEmpty operator to operate on an Observable
public class ConditionalOperator7  {
 public static void main(String[] args) {    
    String[] chars1 = {"a", "b", "c", "d", "e", "f", "g"};
    Observable<String> obs1 = Observable.fromArray(chars1);
    
    String[] chars2 = {"a", "b", "c", "d", "e", "f", "g"};
    Observable<String> obs2 = Observable.fromArray(chars2);

    Observable.sequenceEqual(obs1, obs2).subscribe((v)->{System.out.println(v);});
 }
}