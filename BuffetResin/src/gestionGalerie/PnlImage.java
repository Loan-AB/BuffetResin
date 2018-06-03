package gestionGalerie;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
			public void actionPerformed(ActionEvent e) {
				System.err.println(monImageIcon.getDescription()); //contient l'url de l'image
				System.out.println(monImageIcon.getDescription());  
				File file = new File(monImageIcon.getDescription());
				
				J
				
//				System.out.println(e.getSource().toString());
				
//				File file = new File(e.getSource().toString());
//			//	System.out.println(file);
//			String fichierSource = file.getAbsolutePath();
//			
//			System.out.println(fichierSource);
//			this.remove(fichierSource);
//			revalidate();
//			repaint();
			
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
