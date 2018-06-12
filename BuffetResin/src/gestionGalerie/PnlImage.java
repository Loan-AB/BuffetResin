package gestionGalerie;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;



import javax.swing.ImageIcon;

import javax.swing.JLabel;


import apparence.MaFenetre;
import apparence.MonBouton;

import apparence.PnlCentre;

//Panel ou est affiché l'image seul

public class PnlImage extends PnlCentre implements ImageObserver 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JLabel lblImage;
	private  ImageIcon monImageIcon;
	private  MaFenetre maman;
	private  MonBouton btnDelete;
	protected  MesImages imagesListe =  new MesImages();
	private  MonBouton btnValiderPhotoContact;
	private  int numImage;

	
	/**
	 * @param maman
	 */
	public PnlImage(MaFenetre maman) 
	{
		super("Galerie");
		this.maman = maman;
		btnDelete = new MonBouton("Supprimer");
		btnDelete.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			File imagePath = new File(monImageIcon.getDescription());
				delete(monImageIcon.getDescription());
				maman.changeCouche("Galerie");
			}
		});
		btnValiderPhotoContact = new MonBouton("Valider",false);
		
		btnValiderPhotoContact.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
//				System.out.println("clicker valider :D");
//				System.out.println(monImageIcon.getDescription());
				maman.setImageFormulaireNouveauContact(monImageIcon);
				maman.changeCouche("Formulaire");
			}
		});
		add(btnDelete,BorderLayout.NORTH);
		add(btnValiderPhotoContact);
		// TODO Auto-generated constructor stub
		lblImage = new JLabel();
		add(lblImage);		
	}

	/**
	 * setImage 
	 * affiche l'image aen grand par rapport au bouton cliquer
	 * @param monImageIcon
	 * @param description
	 * @param numImage
	 * @author loanb
	 */
	public void setImage(ImageIcon monImageIcon , String description, int numImage) //loan 08.06.2018
	{
		this.numImage = numImage;
		this.monImageIcon = monImageIcon;
		this.monImageIcon.setDescription(description);
//		System.out.println(monImageIcon.getDescription());
		lblImage.setIcon(monImageIcon);
	}
	
	/**
	 * supprimer le fichier du dossier selectionner
	 * @param file
	 * @author loanb
	 */
	private void delete(String file)
	{
    		File fichier = new File(file);
    		fichier.delete();
    		maman.changeCouche("Gallerie");
    		maman.supprimerImage(numImage);
    }
	
	/**
	 * réation d'un bouton pour le lien entre gallerie et contact
	 * setbContactBouton
	 * permet de choisir par rapport au bollean si on affiche le bouton supprimer ou le bouton valider
	 * 
	 * @param bContact
	 * @author loanb
	 */
	public void setbContactBouton(boolean bContact) 
	{ //loan
		btnValiderPhotoContact.setVisible(bContact);
		btnDelete.setVisible(!bContact);
	}

}
