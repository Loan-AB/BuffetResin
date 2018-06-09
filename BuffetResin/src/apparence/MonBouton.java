package apparence;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import gestionGalerie.MonImage;



public class MonBouton extends JButton {
	
//	String nom;
	public MonBouton(String nom)
	{
		super(" ");
		this.setActionCommand(nom);
		this.setText(nom);
//		this.setContentAreaFilled(false);
//		this.setFocusPainted(false);
//		this.setOpaque(true);
//		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
//		this.setBackground(Color.LIGHT_GRAY);
	}
	public MonBouton(String nom, boolean b) {
		super(" ");
		this.setActionCommand(nom);
		this.setText(nom);
		this.setVisible(b);

	}
	
	public MonBouton(String nom,String path )
	{
		
		
		super(" ");
		this.setBorderPainted(false); //pour ne 5pas voir les bordures
		this.setActionCommand(nom);
		super.setText(" ");
		this.setFocusPainted(false);
//		this.setSize(new Dimension(50,50));
		this.setOpaque(false); //pour que le fond soit opaque
		MonImage m = new MonImage(); //instencier
		this.setIcon(m.transformationImage(path,70)); //la je ne sais pas ce que je fait XD
		this.setBackground(Color.BLACK);
	}
	public MonBouton(String nom, String path, int taille) {
		super(" ");
		this.setBorderPainted(false); //pour ne 5pas voir les bordures
		this.setActionCommand(nom);
		super.setText(" ");
		this.setFocusPainted(false);
//		this.setSize(new Dimension(50,50));
		this.setOpaque(false); //pour que le fond soit opaque
		MonImage m = new MonImage(); //instencier
		this.setIcon(m.transformationImage(path,taille)); //la je ne sais pas ce que je fait XD
		this.setBackground(Color.BLACK);
	}

	

}
