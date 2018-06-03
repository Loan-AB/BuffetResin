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
	
	public BouttonPhoto(ImageIcon monImage) {
		
		ii = monImage;
		
		// TODO Auto-generated constructor stub	
		
		setPreferredSize(new Dimension(140,140));
		//
		setIcon(ii);
		
		
	}
	
	public ImageIcon getImageIcon() {
		return ii;
	}
	
}

		

	
			
		
		
		
	
