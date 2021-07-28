package com.eight;

import java.util.TreeSet;

@FunctionalInterface
interface Square 
{ 
    int calculate(int x); //SAM
    
    //void display();
} 
  
public class FunctionalInterfaceEg 
{ 
	static void met(Square ps){
		for(int i=0;i<3;i++){
			System.out.println(ps.calculate(10));
		}
	}
	
    public static void main(String args[]) 
    { 
        met(
        		(a)->a*a*a
        		);
        
        /*met(new Square(){
        	public int calculate(int p){
        		return p*p*p;
        	}
        });*/
        
        //TreeSet<String> ts = new TreeSet<>((s1,s2)->s1.length()-s2.length());
        
        int a = 5; 
        // lambda expression to define the calculate method 
        Square s = (int x)->x*x; 
  
        // parameter passed and return type must be 
        // same as defined in the prototype 
        int ans = s.calculate(a); 
        System.out.println(ans); 
    } 
} 
