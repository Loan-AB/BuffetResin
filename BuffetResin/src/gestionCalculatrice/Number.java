package gestionCalculatrice;

public class Number extends Symbole{
	private double valeur;
	
	public Number(double val) {
		valeur = val;
	}
	
	public double getValeur() {
		return valeur;
	}
	
	public String toString() {
		return Double.toString(valeur);
	}
}
