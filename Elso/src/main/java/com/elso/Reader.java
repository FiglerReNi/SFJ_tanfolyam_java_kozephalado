package com.elso;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

//Fájlból olvasás
public class Reader {

	public void readSingleChar() {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Program Files\\Java\\JavaKozepHalado\\Elso\\src\\main\\resources\\static\\file.txt");
			// egy karatert fogunk kiolvasni
			int i = fis.read();
			System.out.println((char) i);
			// le kell zárni
			fis.close();
		} catch (Exception e) {
			System.out.println("" + e);
		}
	}

	public void readMoreChar() {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Program Files\\Java\\JavaKozepHalado\\Elso\\src\\main\\resources\\static\\file.txt");
			int i = 0;
			String result = "";
			//a read() -1-et ad vissza, ha nincs már mit kiolvasni
			while((i=fis.read())!=-1) {
				result += (char)i;				
			}
			System.out.print(result);
			// le kell zárni
			fis.close();
		} catch (Exception e) {
			System.out.println("" + e);
		}
	}
	
	public void bufferedReader() throws Exception{
		FileInputStream fis = new FileInputStream(
				"C:\\Program Files\\Java\\JavaKozepHalado\\Elso\\src\\main\\resources\\static\\file.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		int i = 0;
		String result = "";
		while((i=bis.read())!=-1) {
			result += (char)i;				
		}
		System.out.print(result);
		bis.close();
		fis.close();
	}
}
