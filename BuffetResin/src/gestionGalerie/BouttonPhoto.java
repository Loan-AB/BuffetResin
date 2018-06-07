package gestionGalerie;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;






public class BouttonPhoto extends JButton{
	
	ImageIcon ii;
	
	public BouttonPhoto(MonImage monImage) {
		
		ii = monImage.photoSortie;
		
		// TODO Auto-generated constructor stub	
		
		setPreferredSize(new Dimension(100,100));
		//
		setIcon(ii);
		//setBorder(new RoudedBorder(20));
		
		setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		//setBorder(new RoudedBorder(5));
		
	}
	
	public ImageIcon getImageIcon() {
		return ii;
	}
	
}

		

	
			
		
		
		
	
