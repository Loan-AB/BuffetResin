package gestionContact;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import javax.swing.ImageIcon;


public class Contact implements Serializable, Comparable{

	private static final long serialVersionUID = 1L;
	private static String chemin = ".\\src\\fichierContact\\"; //chemin => chemin des fichiers
	private String nomFichier;

	private String nom;
	private String prenom;
	private String NumeroTel;
	private String NumeroMobile;
	private String email;
	private ImageIcon photo;
	
	public Contact(String nom, String prenom, String numeroTel, String numeroMobile, String email, ImageIcon photo) {
		this.nom = nom;
		this.prenom = prenom;
		NumeroTel = numeroTel;
		NumeroMobile = numeroMobile;
		this.email = email;
		this.photo = new ImageIcon(photo.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		this.nomFichier = nom+prenom;
	}
	
	//sans image spécifier on met celle par defaut
	public Contact(String nom, String prenom, String numeroTel, String numeroMobile, String email) 
	{
		
		//on pourrait a la limite déterminer 4 photo par derfaut avec un aléatoire.
		
		this.nom = nom;
		this.prenom = prenom;
		NumeroTel = numeroTel;
		NumeroMobile = numeroMobile;
		this.email = email;
		ImageIcon photo = new ImageIcon(".\\src\\photoGallerie\\default.png");
		this.photo = new ImageIcon(photo.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
	}

	@Override
	public String toString() {
		return  getNom() + "  " + getPrenom() + "  " + getNumeroMobile();
	}
	
	//Setter et Getter : 
	
	public ImageIcon getImageIcon() {
		return photo;
	}
	public ImageIcon getImageIconDefault() {
		return photo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		changerNomFichier();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
		changerNomFichier();
	}

	public String getNumeroTel() {
		return NumeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		NumeroTel = numeroTel;
	}

	public String getNumeroMobile() {
		return NumeroMobile;
	}

	public void setNumeroMobile(String numeroMobile) {
		NumeroMobile = numeroMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ImageIcon getPhoto() {
		return photo;
	}

	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}
	
	public static void setChemin(String path) {
		chemin = path;
	}
	
	public static String setChemin() {
		return chemin;
	}
	public static String getChemin() {
		return chemin;
	}

	public String getNomFichier() {
		return nomFichier;
	}


	public void enregistrer() 
	{
		System.out.println("le formulaire");
		System.out.println("validation si tout champ pleinn et contact existe pas deja=> puis création");
		String nomFichier = nom+prenom;
		serializeObject( nomFichier,  nom,  prenom,  NumeroTel,  NumeroMobile,  email,  photo); //écrire
	}
	private void serializeObject(String nomFichier, String nom, String prenom, String numeroTel, String numeroMobile, String email, ImageIcon photo) {
		Contact cs = new Contact(nom,prenom,numeroTel,numeroMobile,email,photo);
		File f = new File(chemin+nomFichier+".txt");
		if(f.exists()) { f.delete(); System.out.println("FICHIER SOUPRIMAY");}
		try {
			FileOutputStream fichier = new FileOutputStream(chemin+nomFichier+".txt");
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(cs);
			oos.flush();
			oos.close();
		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
	
	private void changerNomFichier() {
		File f = new File(chemin+nomFichier+".txt");
		File f2 = new File(chemin+nom+prenom+".txt");
		try {
			Files.move(f.toPath(), f2.toPath(),REPLACE_EXISTING);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		nomFichier = nom + prenom;
	}
	
	public void suppressioncontact()
	{
		File f = new File(chemin+nomFichier+".txt");
		System.out.println(chemin+nomFichier+".txt");
		f.delete(); 
	}

	@Override
	public int compareTo(Object arg0) {
		Contact c = (Contact)arg0;
		if(this.getNom().compareTo(c.getNom())==0) {
			return getPrenom().compareTo(c.getPrenom());
		}else return getNom().compareTo(c.getNom());
	}
}


