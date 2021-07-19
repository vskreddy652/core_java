package com.io;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;

public class ListFilesFolders {

	final static String ROOT_PATH = "./";

	public static void main(String[] argv) throws NullPointerException, Exception {
		
		Files.list(Paths.get("./"))
		.filter(path -> path.toString().endsWith(".txt"))
		.forEach(System.out::println);

		Optional<Path> rpath = Files.list(Paths.get("./"))
		.filter(path -> path.toString().endsWith(".txt")) //filtering paths of .txt files
		.reduce((path1,path2)->{ //reducing to largest .txt file
			File f1 = new File(path1.toString());
			File f2 = new File(path2.toString());
			return f1.length()>f2.length()? path1:path2;
		});
		
		System.out.println(rpath.toString());
		
		System.exit(0);
		File dir = new File(ROOT_PATH);
		// lists files/folders in current execution directory
		String[] children = dir.list();
		// dir.listFiles(); returns File[]

		if (children == null) {
			System.out.println("does not exist or is not a directory");
		} else {
			for (int i = 0; i < children.length; i++) {
				String filename = children[i];
				System.out.print(filename + "         ");

				File tmp_file = new File(ROOT_PATH + filename);
				if (tmp_file.isDirectory()) {
					System.out.println(" <<Folder>> ");
				} else {
					System.out.println(" <<File>> ");
				}

				long m_time = tmp_file.lastModified();
				Date dt = new Date(m_time);
				System.out.println("Modified on:" + dt);
				System.out.println("--------------------------");

				Thread.sleep(100);
			}
		}

		System.exit(0);

		// Folder creation example
		File dir1 = new File("./dddddddddd/eeeeeee");
		if (dir1.mkdirs()) {
			System.out.println("Directory created");
		} else {
			System.out.println("Directory not created");
		}

		/*
		 * dir1.delete(); dir1.exists(); dir1.createNewFile();
		 */
	}
}
