/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

/**
 *
 * @author ADMIN
 */
import java.io.*;

class ByteArrayOutputStreamDemo {
	public static void main(String args[]) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String s = "This should end up in the array";
		byte buf[] = s.getBytes();
		baos.write(buf);

		System.out.println("Buffer as a string");
		System.out.println(baos.toString());
		System.out.println("Into array");
		byte b[] = baos.toByteArray();
		for (int i = 0; i < b.length; i++) {
			System.out.print((char) b[i]);
		}
		System.out.println("\\nTo an OutputStream()");
		OutputStream f2 = new FileOutputStream("test.txt");
		baos.writeTo(f2);
		f2.close();
		System.out.println("Doing a reset");
		baos.reset();
		for (int i = 0; i < 3; i++)
			baos.write('Z');
		System.out.println(baos.toString());
	}
}
