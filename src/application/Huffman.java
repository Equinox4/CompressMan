package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Huffman {

	private Map<Character,Integer> frequences;
	private Map<Character,String> lescodes;
	private ArbreCodage arbreHuffman;
	
	public Huffman(String t) {
		this.frequences = new HashMap<>();
		this.lescodes = new HashMap<>();
		this.litTexte(t);
		this.construitArbre();
		this.lescodes=this.arbreHuffman.codage();
	}
	
	public Huffman(File f) {
		this.frequences = new HashMap<>();
		this.lescodes = new HashMap<>();
		this.litTexte(f);
		this.construitArbre();
		this.lescodes=this.arbreHuffman.codage();
	}
	
	private void litTexte(File f){
		int n;
		char c;
		try{
        	//BufferedReader br = new BufferedReader(new FileReader(f));
        	BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        	try{
	            while((n = br.read()) > 0){
	            	c = (char)n;
	            	//System.out.println(c);
	            	if(!this.frequences.containsKey(c)) {
	    				this.frequences.put(c, 1);
	    			}
	    			else {
	    				//this.frequences.replace(c, this.frequences.get(c), this.frequences.get(c)+1);
	    				this.frequences.replace(c, this.frequences.get(c)+1);
	    			}
	            }
	            //System.out.println(this.frequences);
	            br.close();
        	}
	        catch(IOException e){
	            e.printStackTrace();
	        }
        }
    	catch(FileNotFoundException e){
            e.printStackTrace();
        }
	}
	
	private void litTexte(String texte){
		char c;
		for(int i=0;i<texte.length();i++) {
			c=texte.charAt(i);
			if(!this.frequences.containsKey(c)) {
				this.frequences.put(c, 1);
			}
			else {
				this.frequences.replace(c, this.frequences.get(c), this.frequences.get(c)+1);
			}
		}
	}
	
	private void construitArbre(){
		TreeSet<ArbreCodage> list = new TreeSet<>();
		for(char c : this.frequences.keySet()) {
			list.add(new ArbreCodage(c, this.frequences.get(c)));
		}
		
		while(list.size() != 1) {
			list.add(new ArbreCodage(list.pollFirst(), list.pollFirst()));	
		}
		
		this.arbreHuffman = list.first();
	}
	
	public ArbreCodage getArbreHuffman(){
		return this.arbreHuffman;
	}
	
	public void afficheTableCodage() {
		int taille = 0;
		String table = "";
		for(char c : this.lescodes.keySet()){
			if(c == '\n')
				System.out.print("[ \\n : ");
			else if(c=='\r'){
				System.out.print("[ \\r : ");
			}
			else if(c=='\t'){
				System.out.print("[ \\t : ");
			}
			else {
				System.out.print("[ "+c+" : ");
			}
			
			String code = this.lescodes.get(c);
			System.out.println(code+" ] "+code.length()+" "+Integer.toBinaryString(code.length())+" char: ");
			taille += code.length();
			table += code;
		}
		System.out.println(taille+"\n"+Integer.toBinaryString(taille)+"\n"+table);
		System.out.println("nombre de caracteres: "+this.lescodes.size()+" "+Integer.toBinaryString(this.lescodes.size()));
		System.out.println();
	}
	
}
