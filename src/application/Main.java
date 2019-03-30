package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.plaf.FileChooserUI;

public class Main {

	public static void main(String[] args) {
		Huffman h = new Huffman(new File("D:\\Bibliothèque\\Téléchargements\\ftppurge.py"));
		h.afficheTableCodage();
		
		/*
		String table = "110111100110101110001010001111011110011000111001000111011110011000111101101111001100011100111111011110011000110110111100110001111111011110011000111001110001101111001101111011110011110011101111001111100110111100110001110011101110111100111010111101111001111011101111001001001011100110110001100011011001101111000110111000110011101111110110111111111011101011111011110011000111001101101111001100010001101011011110011101101101111011101111001110001101111001101010011011110011000001101111011110011110000110111100110001110001000001101111001101010111011110011001111011110011111110010010000110011011101111001101001010001101111001111101110111100111010100110111100110001110111011110011110001111011110011011110011101111101011110100100011011000001001110000111110011001011011110011001010011001010110110110111100111110111110110111100110001110011100111111111101101011101111001011010011101111001110011101111001100010111000001101111001110100110111100111010101";
		
		String size = Integer.toBinaryString(table.length());
		String zeros = "";
		
		while(size.length() + zeros.length() < 16) {
			zeros += "0";
		}
		
		zeros+=size;
		//System.out.println(zeros);
		System.out.println(Short.parseShort(zeros, 2));
		String content = zeros+table;
		System.out.println(content.length());
		byte[] b = content.getBytes();
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("../../files/compression/test"));
			try {
				fos.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//				nb_caracteres    nb_bits  bits_encode      caractere
		String table = "0000000001010011 00010000 1101111001101011 00001001";
		char c = '\t';
		System.out.println("hello");
		System.out.println(Integer.toBinaryString(Character.toString(c).getBytes()[0] & 0xFF));
		System.out.println();
		
		//short(nb_char_to_read 2 bytes) byte(nb bits) bits_encode char(2 bytes) byte(nb bits) bits_encode char(2 bytes) byte ...
		//afficher la taille theorique
		
	}
	
	public static void buildTable(byte[] bytes) {
		//byte[]
		for (byte b : bytes) {
			
		}
	}

}
