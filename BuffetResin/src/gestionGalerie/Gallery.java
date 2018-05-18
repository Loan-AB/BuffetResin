package gestionGalerie;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

import apparence.PnlCentre;
import apparence.PnlSecret;
//import test.BouttonPhoto;
//import test.MesImages;
//import test.MonImage;

public class Gallery extends PnlCentre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	MesImages mesImages = new MesImages();
	JPanel panelPhoto = new JPanel();
	
	
	public Gallery() {
		
		setLayout(new BorderLayout());
		add(panelPhoto);
		
		
		
		
		
		panelPhoto.setLayout(new GridLayout(3,5));
		
	
		for(int i=0;i<mesImages.images.length;i++) {
			
			panelPhoto.add(new BouttonPhoto(new MonImage(i)));
			
		}
		
		
	
	
		
		setSize(480,800);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	

}
