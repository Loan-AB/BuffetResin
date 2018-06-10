package gestionGalerie;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MesImages {
	private static final long serialVersionUID = 1L;
	private ImageIcon images[];
	File recherche;
	
	File listePhoto[];
	//ImageIcon photoChoisie;
	
	
	public MesImages() {
		// TODO Auto-generated constructor stub
		
		recherche = new File("./src/photoGallerie");
		
		
		
		
		
		listePhoto = recherche.listFiles(new FileFilterImage());
		
		images = new ImageIcon[listePhoto.length];
		
		for(int i=0;i<images.length;i++) 
		{
			String url = listePhoto[i].getAbsolutePath();
			 
			 
			images[i]= new ImageIcon(url);
			//System.out.println(url);
		}	
	}
	public ImageIcon recupererImage(int num) {
		return images[num];
	}
	
	public int Size() {
		return images.length;
	}

}
