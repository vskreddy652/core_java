package com.io;

/**
 *
 * @author ADMIN
 */
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOStream {
	public static void main(String args[]) {
		try {
			// If file doesn't exist, file gets created
			FileOutputStream fout = new FileOutputStream("G:\\xyz\\abcd123.txt", true/* append */);
			String s = "\n66666666664e5fhggju\"suhegiweutqw7";
			byte b[] = s.getBytes();// converting string into byte array
			fout.write(b);
			fout.write('K');
			fout.close();
			System.out.println("success...");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
