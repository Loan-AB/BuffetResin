package apparence;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PnlCentre extends JPanel {
	
	// Panel d'application (centre)
	// Modele pour les appli
	String nom;
	
	public PnlCentre(String nom) {
		setSize(480,200);
		this.nom = nom;
		setBackground(Color.blue);	
	}
}
