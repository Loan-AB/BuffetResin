package gestionGalerie;

import javax.swing.ImageIcon;

import test.MesImages;

public class MonImage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MesImages mesImages = new MesImages();
	
	
	ImageIcon photo;
	int numImage=0;
	

	public MonImage(int numImage) {
		// TODO Auto-generated constructor stub
		
		//selectionner une image dans mes images
		
	
		
			photo=mesImages.images[numImage];
			numImage=numImage+1;
	
			
		//System.out.println(photo);
	}
	
	

}
