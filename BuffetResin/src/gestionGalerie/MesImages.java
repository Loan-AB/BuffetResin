package gestionGalerie;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

 

public class MesImages {
	
	
	private ImageIcon tblPhotos[];
	
	File recherche;
	
	File listePhoto[];
	
	
	
	/**
	 * * @author julien
	 * Cette classe permet de récupérer les images d'une adresse donnée
	 * et de les ajouter à un tableau d'ImageIcon
	 *
	 */
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
	
	
	/**
	 * @param num
	 * @return Retourne la photo choisie avec sa référence dans le tableau
	 */
	public ImageIcon recupererImage(int num) {
		return tblPhotos[num];
	}
	
	//
	/**
	 * @return la taille du tableau de photos
	 */
	public int Size() {
		return tblPhotos.length;
	}

}
