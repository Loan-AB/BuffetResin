package apparence;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PnlBas extends JPanel {
// Panel qui contient les 3 bouttons de base
	
	private MonBouton btnhome;
	//private MonBouton btnretour;
	//private MonBouton btnsuivant;
	
	public PnlBas() {
		setSize(480, 70);
		setBackground(Color.orange);
		//test pour les composant du bas
		btnhome = new MonBouton("Accueil", true);
		//btnretour = new MonBouton("retour", true);
		//btnsuivant = new MonBouton("suivant", true);

		
		//this.add(btnretour);
		this.add(btnhome);
		//this.add(btnsuivant);
	}

	public void setListenerBtn(ActionListener home) {
		btnhome.addActionListener(home);
		//btnhome.addActionListener(retour);
		//btnhome.addActionListener(suivant);
		
	}
}
