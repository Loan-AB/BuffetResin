package gestionCalculatrice;

public class Nombre extends Symbole{
	private double valeur;
	
	/*stoque le nombre
	 * @author loanb
	 */
	public Nombre(double val) {
		valeur = val;
	}
	
	/**
	 * @return
	 */
	public double getValeur() {
		return valeur;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Double.toString(valeur);
	}
}
