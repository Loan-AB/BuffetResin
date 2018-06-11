package gestionCalculatrice;

public abstract class  Sigle extends Symbole {

	private String signe;
	/**
	 * @param signe
	 */
	public Sigle(String signe) {
		this.signe = signe;
	}
	
	/**
	 * @return
	 */
	public String getSigne() {
		return signe;
	}
}
