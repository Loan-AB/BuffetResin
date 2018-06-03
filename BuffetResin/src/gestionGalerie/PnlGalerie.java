package gestionGalerie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.PnlCentre;

public class PnlGalerie extends PnlCentre {


	MaFenetre maman;
	MesImages mesImages = new MesImages();
	JPanel panelPhoto = new JPanel();
	JScrollPane scrollPane = new JScrollPane(panelPhoto);
	BouttonPhoto []bouttonPhoto= new BouttonPhoto[mesImages.images.length];
	ImageIcon monImage;
	WrapLayout wrapLayout = new WrapLayout(3);
	
	CardLayout coucheGallerie  = new CardLayout();
	
	public PnlGalerie(MaFenetre maman) {
		super("Galerie");
		
		this.maman = maman;	

		//setLayout(coucheGallerie);
		
		add(scrollPane,BorderLayout.CENTER);
		//scrollPane.setPreferredSize(new Dimension(480, 800));
		panelPhoto.setLayout(new WrapLayout(3));
		//
		scrollPane.setPreferredSize(new Dimension(460,600));
		
		for(int i=0;i<mesImages.images.length;i++) {
			monImage = mesImages.recupererImage(i);
			
			bouttonPhoto[i] = new BouttonPhoto(new MonImage(i));
			
			panelPhoto.add(bouttonPhoto[i]);
			//scrollPane.add(bouttonPhoto[i]);
			
			bouttonPhoto[i].addMouseListener(new MouseAdapter()
			 {
				public void mouseClicked(MouseEvent e) {
					System.out.println(((BouttonPhoto)(e.getSource())).getImageIcon());
					ImageIcon ii = ((BouttonPhoto)(e.getSource())).getImageIcon();
					
					
					Image image = ii.getImage(); // transform it 
					Image newimg = image.getScaledInstance(460,600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					
					ImageIcon photoAgrandieSeul = new ImageIcon(newimg);
					maman.afficherImage(photoAgrandieSeul);
					
				}
			});
		}
	}


}
