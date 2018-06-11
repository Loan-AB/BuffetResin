package apparence;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import gestionGalerie.MonImage;

public class MonBouton extends JButton 
{
	/**
	 * @param nom
	 */
	public MonBouton(String nom)
	{
		super(" ");
		this.setActionCommand(nom);
		this.setText(nom);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	/**
	 * @param nom
	 * @param b
	 */
	public MonBouton(String nom, boolean b) 
	{
		super(" ");
		this.setActionCommand(nom);
		this.setText(nom);
		this.setVisible(b);
		this.setBackground(Color.BLACK);
	}
	
	/**
	 * @param nom
	 * @param path
	 */
	public MonBouton(String nom,String path )
	{
		super(" ");
		this.setBorderPainted(false); //pour ne 5pas voir les bordures
		this.setActionCommand(nom);
		super.setText(" ");
		this.setFocusPainted(false);
		this.setOpaque(false); //pour que le fond soit opaque
		MonImage m = new MonImage(); //instencier
		this.setIcon(m.transformationImage(path,70)); 
		this.setBackground(Color.BLACK);
	}
	/**
	 * @param nom
	 * @param path
	 * @param taille
	 */
	public MonBouton(String nom, String path, int taille) 
	{
		super(" ");
		this.setBorderPainted(false); //pour ne pas voir les bordures
		this.setActionCommand(nom);
		super.setText(" ");
		this.setFocusPainted(false);
		this.setOpaque(false); //pour que le fond soit opaque
		MonImage m = new MonImage(); //instencier , pour ne pas avoir de static
		this.setIcon(m.transformationImage(path,taille));
		this.setBackground(Color.BLACK);
	}
}
