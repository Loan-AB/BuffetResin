package apparence;

public class PnlSecret extends PnlCentre {

	public PnlSecret(String nom) {
		super(nom);
		add(new MonBouton("SECRET",true));	
	}
}
