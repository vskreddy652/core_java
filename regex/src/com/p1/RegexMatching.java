package com.p1;

import java.util.regex.*;

public class RegexMatching {
	public static void main(String[] args) {
		Pattern pt = Pattern.compile(".s.{0,4}");
		//. is single character

		Matcher mt = pt.matcher("bsakhksduhfis");  
		boolean b = mt.matches(); 
		
		if(b)
		{
			System.out.println("Pattern matches");
		}
		else
		{
			System.out.println("Pattern doesn't match");
		}
	}
}
