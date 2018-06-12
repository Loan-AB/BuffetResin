package apparence;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/*
 * ce Panel d'application (centre) est le modèle de tout 
 * les futurs et actuelle panel d'application
 * @author loanb
 */

public class PnlCentre extends JPanel 
{

	String nom;
	
	/* 
	 * ici cela sert a mettre on fond d'écran sur tout nos panel.
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * @author loanb
	 */
	@Override
	  protected void paintComponent(Graphics g) 
	{
	    super.paintComponent(g);
	        g.drawImage(new ImageIcon("./src/photoDefault/wallpaper1.png").getImage(), 0, 0, null);
	}
	
    	
	/**
	 * Constructeur de mon panel de base
	 * @param nom
	 * @author loanb
	 */
	public PnlCentre(String nom) 
	{
		setSize(480,200);
		this.nom = nom;
		setOpaque(true);
	}
}
