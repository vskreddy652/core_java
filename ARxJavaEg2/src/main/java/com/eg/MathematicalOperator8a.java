package com.eg;

import io.reactivex.Observable;
import io.reactivex.Single;
import rx.observables.MathObservable;
//Using concat operator to operate on multiple Observables
public class MathematicalOperator8a  {
 public static void main(String[] args)  throws InterruptedException {    
    Integer[] numbers = { 1, 2, 3, 4, 5, 6};

    Observable<Integer> observable1 = Observable.fromArray(numbers);

    observable1.count().subscribe((v)->{System.out.println(v);});
    
    observable1.reduce((v1,v2)->v2+v1).subscribe((v)->{System.out.println(v);});
 }
}
