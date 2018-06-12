package apparence;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import gestionGalerie.MonImage;

public class MonBouton extends JButton 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * le constructeur des boutons par defaut
	 * @param nom
	 * @author loanb
	 */
	public MonBouton(String nom)
	{
		super(" ");
		this.setActionCommand(nom);
		this.setText(nom);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	/**
	 * le contrsucteur pout les bouton qui sont par defaut non visible
	 * @param nom
	 * @param b
	 * @author loanb
	 */
	public MonBouton(String nom, boolean b) 
	{
		super(" ");
		this.setActionCommand(nom);
		this.setText(nom);
		this.setVisible(b);
	}
	
	/**
	 * le constructeur pour les boutons qui contienne une image en plus
	 * @param nom
	 * @param path
	 * @author loanb
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
	 * le constructeur pour les boutons qui contienne une image en plus et on précise la taille
	 * @param nom
	 * @param path
	 * @param taille
	 * @author loanb
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
