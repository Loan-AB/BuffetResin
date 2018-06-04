package gestionContact;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.MonJtextArea;
import apparence.MonLabel;
import apparence.PnlCentre;
import gestionContact.*;
import gestionGalerie.MonImage;

public class PnlFormulaireContact  extends PnlCentre { //pas sure

	//concernant les lbl globaux vraiment important ?
	
	MonBouton btnValider;
	MonBouton btnAnnuler;
	MonBouton btnSupprimer;
	MonBouton btnChoixImage;
	
	JTextArea txtNom;
	JTextArea txtPrenom;
	JTextArea txtNumeroTel;
	JTextArea txtNumeroMobile;
	JTextArea txtEmail;
	
	MaFenetre maman;
	Contact contact;
	JLabel image;
	public PnlFormulaireContact(MaFenetre maman) {
		super("Formulaire");
		this.maman = maman;
		btnAnnuler = new MonBouton("Annuler", true);
		btnValider = new MonBouton("Valider", true);
		btnSupprimer = new MonBouton("Suprimmer", true);
		btnChoixImage = new MonBouton("ChoixImage", true);
		txtNom = new MonJtextArea("Nom");
		txtPrenom = new MonJtextArea("Prenom");
		txtNumeroTel = new MonJtextArea("Telephonne");
		txtNumeroMobile = new MonJtextArea("Mobile");
		txtEmail = new MonJtextArea("Email");
		txtNom.addFocusListener(null);
		
		image = new JLabel();
		
		add(image);

		add(txtNom);
		add(txtNom);
		add(txtPrenom);
		add(txtNumeroTel);
		add(txtNumeroMobile);
		add(txtEmail);
		
		add(btnAnnuler ); 
		add(btnValider);
		add(btnSupprimer);
		add(btnChoixImage);
		image.setPreferredSize(new Dimension(480,200));
		
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dechargement();
				maman.changeCouche("Contact");
			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

					 contact.suppressioncontact();
					 maman.supprimerContact(contact);

				//réaffiche les contact
				System.out.println(contact.getNom());
				dechargement();
				maman.changeCouche("Contact");
			}
		});
		
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(contact == null) {
					contact = new Contact(txtNom.getText(), txtPrenom.getText(), 
							txtEmail.getText(), txtNumeroMobile.getText(), txtNumeroTel.getText());
				}
				else {
					contact.setNom(txtNom.getText());
					contact.setPrenom(txtPrenom.getText());
					contact.setEmail(txtEmail.getText());
					contact.setNumeroMobile(txtNumeroMobile.getText());
					contact.setNumeroTel(txtNumeroTel.getText());
					
				}
				contact.enregistrer();
				maman.ajouterContact(contact);
				dechargement();
				maman.changeCouche("Contact");
			}
		});
		
btnChoixImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maman.changeCouche("ChoixImage");
			}
		});
	}

private void dechargement() {
	contact = null;
	txtNom.setText("");
	txtPrenom.setText("");
	txtEmail.setText("");
	txtNumeroMobile.setText("");
	txtNumeroTel.setText("");
	image.setIcon(MonImage.transformationImage(new ImageIcon(".\\src\\photoGallerie\\default.png"), image.getWidth()));
	
	
	//image.setIcon(new ImageIcon(".\\src\\photoGallerie\\default.png"));
	//ici loan , il faut voir une soluton pour changer la taille.
}

public void setContact(Contact contact) {
	this.contact = contact;
	
	txtNom.setText(contact.getNom());	
	image.setIcon(contact.getImageIcon());
	txtEmail.setText(contact.getEmail());
	txtNumeroMobile.setText(contact.getNumeroMobile());
	txtNumeroTel.setText(contact.getNumeroTel());
	txtPrenom.setText(contact.getPrenom());
//	image.setIcon(MonImage.transformationImage(contact.getImageIcon(), image.getWidth()));
}

public void setImage(ImageIcon description) {
	image.setIcon(MonImage.transformationImage(description, image.getWidth()));
}

}

