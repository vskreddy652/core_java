/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.*;

class FileReaderDemo {
	public static void main(String args[]) throws Exception {
		FileReader fr = new FileReader("abc2.txt");
		int i;
		while ((i = fr.read()) != -1)
		{
			System.out.print((char) i);
		}

		fr.close();
	}
}
