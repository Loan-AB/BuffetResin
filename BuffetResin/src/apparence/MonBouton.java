package apparence;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.Border;

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
		
		ImageIcon entreePhoto = new ImageIcon(path);
		
		Image image = entreePhoto.getImage(); // transform it 
		Image newimg = image.getScaledInstance(110,110,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		
		ImageIcon photoSortie = new ImageIcon(newimg);
		
		JLabel label = new JLabel(photoSortie);
		
		add(label);
		
		//setIcon(photoSortie);
		label.setBackground(Color.WHITE);
		
		setBorder(new RoudedBorder(20));
		
		
		setPreferredSize(new Dimension(150,150));
		
		
	}
	
}
