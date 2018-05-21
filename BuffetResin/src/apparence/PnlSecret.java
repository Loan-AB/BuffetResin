package apparence;

public class PnlSecret extends PnlCentre {
	MaFenetre maman;

	public PnlSecret(MaFenetre maman) {
		super("Secret");
		this.maman = maman;
		add(new MonBouton("SECRET",true));	
	}
}
