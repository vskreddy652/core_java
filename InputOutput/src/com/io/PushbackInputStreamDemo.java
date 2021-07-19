/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackInputStreamDemo {

	public static void main(String[] args) {

		// change ++ to increment
		// in the string "a = a++ + b;" replace ++ with increment, and + symbol
		// should remain as it is
		String strExpression = "a = a++ + b+c++;";

		System.out.println("Input str is " + strExpression);
		byte bytes[] = strExpression.getBytes();

		// convert a String to a input stream
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

		PushbackInputStream pis = new PushbackInputStream(bis);

		int ch;

		try {
			// -1 indicates end of stream
			while ((ch = pis.read()) != -1) {
				// we encountered first + operator
				if (ch == '+') {
					// peek to see if another + follows
					if ((ch = pis.read()) == '+') {
						System.out.print(" increment ");
					} else {
						pis.unread(ch);
						System.out.print("+");
					}
				} else {
					// print the character
					System.out.print((char) ch);
				}
			}
		} catch (IOException ioe) {
			System.out.println("Exception while reading" + ioe);
		}
	}
}
