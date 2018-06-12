package gestionGalerie;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MonBoutonPhoto extends JButton
{ 
	/**
	 * cette classe permet de param�tr� notre bouton avec une image
	 * 
	 * @author loanb and julien
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon ii;
	
	/**
	 * @author julien
	 * @param monImage
	 */
	public MonBoutonPhoto(MonImage monImage) 
	{
		
		ii = monImage.photoSortie;
		
		// TODO Auto-generated constructor stub	
		
		setPreferredSize(new Dimension(100,100));
		//
		setIcon(ii);
		//setBorder(new RoudedBorder(20));
		
		setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		setBorderPainted(false);
	}
	
	/**
	 * @return
	 */
	public ImageIcon getImageIcon() 
	{
		return ii;
	}
	
}

		

	
			
		
		
		
	
