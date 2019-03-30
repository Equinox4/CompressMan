package application;

import java.util.HashMap;
import java.util.Map;

public class ArbreCodage extends Arbre<Character> implements Comparable<ArbreCodage>{

	private int poids;
	
	public ArbreCodage(ArbreCodage a, ArbreCodage b) {
		super(a,(char)0,b);
		this.poids = a.getPoids()+b.getPoids();
	}
	
	public ArbreCodage(Character c, int poids) {
		super(c);
		this.poids = poids;
	}
	
	public Map<Character,String> codage(){
		Map<Character,String> mp = new HashMap<>();
		String code = "";
		
		recurCod(code, mp);
		return mp;
	}
	
	public void recurCod(String code, Map<Character,String> mp) {
		
		if(!this.estFeuille()) {
		
			((ArbreCodage) this.getFilsG()).recurCod(code+ "0",mp);
			((ArbreCodage) this.getFilsD()).recurCod(code+ "1",mp);
		}
		else {
			mp.put(this.getContenu(), code);
		}
	}
	
	public int getPoids() {
		return this.poids;
	}
	
	public String toString() {
		return "Contenu: "+this.contenu+" Poids: "+this.poids;
	}

	@Override
	public int compareTo(ArbreCodage o) {
		return this.getPoids() - o.getPoids() == 0 ? 1 : this.getPoids() - o.getPoids();
	}
}
