package com.eight;

interface Moveable {
    default void move(){
        System.out.println("I am moving");
    }
}

public class Animal implements Moveable{
    public static void main(String[] args){
        Animal tiger = new Animal();
        tiger.move();
    }
}
