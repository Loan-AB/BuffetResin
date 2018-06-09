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
	
	ImageIcon iiDefaut;
	MonLabel lblTitre;
	public PnlFormulaireContact(MaFenetre maman) 
{
		super("Formulaire");
		this.maman = maman;
	
		btnAnnuler = new MonBouton("Annuler");
		btnValider = new MonBouton("Valider");
		btnSupprimer = new MonBouton("Suprimmer");
		btnChoixImage = new MonBouton("ChoixImage");
		txtNom = new MonJtextArea("Nom");
		txtPrenom = new MonJtextArea("Prenom");
		txtNumeroTel = new MonJtextArea("Telephonne");
		txtNumeroMobile = new MonJtextArea("Mobile");
		txtEmail = new MonJtextArea("Email");
		txtNom.addFocusListener(null);
		iiDefaut = new ImageIcon(".\\src\\photoDefault\\default.png");
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
		lblTitre.setText("Tél. Fixe :\t ");
		add(lblTitre);
		add(txtNumeroTel);
		
		lblTitre = new MonLabel();
		lblTitre.setText("Tél. Mobile :\t ");
		add(lblTitre);
		add(txtNumeroMobile);
		
		lblTitre = new MonLabel();
		lblTitre.setText("E-Mail :\t ");
		add(lblTitre);
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
				System.out.println("cc");
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
					
					//lors de la création pas de pb
					//car on clique qu'une seule fois sur choix image
				}
				else 
				{
					contact.setNom(txtNom.getText());
					contact.setPrenom(txtPrenom.getText());
					contact.setNumeroTel(txtNumeroTel.getText());
					contact.setNumeroMobile(txtNumeroMobile.getText());
					contact.setEmail(txtEmail.getText());
					contact.setPhotoDescription(iiformulaire.getDescription());
					contact.setPhoto(MonImage.transformationImage(iiformulaire.getDescription(), 120, 120));
					contact.setPhotoDescription(iiformulaire.getDescription());
					//mais si on modifier ya un pb :/
				}
				System.err.println(maman.toString());
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
		setImage(iiDefaut); 
		
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

		//ici contrôler si le l'image existe toujours
		
		if ( new ImageIcon (contact.getPhotoDescription()).getImageLoadStatus() != 8)
		{
			setImage(new ImageIcon (iiDefaut.getDescription()));
			contact.setPhoto(MonImage.transformationImage(iiDefaut.getDescription(), 120, 120));
			contact.setPhotoDescription(iiDefaut.getDescription());
		}
		else
		{
			setImage(new ImageIcon (contact.getPhotoDescription()));	
		}
//		System.out.println("donne moir le statuts" + new ImageIcon (contact.getPhotoDescription()).getImageLoadStatus());
		
//			setImage(new ImageIcon (contact.getPhotoDescription()));	
		
		
		
	}
	public void setImage(ImageIcon laNouvelleimage) 
	{
		setlblImage(laNouvelleimage);//pour l'affichage
	}

	private void setlblImage (ImageIcon MaFutureIcone) //affichage du label avec la bonne image
	{
		this.iiformulaire = MaFutureIcone;
		lblImage.setIcon(MonImage.transformationImage(MaFutureIcone.getDescription(), lblImage.getWidth()));
	}

}

