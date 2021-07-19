package com.io;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
import java.io.*;

class KeyboardInput {
	public static void main(String args[]) throws Exception {

		// System.out is standard output
		// System.err is standard error output
		// System.in is standard input stream
		// System is class, in is object of InputStream class
		// InputStreamReader r=new InputStreamReader(new
		// FileInputStream("./abc1.txt"));
		InputStreamReader r = new InputStreamReader(System.in);

		// System.in.read();
		/*
		 * InputStreamReader changes byte based stream to character based reader
		 */
		BufferedReader br = new BufferedReader(r);

		// System.in.read(); //reads one character from keyboard

		String name = "";

		// ! is Logical NOT operator
		while (!name.trim().equals("stop")) {
			System.out.println("Enter data: ");
			name = br.readLine();
			System.out.println("data is: " + name);
		}

		br.close();
		r.close();
	}
}
