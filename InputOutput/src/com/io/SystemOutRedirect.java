package com.io;

import java.io.*;

public class SystemOutRedirect {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("abc.txt"));

		byte b[] = new byte[50];

		System.in.read(b);

		System.out.println("Read content is: " + new String(b));
		
	}
}
