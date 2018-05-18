package gestionGalerie;

import apparence.MonBouton;
import apparence.PnlCentre;

public class PnlGalerie extends PnlCentre {

	public PnlGalerie(String nom) {
		super(nom);
		
		add(new MonBouton("ajout", true));
		System.out.println("coder ici la galerie :D");
		
		
		

	}
}
