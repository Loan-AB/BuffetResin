package apparence;

public class PnlGalerie extends PnlCentre {

	public PnlGalerie(String nom) {
		super(nom);
		
		add(new MonBouton("COUCOU", true));
		System.out.println("coder ici la galerie :D");
	}
}
