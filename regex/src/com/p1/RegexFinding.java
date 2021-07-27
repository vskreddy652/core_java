package com.p1;

import java.util.regex.*;

//fnhdsfjsd;2334ds;bsdciudi;bdsiucdcsd;

//.*;

public class RegexFinding {
	public static void main(String[] args) {
		//Pattern pt = Pattern.compile("s+"); //number of email ids
		Pattern pt = Pattern.compile(".s.");
		//one or more s


		Matcher mt = pt.matcher("bsaaaasskdjshfkdsj");  
		//Matcher mt = pt.matcher("fnhdsfjsd;2334ds;bsdciudi;bdsiucdcsd;");
		int find_count = 0;
		
		while(mt.find())
		{
			find_count++;
			System.out.println("Find Start:"+mt.start());
			System.out.println("Find End:"+mt.end());
			
			System.out.println(mt.group()); //extract matching substring
		}
		
		System.out.println("Total number of occurrences:"+find_count);
	}
}
