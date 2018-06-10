package apparence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
	
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	        g.drawImage(new ImageIcon("./src/photoDefault/wallpaper1.png").getImage(), 0, 0, null);
	}
	
    	
	public PnlCentre(String nom) {
		
		//panelWallPaper.add(labelWallPaper,BorderLayout.CENTER);
		//add(panelWallPaper, BorderLayout.CENTER);
		//add(label);
		setSize(480,200);
		//add(labelWallPaper,BorderLayout.CENTER);
		this.nom = nom;
//		setBackground(Color.black);
		setOpaque(true);
		
		//setOpaque(true);
		
		
	}
}
