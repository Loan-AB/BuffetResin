package gestionCalculatrice;

public class Nombre extends Symbole{
	private double valeur;
	
	public Nombre(double val) {
		valeur = val;
	}
	
	public double getValeur() {
		return valeur;
	}
	
	public String toString() {
		return Double.toString(valeur);
	}
}
