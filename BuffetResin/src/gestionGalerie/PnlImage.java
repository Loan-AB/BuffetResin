package gestionGalerie;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.PnlCentre;

public class PnlImage extends PnlCentre {
	JLabel image;
	ImageIcon monImageIcon;
	MaFenetre maman;
	MonBouton btnDelete;
	
	public PnlImage(MaFenetre mama) {
		super("Galerie");
		this.maman = maman;
		
		btnDelete = new MonBouton("Supprimer", true);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.err.println(monImageIcon.getDescription()); //contient l'url de l'image
				// Suppression image
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
	


}
