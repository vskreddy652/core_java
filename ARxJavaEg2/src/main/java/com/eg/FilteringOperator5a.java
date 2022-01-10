package com.eg;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
//Using take operator to filter an Observable
public class FilteringOperator5a  {
 public static void main(String[] args) {    
    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    final StringBuilder result = new StringBuilder();
    Observable<String> observable = Observable.fromArray(letters);
    observable
       .take(2)
       .subscribe( letter -> result.append(letter));
    System.out.println(result);
    
    observable.take(3).subscribe(new Observer<String>(){
		@Override
		public void onComplete() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNext(String arg0) {
			System.out.println(arg0);
			
		}

		@Override
		public void onSubscribe(Disposable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onError(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}
});
    
    observable.first("default str").subscribe((v)->{System.out.println(v);});
 }
}
