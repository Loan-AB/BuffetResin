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
	protected JLabel lblImage;
	protected ImageIcon monImageIcon;
	protected MaFenetre maman;
	protected MonBouton btnDelete;
	protected MesImages imagesListe =  new MesImages();
	protected MonBouton btnValiderPhotoContact;
	protected int numImage;

	
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
			//controle si image dans dossier images faire une boucle pour trouver image voulue
				// si oui supprimer si non rien.
//				for (int i = 0; i < imagesListe.listePhoto.length; i++) 
//				{
//					if (imagePath.getAbsolutePath().equals(imagesListe.listePhoto[i].getAbsolutePath())) 
//					{
//						System.out.println(imagesListe.listePhoto[i].getAbsolutePath());
//						delete(imagesListe.listePhoto[i].getAbsolutePath());
//						maman.changeCouche("Galerie");
//					}
//				}
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
				System.out.println("clicker valider :D");
				System.out.println(monImageIcon.getDescription());
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
	 * @param monImageIcon
	 * @param description
	 * @param numImage
	 */
	public void setImage(ImageIcon monImageIcon , String description, int numImage) //loan 08.06.2018
	{
		this.numImage = numImage;
		this.monImageIcon = monImageIcon;
		this.monImageIcon.setDescription(description);
		System.out.println(monImageIcon.getDescription());
		lblImage.setIcon(monImageIcon);
	}
	
	/**
	 * @param file
	 */
	private void delete(String file)
	{
    		File fichier = new File(file);
    		fichier.delete();
    		maman.changeCouche("Gallerie");
    		maman.supprimerImage(numImage);
    }
	
	/**
	 * @param bContact
	 */
	public void setbContactBouton(boolean bContact) 
	{ //loan
		btnValiderPhotoContact.setVisible(bContact);
		btnDelete.setVisible(!bContact);
	}

}
