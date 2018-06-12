package gestionCalculatrice;

public abstract class  Sigle extends Symbole {

	private String signe;
	/**
	 * @param signe
	 * @author loanb
	 */
	public Sigle(String signe) {
		this.signe = signe;
	}
	
	/**
	 * @return
	 * @author loanb
	 */
	public String getSigne() {
		return signe;
	}
}
