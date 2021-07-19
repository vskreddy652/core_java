package com.io;

import java.io.*;

public class InputStreamReaderEg {
	public static void main(String[] args) {
		// array of character
		char[] carray = new char[50];

		try {
			// Creates an object of FileInputStream
			FileInputStream file = new FileInputStream("abc.txt");

			// Creates an InputStreamReader
			InputStreamReader input = new InputStreamReader(file);

			BufferedReader br = new BufferedReader(input);
			// Reads characters from the file
			System.out.println("Character Data in the stream:"+br.readLine());

			br.close();
			input.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
