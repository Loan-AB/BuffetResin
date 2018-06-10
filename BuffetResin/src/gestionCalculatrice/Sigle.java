package gestionCalculatrice;

public abstract class  Sigle extends Symbole {

	private String signe;
	public Sigle(String signe) {
		this.signe = signe;
	}
	
	public String getSigne() {
		return signe;
	}
}
