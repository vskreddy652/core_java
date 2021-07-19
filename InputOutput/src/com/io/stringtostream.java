/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class stringtostream {
	public static void main(String args[]) {
		try {
			String str1 = "This is first String";

			byte bytes1[] = str1.getBytes();

			String str2 = "This is second String";

			byte bytes2[] = str2.getBytes();

			// convert byte array to InputStream
			ByteArrayInputStream bis1 = new ByteArrayInputStream(bytes1);

			ByteArrayInputStream bis2 = new ByteArrayInputStream(bytes2);

			SequenceInputStream sis = new SequenceInputStream(bis1, bis2);

			System.out.println("sis" + sis.toString());
			int i;
			while ((i = sis.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException io) {
			System.out.println("exception" + io.getMessage());
		}
	}
}
