package gestionGalerie;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.PnlCentre;

public class PnlGalerie extends PnlCentre {


	MaFenetre maman;
	
	public PnlGalerie(MaFenetre maman) {
		super("Galerie");

		
		this.maman = maman;	
		add(new MonBouton("ajout", true));
		
		
		

	}
}
