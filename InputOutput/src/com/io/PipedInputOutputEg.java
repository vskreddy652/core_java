/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.io;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class DownloadThread extends Thread {
	public void run() {
		try {
			for (int i = 0; i < PipedInputOutputEg.str.length(); i++) {
				PipedInputOutputEg.pos.write(PipedInputOutputEg.str.charAt(i));
				Thread.sleep(1000);
			}
		} catch (Exception et) {
			et.printStackTrace();
		} finally {
			try {
				PipedInputOutputEg.pos.close();
			} catch (IOException ex) {
				Logger.getLogger(DownloadThread.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}

class DisplayThread extends Thread {
	public void run() {
		try {
			for (int i = 0; i < PipedInputOutputEg.str.length(); i++) {
				int tmp = PipedInputOutputEg.pis.read();
				System.out.print((char) tmp);
				Thread.sleep(1000);
			}
		} catch (Exception et) {
			et.printStackTrace();
		} finally {
			try {
				PipedInputOutputEg.pis.close();
			} catch (IOException ex) {
				Logger.getLogger(DisplayThread.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}

public class PipedInputOutputEg {
	static PipedInputStream pis;
	static PipedOutputStream pos;

	static String str = "How are you doing??";

	public static void main(String args[]) throws Exception {
		pis = new PipedInputStream();
		pos = new PipedOutputStream();

		pis.connect(pos);

		new DownloadThread().start();

		new DisplayThread().start();
	}
}
