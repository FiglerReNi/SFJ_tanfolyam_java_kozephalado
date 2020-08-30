package com.elso;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//Fájlba íráa
public class Writer {

	public void writeSingleChar() {
		// windows-nál dupla per jelet kell használni
		try {
			// ha nincs még ilyen fájl, létrehozza, ha van felülírja
			FileOutputStream fos = new FileOutputStream(
					"C:\\Program Files\\Java\\JavaKozepHalado\\Elso\\src\\main\\resources\\static\\file.txt");
			// egy karakter írása, az ASCII kódot kell megadnom
			fos.write(65);
			// ezzel hajtom végre
			fos.flush();
			// mindig le kell zárni
			fos.close();
			System.out.println("Kész");
		} catch (Exception e) {
			System.out.println("" + e);
		}
	}

	public void writeMoreChar() {
		// windows-nál dupla per jelet kell használni
		try {
			// ha nincs még ilyen fájl, létrehozza, ha van felülírja
			FileOutputStream fos = new FileOutputStream(
					"C:\\Program Files\\Java\\JavaKozepHalado\\Elso\\src\\main\\resources\\static\\file.txt");
			String text = "Teszt szöveg";
			// Olyan formára hozzuk, hogy el lehessen menteni
			byte a[] = text.getBytes();
			fos.write(a);
			// ezzel hajtom végre
			fos.flush();
			// mindig le kell zárni
			fos.close();
			System.out.println("Kész");
		} catch (Exception e) {
			System.out.println("" + e);
		}
	}

	public void bufferedWriter() throws Exception {

		FileOutputStream fos = new FileOutputStream(
				"C:\\Program Files\\Java\\JavaKozepHalado\\Elso\\src\\main\\resources\\static\\file.txt");
		// ezzel lesz egy gyűjtőhelyem a fos-nak
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String text = "Teszt szöveg";
		byte a[] = text.getBytes();
		bos.write(a);
		bos.flush();
		bos.close();
		fos.close();
		System.out.println("Kész");
	}
}
