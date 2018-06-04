package gestionGalerie;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;








public class MonImage extends ImageIcon {
	
	
	MesImages mesImages = new MesImages();
	
	//ImageIcon [] imageRecupération = new MonImage[mesImages.images.length];
	ImageIcon photoEntree;
	ImageIcon photoSortie;
	//int numImage=0;
	//ImageIcon imageModifiee;

	public MonImage(int numImage) {
		// TODO Auto-generated constructor stub
		
		//selectionner une image dans mes images
		
		
			
			photoEntree=mesImages.recupererImage(numImage);
			
			
			Image image = photoEntree.getImage(); // transform it 
			Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			
			photoSortie = new ImageIcon(newimg);
			photoSortie.setDescription(photoEntree.getDescription());
			
			//System.out.println(photoSortie.toString());
			//photo.getIconHeight();
			//photo.getIconWidth();
			
			
			//photo.getScaledInstance(100,100,Image.SCALE_DEFAULT);
			
			
			
			
		//System.out.println(photo);
	}
	
	public static ImageIcon transformationImage(ImageIcon ii, int width) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(ii.getDescription()));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		double ratio = (double)width/img.getWidth();
		return new ImageIcon(ii.getImage().getScaledInstance((int)(img.getWidth()*ratio), (int)(img.getHeight()*ratio), Image.SCALE_DEFAULT));
	}
	
//	public static ImageIcon transformationImage(String path, int width) {
//		ImageIcon ii = new ImageIcon(path);
//		double ratio = (double)width/ii.getIconWidth();
//		System.out.println(ii.getDescription());
//		return new ImageIcon(ii.getImage().getScaledInstance((int)(ii.getIconWidth()*ratio), (int)(ii.getIconHeight()*ratio), Image.SCALE_DEFAULT));

}
