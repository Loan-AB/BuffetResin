package apparence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gestionGalerie.BouttonPhoto;
import gestionGalerie.MonImage;
import gestionGalerie.RoudedBorder;

import java.*;



public class MonBouton extends JButton {
	
	
	
	public MonBouton(String name,Boolean isopaque )
	{
		
		this.setText(name.toString());
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		
		this.setOpaque(isopaque);
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		//this.setForeground(Color.green);
		this.setBackground(Color.LIGHT_GRAY);
		
		
		
		
	}
	
	public MonBouton(String name,Boolean isopaque,String path )
	{
		
		this.setText(name.toString());
		
		this.setSize(new Dimension(100,100));
		
		ImageIcon  image = new ImageIcon(path); // transform it 
//		Image newimg = image.getScaledInstance(60,60,  java.awt.Image.SCALE_AREA_AVERAGING); // scale it the smooth way  
		image.getIconWidth();
		image.getIconHeight();
//		ImageIcon photoSortie = new ImageIcon(newimg);
		JLabel label = new JLabel(MonImage.transformationImage(image.getDescription(),this.getWidth()));
		setBackground(Color.BLACK);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		add(label);
		//setIcon(entreePhoto);
		
	
      
		
		//setBorder(new RoudedBorder(20));
		
		
		
		
		
	}
	
}
