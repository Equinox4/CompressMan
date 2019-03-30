package application;
import java.util.LinkedList;

public class Arbre<E> {

	protected E contenu;
	protected Arbre<E> filsG, filsD;
	
	public Arbre(Arbre<E> g, E c, Arbre<E> d) {
		this.filsG = g;
		this.contenu = c;
		this.filsD = d;
	}

	public Arbre() {
		this(null, null, null);
	}

	public Arbre(E contenu) {
		this(new Arbre<E>(), contenu, new Arbre<E>());
	}

	public boolean estVide() {
		return this.filsG == null && this.filsD == null && this.contenu == null;
	}

	public int taille() {
		if(this.estVide()) {
			return 0;
		}
		return 1 + this.filsG.taille()+this.filsD.taille();
	}

	public boolean estFeuille() {
		return this.taille()==1?true:false;
	}

	public int nbFeuilles() {
		if(this.estVide()) {
			return 0;
		}
		else if(this.estFeuille()) {
			return 1;
		}
		else {
			return this.filsD.nbFeuilles()+this.filsG.nbFeuilles();
		}
	}

	public int hauteur() {
		if(this.estVide()) {
			return -1;
		}
		else if(this.estFeuille()) {
			return 0;
		}
		else {
			
			if(this.filsD.hauteur()>this.filsG.hauteur()) {
				return 1 + this.filsD.hauteur();
			}
			return 1 + this.filsG.hauteur();
		}
	}

	public void parcoursPrefixe() {
		if(!this.estVide()) {
			System.out.print(this.contenu+", ");
			this.filsG.parcoursPrefixe();
			this.filsD.parcoursPrefixe();
		}		
	}

	public void parcoursInfixe() {
		if(!this.estVide()) {
			this.filsG.parcoursInfixe();
			System.out.print(this.contenu+", ");
			this.filsD.parcoursInfixe();
		}
	}

	public void parcoursPostfixe() {
		if(!this.estVide()) {
			this.filsG.parcoursPostfixe();
			this.filsD.parcoursPostfixe();
			System.out.print(this.contenu+", ");
		}
	}

	public void parcoursLargeur() {
		LinkedList<Arbre<E>> list = new LinkedList<>();
		Arbre<E> ar;
		
		if(!this.estVide()) {
			list.add(this);
			while(!list.isEmpty()){
				
				ar = list.getLast();
				System.out.print(ar.getContenu()+", ");
				list.removeLast();
				
				if(!ar.filsG.estVide()) {
					list.addFirst(ar.filsG);
				}
				if(!ar.filsD.estVide()) {
					list.addFirst(ar.filsD);
				}
			}
		}
	}

	public Arbre<E> getFilsG() {
		return this.filsG;
	}

	public Arbre<E> getFilsD() {
		return this.filsD;
	}

	public E getContenu() {
		return this.contenu;
	}

	public boolean estIdentiqueA(Arbre<E> b) {
		if (this.estVide() && b.estVide())
			return true;
		if (!this.estVide() && !b.estVide() && this.contenu.equals(b.contenu))
			return this.filsG.estIdentiqueA(b.filsG) && this.filsD.estIdentiqueA(b.filsD);
		else
			return false;
	}

	@Override
	public String toString() {
		if (this.estVide())
			return "vide";
		return "[filsG=" + filsG + ", contenu=" + contenu + ", filsD=" + filsD + "]";
	}
}
