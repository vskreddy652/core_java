package com.ab;

enum SingletonEg {
	INSTANCE;
	private String name;
	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static SingletonEg getSingleton() { 
		return INSTANCE;
	}

	public void print() {
		System.out.println("Name: " + name + ", age: " + age);
	}
}

public class EnumSingleton {
	public static void main(String[] args) {
		SingletonEg se = SingletonEg.getSingleton();
		se.setName("some name");
		se.setAge(25);
		SingletonEg.getSingleton().print();
	}
}
