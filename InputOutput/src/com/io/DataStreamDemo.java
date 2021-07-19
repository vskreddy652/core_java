package com.io;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamDemo {

	public static void main(String[] args) {

		try {
			int idA = 1;
			String nameA = "Test Purpose";
			int populationA = 48;
			float tempA = 1.3f;

			int idB = 2;
			String nameB = "djsdfddg";
			int populationB = 2;
			float tempB = 1.45f;

			FileOutputStream fos = new FileOutputStream("cities1.txt");
			DataOutputStream dos = new DataOutputStream(fos);

			// fos.wri
			dos.writeInt(idA);
			dos.writeUTF(nameA);// UTF stands for Unicode Text Format, its a
							// String
			dos.writeInt(populationA);
			dos.writeFloat(tempA);
			//write City

			dos.writeInt(idB);
			dos.writeUTF(nameB);
			dos.writeInt(populationB);
			dos.writeFloat(tempB);

			// any unwritten buffered data is written to destination(i..e file)
			dos.flush();

			fos.close();
			dos.close();

			FileInputStream fis = new FileInputStream("cities1.txt");
			DataInputStream dis = new DataInputStream(fis);

			int cityId = dis.readInt();
			System.out.println("City Id: " + cityId);
			String cityName = dis.readUTF();
			System.out.println("City Name: " + cityName);
			int cityPopulation = dis.readInt();
			System.out.println("City Population: " + cityPopulation);
			float cityTemperature = dis.readFloat();
			System.out.println("City Temperature: " + cityTemperature);

			int cityId1 = dis.readInt();
			System.out.println("City Id: " + cityId1);
			String cityName1 = dis.readUTF();
			System.out.println("City Name: " + cityName1);
			int cityPopulation1 = dis.readInt();
			System.out.println("City Population: " + cityPopulation1);
			float cityTemperature1 = dis.readFloat();
			System.out.println("City Temperature: " + cityTemperature1);

			// dis.readInt();//causes java.io.EOFException,
			// as we are reading beyond end of file

			dis.close();
			fis.close();
		} catch (Exception et) {
			et.printStackTrace();
		}
	}
}
