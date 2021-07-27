package com.p1;

import java.util.regex.*;

public class RegexReplace {
	public static void main(String[] args) {
        Pattern pt = Pattern.compile("\\s+");
        Matcher mt = pt.matcher("ba  aaa  sskdjsh  fkdsj");
        System.out.println("Replaced String: "+mt.replaceAll("zzz"));
	}
}
