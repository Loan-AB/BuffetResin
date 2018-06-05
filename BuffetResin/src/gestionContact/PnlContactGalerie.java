package gestionContact;

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
import gestionGalerie.BouttonPhoto;
import gestionGalerie.MesImages;
import gestionGalerie.MonImage;
import gestionGalerie.PnlGalerie;
import gestionGalerie.WrapLayout;

public class PnlContactGalerie extends PnlCentre {

	protected MaFenetre maman;
	protected MesImages mesImages = new MesImages();
	protected JPanel panelPhoto = new JPanel();
	protected JScrollPane scrollPane = new JScrollPane(panelPhoto);
	protected BouttonPhoto []bouttonPhoto= new BouttonPhoto[mesImages.Size()];
	protected ImageIcon monImage;
	protected WrapLayout wrapLayout = new WrapLayout(3);
	
	CardLayout coucheGallerie  = new CardLayout();
	
	public PnlContactGalerie(MaFenetre maman) {
		super("Galerie");
		
		this.maman = maman;	

		//setLayout(coucheGallerie);
		
		add(scrollPane,BorderLayout.CENTER);
		//scrollPane.setPreferredSize(new Dimension(480, 800));
		panelPhoto.setLayout(new WrapLayout(3));
		//
		scrollPane.setPreferredSize(new Dimension(460,600));
		
		for(int i=0;i<mesImages.Size();i++) {
			monImage = mesImages.recupererImage(i);
			
			bouttonPhoto[i] = new BouttonPhoto(new MonImage(i));
			
			panelPhoto.add(bouttonPhoto[i]);
			//scrollPane.add(bouttonPhoto[i]);
			
			bouttonPhoto[i].addMouseListener(new MouseAdapter()
			 {
				public void mouseClicked(MouseEvent e) {

					maman.setImageFormulaireNouveauContact(((BouttonPhoto)(e.getSource())).getImageIcon());
					
					maman.changeCouche("Formulaire");
					
				}
			});
		}
	}


}
	



