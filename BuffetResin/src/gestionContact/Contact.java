package gestionContact;

public class Contact {
	private String nom;
	private String prenom;
	private String NumeroTel;
	private String NumeroMobile;
	private String email;
	
	public Contact(String nom, String prenom, String numeroTel, String numeroMobile, String email) {
		this.nom = nom;
		this.prenom = prenom;
		NumeroTel = numeroTel;
		NumeroMobile = numeroMobile;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact : " + nom  + " " + prenom + " " + NumeroTel + " " + NumeroMobile +  " " + email ;
	}
}
