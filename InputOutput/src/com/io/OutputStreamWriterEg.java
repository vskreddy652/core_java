package com.io;

import java.io.*;

public class OutputStreamWriterEg {
	public static void main(String[] args) {
		String str = "some simple string hereeeeeeee";

		try {
			// Creates an object of FileInputStream
			FileOutputStream file = new FileOutputStream("abc3.txt");

			// Creates an OutputStreamWriter
			OutputStreamWriter output = new OutputStreamWriter(file);

			// Reads characters from the file
			output.write(str);
			System.out.println("success");

			output.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
