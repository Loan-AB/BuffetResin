package apparence;

import gestionGalerie.Gallery;

public class PnlGalerie extends PnlCentre {

	public PnlGalerie(String nom) {
		super(nom);
		
		add(new MonBouton("COUCOU", true));
		System.out.println("coder ici la galerie :D");
		
		Gallery gallerie = new Gallery();
	}
}
