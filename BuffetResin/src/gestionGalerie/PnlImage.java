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
	JLabel image;
	ImageIcon monImageIcon;
	MaFenetre maman;
	MonBouton btnDelete;
	MesImages imagesListe =  new MesImages();
	
	
	
	public PnlImage(MaFenetre mama) {
		super("Galerie");
		this.maman = maman;
		
		
		
		btnDelete = new MonBouton("Supprimer", true);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	System.err.println(monImageIcon.getDescription()); //contient l'url de l'image cette fois pour de vrai XD
			//	System.out.println(monImageIcon.getDescription());  
			File imagePath = new File(monImageIcon.getDescription());
			
			System.out.println();
			System.out.println();
			
			
			
			//controle si image dans dossier images faire une boucle pour trouver image voulue
				// si oui supprimer si non rien.
			for (int i = 0; i < imagesListe.listePhoto.length; i++) {
				
				if (imagePath.getAbsolutePath().equals(imagesListe.listePhoto[i].getAbsolutePath())) {
					
					
					System.out.println(imagesListe.listePhoto[i].getAbsolutePath());
					delete(imagesListe.listePhoto[i].getAbsolutePath());
					mama.changeCouche("Galerie");
					
			}
			}
			
				
				
			
				
			
				
			
			
			
				
				
			
				
			
			
		
		 
		
			
			}
		});
		add(btnDelete,BorderLayout.NORTH);
		
		
		// TODO Auto-generated constructor stub
		image = new JLabel();
		add(image);		
	}
	public void setImage(ImageIcon photo) {
		monImageIcon = photo;
		image.setIcon(photo);
	}
	
	private void delete(String file) {
    		
    		File fichier = new File(file);
    		
    		//fichier.delete();
    		
    		
		
    }

}
