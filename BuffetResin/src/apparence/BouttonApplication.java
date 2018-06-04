package apparence;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import gestionGalerie.RoudedBorder;


public class BouttonApplication extends MonBouton{

	String image= new String(); 
	

	public BouttonApplication(String imageIcon) {
		// TODO Auto-generated constructor stub
	super("", true);
		this.image=imageIcon;
		ImageIcon entreeImage = new ImageIcon(imageIcon);
		
		Image image = entreeImage.getImage(); // transform it 
		Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		
		ImageIcon photoSortie = new ImageIcon(newimg);
		
		setIcon(photoSortie);
		
		
		
		
		setBorder(new RoudedBorder(10));
		
		
		setPreferredSize(new Dimension(150,150));
		
	}

}
