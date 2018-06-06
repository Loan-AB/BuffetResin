package apparence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import gestionGalerie.RoudedBorder;


public class BouttonApplication extends MonBouton{

	String image= new String(); 
	String nom;
	
	
	public BouttonApplication(String imageIcon,String nom) {
		// TODO Auto-generated constructor stub
	super(nom, true);
		this.image=imageIcon;
		ImageIcon entreePhoto = new ImageIcon(imageIcon);
		
		Image image = entreePhoto.getImage(); // transform it 
		Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		
		ImageIcon photoSortie = new ImageIcon(newimg);
		JLabel Label = new JLabel(photoSortie);
		setIcon(photoSortie);
		
		
		
		
		setBorder(new RoudedBorder(10));
		
		
		setPreferredSize(new Dimension(140,140));
		
	}

}
