package com.io;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

class MyThread extends Thread {
	static String str = "Hello How are you";

	// creating one thread t1 which writes the data
	public void run() {
		for (int i = 0; i < str.length(); i++) {
			try {
				PipedInputOutput1.pout.write(str.charAt(i));

				//System.out.println("Writing..." + str.charAt(i));
				Thread.sleep(1000); // 1000 milliseconds
			} catch (Exception e) {
				System.out.println("Exception in child thread" + e.getMessage());
				e.printStackTrace();
			}
		} // end of for
	} // end of run()

}

class PipedInputOutput1 {
	final static PipedOutputStream pout = new PipedOutputStream();
	final static PipedInputStream pin = new PipedInputStream();

	public static void main(String args[]) throws Exception {
		pout.connect(pin);// connecting the streams

		MyThread t1 = new MyThread();
		// creating another thread t2 which reads the data

		// starting both threads
		t1.start();

		// try{
		for (int i = 0; i < MyThread.str.length(); i++) {
			System.out.println((char) pin.read());
		}
		/*
		 * }catch(Exception e){ System.out.println(e.getMessage()); }
		 */

		pout.close();
		pin.close();
	}
}