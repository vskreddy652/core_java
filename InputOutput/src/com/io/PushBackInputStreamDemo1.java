/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/*
replace == with <equals_to> and print to console
*/
public class PushBackInputStreamDemo1 {

	public static void main(String[] args) {
		String strExpression = "a=b==c=z";

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
				if (ch == '=') {
					// peek to see if another + follows
					if ((ch = pis.read()) == '=') {
						System.out.print("<equals_to>");
					} else {
						System.out.print("=");
						// pis.unread(ch);
					}
				} else {
					// print the character
					System.out.print((char) ch);
				}
			}

			System.out.println();
		} catch (IOException ioe) {
			System.out.println("Exception while reading" + ioe);
		}
	}
}
