package gestionGalerie;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

//Cette classe permet de récupérer les images dans un dossier 

public class MesImages {
	
	
	private ImageIcon tblPhotos[];
	
	File recherche;
	
	File listePhoto[];
	//ImageIcon photoChoisie;
	
	
	public MesImages() {
		// TODO Auto-generated constructor stub
		
		//récupération des fichier dans le dossier donné
		recherche = new File("./src/photoGallerie");
		
		//Selectionne les fichier que nous souahitons utiliser
		
		listePhoto = recherche.listFiles(new FileFilterImage());
		
		//Donne la taille de notre tableau de photos
		tblPhotos = new ImageIcon[listePhoto.length];
		
		// 
		for(int i=0;i<tblPhotos.length;i++) 
		{
			//Récupération du chemin de la photo
			String url = listePhoto[i].getAbsolutePath();
			 
			 //les images sont mises dans un tableau
			tblPhotos[i]= new ImageIcon(url);
			//System.out.println(url);
		}	
	}
	
	//Retourne la photo choisie avec sa référence dans le tableau
	public ImageIcon recupererImage(int num) {
		return tblPhotos[num];
	}
	
	//Retourne la taille du tableau de photos
	public int Size() {
		return tblPhotos.length;
	}

}
