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

class FileWriterDemo {
	public static void main(String args[]) {
		try {
			FileWriter fw = new FileWriter("abc1.txt");
			// Directly write characters, instead of bytes

			fw.write("Just checking File Writer Testing hhhhhhhhhh");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("success");
	}
}
