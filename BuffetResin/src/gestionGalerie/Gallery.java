package gestionGalerie;

import apparence.PnlCentre;
import apparence.PnlSecret;

public class Gallery extends PnlCentre {
	
	BouttonPhoto bouttonPhoto[];
	MesImage mesImage[];
	JPanel panelScrollbar = new JPanel();
	JPanel panelPhoto = new JPanel();
	
	public Gallery() {
		// TODO Auto-generated constructor stub
		
		
		PanelGallery.setLayout(new BorderLayout());
		
		panelPhoto.setLayout(new GridLayout(4,2));
		
		for(int i=0;i<bouttonPhoto.length;i++)	
			panelPhoto.add(bouttonPhoto[i]);
			
		
		
		
		
	}

}
