package com.eg;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
//Using take operator to filter an Observable
public class FilteringOperator5b  {
 public static void main(String[] args) {    
    String[] letters = {"a", "b", "a", "d", "b", "f", "g"};
    final StringBuilder result = new StringBuilder();
    Observable<String> observable = Observable.fromArray(letters);
    observable
       .distinct()
       .subscribe( letter -> result.append(letter));
    System.out.println(result);
    
    observable.buffer(3).subscribe((v)->{System.out.println(v);});
    
    Maybe<String> mbs = observable.firstElement(); //firstElement
    mbs.subscribe((v)->{System.out.println(v);});
    
    Single<String> sis= observable.lastOrError();
    sis.subscribe((v)->{System.out.println(v);});
 }
}
