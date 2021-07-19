package com.io;
import java.io.*;
public class FileIStream {
	public static void main(String[] args) {
		try {
        /* Either relative path or absolute path can be specified, below */
        // FileInputStream fin=new
        // FileInputStream("D:\\NetBeanJars\\abc.txt");
        FileInputStream fin = new FileInputStream("kkk.txt");
        int i = 0;
        // skip(int n) can be used to skip certain number of bytes
        // while reading
        // fin.skip(10);
        // iterate loop until end of file is reached
        byte b[] = new byte[10];
        fin.read(b);
        
        System.out.println(new String(b));
        
        
        while ((i = fin.read()) != -1) {
            // System is a class in java.lang
            // out is a static member of System class, and out is object of
            // type PrintStream, and println() is method in PrintStream
            // class
            System.out.print((char) i);
        }
        fin.close();
    } // FileNotFoundException is derived from IOException
    catch (FileNotFoundException fe) {
        fe.printStackTrace();
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }

	}
}
