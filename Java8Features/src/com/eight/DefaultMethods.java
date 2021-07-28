package com.eight;

interface MyInterface{
	//interface cannot have instance variables and cosntructor
	/*MyInterface(){
		
	}*/
	int met1();
	
	default void met2(){
		System.out.println("met2() in MyInterface");
	}
	
	static void mets(){
		System.out.println("mets() in MyInterface");
	}
}

class MyClass implements MyInterface{

	@Override
	public int met1() {
		System.out.println("met1() in MyClass");
		return 0;
	}
	
	public void met2(){
		System.out.println("met2() in MyClass");
	}
}

public class DefaultMethods {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.met1();
		obj.met2();
		
		MyInterface.mets();
	}
}
