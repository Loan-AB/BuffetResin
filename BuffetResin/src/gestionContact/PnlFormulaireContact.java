package gestionContact;

import java.awt.Canvas;
import java.awt.Color;
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
import gestionGalerie.BouttonPhoto;
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
	JLabel lblImage;
	ImageIcon iiformulaire;
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
		
		lblImage = new JLabel("",JLabel.CENTER);
		
		add(lblImage);
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
		
		lblImage.setPreferredSize(new Dimension(480,200));
		btnAnnuler.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				dechargement();
				maman.changeCouche("Contact");
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				contact.suppressioncontact();
				maman.supprimerContact(contact);
				//réaffiche les contact
				dechargement();
				maman.changeCouche("Contact");
			}
		});
		btnValider.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(contact == null) //si on crée un nouveau contact	
				{ 	
					contact = new Contact(txtNom.getText(), txtPrenom.getText(), txtNumeroTel.getText(),
							txtNumeroMobile.getText(), txtEmail.getText(), iiformulaire.getDescription().toString(), iiformulaire);
//					System.out.println("je suis dans la création d'un new contact" + iiformulaire.getDescription());
				}
				else 
				{
					System.out.println("mon contact est plein de chose hahhaha");
					contact.setNom(txtNom.getText());
					contact.setPrenom(txtPrenom.getText());
					contact.setEmail(txtEmail.getText());
					contact.setNumeroMobile(txtNumeroMobile.getText());
					contact.setNumeroTel(txtNumeroTel.getText());
					System.err.println(lblImage.getIcon());
					//lalalalalalal :D
					contact.setPhoto(iiformulaire);
					setImage(contact.getPhoto());						
				}
				contact.enregistrer();
				maman.ajouterContact(contact);
				dechargement();
				maman.changeCouche("Contact");
			}
		});
		
		btnChoixImage.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				maman.changeCouche("ChoixImage");
			}
		});
	}
	private void dechargement() 
	{
		contact = null;
		txtNom.setText("");
		txtPrenom.setText("");
		txtEmail.setText("");
		txtNumeroMobile.setText("");
		txtNumeroTel.setText("");
		setImage(new ImageIcon(".\\src\\photoGallerie\\default.png")); 
	}
	public void setContact(Contact contact) 
	{
		this.contact = contact;
		txtNom.setText(contact.getNom());	
		lblImage.setIcon(contact.getPhoto());
		txtEmail.setText(contact.getEmail());
		txtNumeroMobile.setText(contact.getNumeroMobile());
		txtNumeroTel.setText(contact.getNumeroTel());
		txtPrenom.setText(contact.getPrenom());
		//normalement ici ça devrait s'afficher lorsque l'on chang affiche le formaulaire O_O
		//loan ajout
	//	setImage(contact.getPhoto());
	//	lblImage.setIcon(MonImage.transformationImage(contact.getPhoto(), lblImage.getWidth()));
		lblImage.setIcon(contact.getPhoto());
	//	this.iiformulaire = contact.getPhoto();
	//	setlblImage(iiformulaire);//pour l'affichage
		System.err.println("bonjour je set le contact" + contact.getPhotoDescription());
	//	iiformulaire.setDescription(contact.getImageIcon().getDescription());
	//	setlblImage(iiformulaire);
	//	System.out.println(contact.getImageIcon().getDescription());
	//	image.setIcon(MonImage.transformationImage((contact.getImageIcon()), image.getWidth()));
	}
	public void setImage(ImageIcon laNouvelleimage) 
	{
		this.iiformulaire = laNouvelleimage;
		setlblImage(iiformulaire);//pour l'affichage
	}

	private void setlblImage (ImageIcon MaFutureIcone) //affichage du label avec la bonne image
	{
		lblImage.setIcon(MonImage.transformationImage(MaFutureIcone.getDescription(), lblImage.getWidth()));
	}

}

