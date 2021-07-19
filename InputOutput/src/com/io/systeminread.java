package com.io;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

public class systeminread {
	public static void main(String args[]) {
		try {
			int i;

			// read one character from keyboard
			i = System.in.read();

			System.out.println("First Character is:" + (char) i);

			byte bt[] = new byte[20];

			System.in.read();
			
			// read multiple characters from keyboard into byte array
			System.in.read(bt);

			// convert byte array to String
			String str = new String(bt);

			// trim the String to remove whitespaces at the end, if any
			str = str.trim();

			System.out.println("Next Characters are:" + str);
		}

		catch (Exception et) {
			et.printStackTrace();
		}
	}
}
