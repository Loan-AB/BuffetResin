package gestionContact;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Contact {
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

	@Override
	public String toString() {
		return "Contact : " + nom  + " " + prenom + " " + NumeroTel + " " + NumeroMobile +  " " + email ;
	}
	
	public ImageIcon getImageIcon() {
		return photo;
	}
}


