/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io;

import java.io.*;

class PipedInputOutputDemo2 {
	static PipedOutputStream pout = new PipedOutputStream();
	static PipedInputStream pin = new PipedInputStream();

	static PipedInputStream pin1 = new PipedInputStream();

	public static void main(String args[]) throws Exception {

		pout.connect(pin);// connecting the streams
		pout.connect(pin1);

		// ObjectOutputStream oos = new ObjectOutputStream(pout);

		// creating one thread t1 which writes the data
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 65; i <= 90; i++) {
					try {
						pout.write(i);
						Thread.sleep(1000); // 1000 milliseconds
					} catch (Exception e) {
					}
				}
			}
		};
		// creating another thread t2 which reads the data
		Thread t2 = new Thread() {
			public void run() {
				try {
					for (int i = 65; i <= 90; i++)
						System.out.println("Thread t2 " + (char) pin.read());
				} catch (Exception e) {
				}
			}
		};

		// creating another thread t2 which reads the data
		Thread t3 = new Thread() {
			public void run() {
				try {
					for (int i = 65; i <= 90; i++)
						System.out.println("Thread t3 " + (char) pin1.read());
				} catch (Exception e) {
				}
			}
		};

		// starting both threads
		t1.start();
		t2.start();
		t3.start();
	}
}
