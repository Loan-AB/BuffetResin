package apparence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import gestionGalerie.MonImage;
import javafx.scene.layout.BackgroundImage;


@SuppressWarnings("serial")
public class PnlCentre extends JPanel {
	
	// Panel d'application (centre)
	// Modele pour les appli
	String nom;
	
	
    
	
	public PnlCentre(String nom) {
		setSize(480,200);
		this.nom = nom;
		setBackground(Color.blue);
		//add(label);
		
		
	}
}
