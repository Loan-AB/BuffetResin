package gestionGalerie;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


//Cette classe permet de récupèrer une photo
public class MonImage extends ImageIcon 
{
	
	
	MesImages mesImages = new MesImages();
	
	ImageIcon photoEntree;
	ImageIcon photoSortie;

	// Récupération d'une image par son numéro dans un tableau
		/**
		 * @param numImage
		 */
		public MonImage(int numImage) 
		{
				photoEntree=mesImages.recupererImage(numImage);
				
				//Transforme l'ImageIcon  en Image
				Image image = photoEntree.getImage();
				//la nouvelle image et mise à l'échelle
				Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				
				//la newimg est transformée en  ImageIcon
				photoSortie = new ImageIcon(newimg);
				photoSortie.setDescription(photoEntree.getDescription());
		}
	//Récupération d'une image par son lien
		/**
		 * @param chemin
		 */
		public MonImage(String chemin) 
		{
				
				ImageIcon photoEntree = new ImageIcon(chemin);
				
				Image image = photoEntree.getImage(); // transform it 
				Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				
				photoSortie = new ImageIcon(newimg);
				photoSortie.setDescription(photoEntree.getDescription());
		}
	
		/**
		 * 
		 */
		public MonImage() 
		{
				
		}

	/**
	 * @param path
	 * @param width
	 * @return
	 */
	public  ImageIcon transformationImage(String path, int width) 
	{
		ImageIcon ii = new ImageIcon(path);
		double ratio = (double)width/ii.getIconWidth();
		System.out.println("MonImage je retourne votre description " +ii.getDescription());
		return new ImageIcon(ii.getImage().getScaledInstance((int)(ii.getIconWidth()*ratio), (int)(ii.getIconHeight()*ratio), Image.SCALE_DEFAULT));
	}

	/**
	 * @param description
	 * @param i
	 * @param j
	 * @return
	 */
	public  ImageIcon transformationImage(String description, int i, int j) {
		ImageIcon ii = new ImageIcon(description);
		System.out.println("MonImage je retourne votre description " +ii.getDescription());
		return new ImageIcon(ii.getImage().getScaledInstance(i, j, Image.SCALE_DEFAULT));
	}
	

}
