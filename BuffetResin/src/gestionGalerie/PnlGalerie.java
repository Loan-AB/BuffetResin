package gestionGalerie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

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
	MonImage monImage;
	WrapLayout wrapLayout = new WrapLayout(3);
	
	CardLayout coucheGallerie  = new CardLayout();
	
	RecuperationImage recuperationImage = new RecuperationImage();
	
	public PnlGalerie(MaFenetre maman) {
		super("Galerie");
		
		this.maman = maman;	
		add(new MonBouton("ajout", true),BorderLayout.NORTH);
		
		//setLayout(coucheGallerie);
		
		add(scrollPane,BorderLayout.CENTER);
		//scrollPane.setPreferredSize(new Dimension(480, 800));
		panelPhoto.setLayout(new WrapLayout(3));
		//
		scrollPane.setPreferredSize(new Dimension(460,600));
		
		
		
		for(int i=0;i<mesImages.images.length;i++) {
			monImage = new  MonImage(i);
			
			bouttonPhoto[i] = new BouttonPhoto(monImage);
			
			panelPhoto.add(bouttonPhoto[i]);
			//scrollPane.add(bouttonPhoto[i]);
			
			bouttonPhoto[i].addMouseListener(new RecuperationImage());
		}
		

	}
}
