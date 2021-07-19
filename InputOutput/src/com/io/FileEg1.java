/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.File;

/**
 *
 * @author ADMIN
 */
public class FileEg1 {

	final static String ROOT_PATH = "F:\\eclipse-workspace\\InputOutput";

	public static void main(String[] argv) throws NullPointerException, Exception {
		displayFiles(ROOT_PATH);
	}
	
	static void displayFiles(String path)
	{
		File dir = new File(path);
		File[] far = dir.listFiles();
	
		for (File fone : far) {
			System.out.print(path+"\\"+fone.getName() + "   ");
	
			if (fone.isDirectory()) {
				System.out.println(" <<Folder>>");
				displayFiles(path+"\\"+fone.getName());
			} else {
				System.out.println(" <<File>>");
			}
		}
	
		System.out.println("No. of files/fodlers:" + far.length);
	}
}
