package gestionGalerie;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;









public class MesImages extends ImageIcon {
	private static final long serialVersionUID = 1L;
	ImageIcon images[];
	File recherche;
	//File ListePhoto[];
	//ImageIcon photoChoisie;
	
	
	public MesImages() {
		// TODO Auto-generated constructor stub
		
		File recherche = new File("C:/Users/julie/eclipse-workspace/ProjetSmartphoneTestPersoJulienResin/src/test/Photo") ;
		
				 File [] listePhoto = recherche.listFiles(); 
				
				images = new ImageIcon[listePhoto.length] ;
				
				for(int i=0;i<images.length;i++) 
				{
					
					String url = listePhoto[i].getAbsolutePath();
					
				images[i]= new ImageIcon(url);
				}
			
				

				
}

	


}
