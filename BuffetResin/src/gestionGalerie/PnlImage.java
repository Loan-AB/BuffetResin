package gestionGalerie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.PnlAccueil;
import apparence.PnlCentre;

public class PnlImage extends PnlCentre implements ImageObserver {
	JLabel lblImage;
	ImageIcon monImageIcon;
	MaFenetre maman;
	MonBouton btnDelete;
	MesImages imagesListe =  new MesImages();
	MonBouton btnValiderPhotoContact;

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
				for (int i = 0; i < imagesListe.listePhoto.length; i++) 
				{
					if (imagePath.getAbsolutePath().equals(imagesListe.listePhoto[i].getAbsolutePath())) 
					{
						System.out.println(imagesListe.listePhoto[i].getAbsolutePath());
						delete(imagesListe.listePhoto[i].getAbsolutePath());
						maman.changeCouche("Galerie");
					}
				}
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
	public void setImage(ImageIcon monImageIcon , String description) //loan 08.06.2018
	{
		this.monImageIcon = monImageIcon;
		this.monImageIcon.setDescription(description);
		System.out.println(monImageIcon.getDescription());
		lblImage.setIcon(monImageIcon);
	}
	private void delete(String file) {
    		File fichier = new File(file);
    		fichier.delete();
    		maman.changeCouche("Gallerie");
    }
	public void setbContactBouton(boolean bContact) { //loan
		btnValiderPhotoContact.setVisible(bContact);
		
	}

}
