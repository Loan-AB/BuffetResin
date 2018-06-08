package gestionGalerie;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MonImage extends ImageIcon 
{
	
	
	MesImages mesImages = new MesImages();
	
	ImageIcon photoEntree;
	ImageIcon photoSortie;


		public MonImage(int numImage) 
		{
				photoEntree=mesImages.recupererImage(numImage);
	
				Image image = photoEntree.getImage(); // transform it 
				Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				
				photoSortie = new ImageIcon(newimg);
				photoSortie.setDescription(photoEntree.getDescription());
		}
	
		public MonImage(String chemin) 
		{
	
				ImageIcon photoEntree = new ImageIcon(chemin);
				
				Image image = photoEntree.getImage(); // transform it 
				Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				
				photoSortie = new ImageIcon(newimg);
				photoSortie.setDescription(photoEntree.getDescription());
		}
	
		public MonImage() 
		{
				
		}

	public static ImageIcon transformationImage(String path, int width) 
	{
		ImageIcon ii = new ImageIcon(path);
		double ratio = (double)width/ii.getIconWidth();
		System.out.println("MonImage je retourne votre description " +ii.getDescription());
		return new ImageIcon(ii.getImage().getScaledInstance((int)(ii.getIconWidth()*ratio), (int)(ii.getIconHeight()*ratio), Image.SCALE_DEFAULT));
	}
	

}
