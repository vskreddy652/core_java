/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.*;

class BufferedOutputStreamDemo {
	public static void main(String args[]) throws Exception {
		FileOutputStream fout = new FileOutputStream("f1.txt");
		BufferedOutputStream bout = new BufferedOutputStream(fout);
		String s = "Just testing output";
		byte b[] = s.getBytes();
		bout.write(b);

		bout.flush();
		bout.close();
		fout.close();
		System.out.println("success");
	}
}