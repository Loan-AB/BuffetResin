package gestionGalerie;


import java.awt.Image;

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
		
		
			
			photoEntree=mesImages.images[numImage];
			
			
			Image image = photoEntree.getImage(); // transform it 
			Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			
			photoSortie = new ImageIcon(newimg);
	
			
			//System.out.println(photoSortie.toString());
			//photo.getIconHeight();
			//photo.getIconWidth();
			
			
			//photo.getScaledInstance(100,100,Image.SCALE_DEFAULT);
			
			
			
			
		//System.out.println(photo);
	}
	


}
