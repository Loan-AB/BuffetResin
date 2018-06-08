package gestionContact;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.MonJtextArea;
import apparence.MonLabel;
import apparence.PnlCentre;
import gestionCalculatrice.monBoutonCalculatrice;
import gestionContact.*;
import gestionGalerie.BouttonPhoto;
import gestionGalerie.MonImage;

public class PnlFormulaireContact  extends PnlCentre 
{ //pas sure

	//concernant les lbl globaux vraiment important ? //loan
	
	MonBouton btnValiderContact;
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
	
	MonLabel lblTitre;
	public PnlFormulaireContact(MaFenetre maman) 
{
		super("Formulaire");
		this.maman = maman;
	
		btnAnnuler = new MonBouton("Annuler");
		btnValiderContact = new MonBouton("Valider");
		btnSupprimer = new MonBouton("Suprimmer");
		btnChoixImage = new MonBouton("ChoixImage");
		txtNom = new MonJtextArea("Nom");
		txtPrenom = new MonJtextArea("Prenom");
		txtNumeroTel = new MonJtextArea("Telephonne");
		txtNumeroMobile = new MonJtextArea("Mobile");
		txtEmail = new MonJtextArea("Email");
		txtNom.addFocusListener(null);

		lblImage = new JLabel("",JLabel.CENTER);
		lblTitre = new MonLabel();
		lblTitre.setSize(new Dimension(100, 100));

		add(lblImage);
		lblTitre = new MonLabel();
		lblTitre.setText("Nom :\t ");
		add(lblTitre);
		
		add(txtNom);
		
		lblTitre = new MonLabel();
		lblTitre.setText("Prénom :\t ");
		add(lblTitre);
		
		add(txtPrenom);
		
		lblTitre = new MonLabel();
		lblTitre.setText("E-Mail :\t ");
		add(lblTitre);
		add(txtNumeroTel);
		
		lblTitre = new MonLabel();
		lblTitre.setText("Tél. Mobile :\t ");
		
		add(lblTitre);
		add(txtNumeroMobile);
		
		lblTitre = new MonLabel();
		lblTitre.setText("Tél. Fixe :\t ");

		add(lblTitre);
		add(txtEmail);
		add(btnAnnuler ); 
		add(btnValiderContact);
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
		btnValiderContact.addActionListener(new ActionListener() 
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
					contact.setNom(txtNom.getText());
					contact.setPrenom(txtPrenom.getText());
					contact.setEmail(txtEmail.getText());
					contact.setNumeroMobile(txtNumeroMobile.getText());
					contact.setNumeroTel(txtNumeroTel.getText());
					//je doti faire qqch par la pour la size des images je pense //loan 08.06.2018
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
				maman.setbContact(true);
				maman.changeCouche("Galerie");
			}
		});
	}
	public void dechargement() 
	{
		contact = null;
		txtNom.setText("");
		txtPrenom.setText("");
		txtEmail.setText("");
		txtNumeroMobile.setText("");
		txtNumeroTel.setText("");
		maman.setbContact(false);
		setImage(new ImageIcon(".\\src\\photoGallerie\\default.png")); 
		
	}
	public void setContact(Contact contact) 
	{
		//ajout des élément dsand
		this.contact = contact;
		txtNom.setText(contact.getNom());	
		lblImage.setIcon(contact.getPhoto());
		txtEmail.setText(contact.getEmail());
		txtNumeroMobile.setText(contact.getNumeroMobile());
		txtNumeroTel.setText(contact.getNumeroTel());
		txtPrenom.setText(contact.getPrenom());
		//loan ajout
		setImage(contact.getPhoto());	
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

