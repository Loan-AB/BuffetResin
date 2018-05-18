package gestionContact;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;


public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
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
	}
	
	public Contact(String nom, String prenom, String numeroTel, String numeroMobile, String email) {
		
		//on pourrait a la limite déterminer 4 photo par derfaut avec un aléatoire.
		ImageIcon photo = new ImageIcon("C:\\Users\\loanb\\Downloads\\ImageContact\\chang.jpg");
		this.nom = nom;
		this.prenom = prenom;
		NumeroTel = numeroTel;
		NumeroMobile = numeroMobile;
		this.email = email;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
}


