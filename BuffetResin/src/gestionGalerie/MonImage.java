package gestionGalerie;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;







public class MonImage extends ImageIcon {
	
	
	MesImages mesImages = new MesImages();
	
	//ImageIcon [] imageRecupération = new MonImage[mesImages.images.length];
	ImageIcon photo;
	//int numImage=0;
	//ImageIcon imageModifiee;

	public MonImage(int numImage) {
		// TODO Auto-generated constructor stub
		
		//selectionner une image dans mes images
		
		
			
			photo=mesImages.images[numImage];
			
			
	
			//photo.getIconHeight();
			//photo.getIconWidth();
			
			
			//photo.getScaledInstance(100,100,Image.SCALE_DEFAULT);
			
			
			
			
		//System.out.println(photo);
	}
	


}
