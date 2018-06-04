package apparence;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.Border;

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
	
}
