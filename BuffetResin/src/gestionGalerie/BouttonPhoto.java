package gestionGalerie;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;






public class BouttonPhoto extends JButton{
	
	ImageIcon ii;
	
	public BouttonPhoto(MonImage monImage) {
		
		ii = monImage.photoSortie;
		
		// TODO Auto-generated constructor stub	
		
		setPreferredSize(new Dimension(100,100));
		//
		setIcon(ii);
		//setBorder(new RoudedBorder(20));
		
		
	}
	
	public ImageIcon getImageIcon() {
		return ii;
	}
	
}

		

	
			
		
		
		
	
