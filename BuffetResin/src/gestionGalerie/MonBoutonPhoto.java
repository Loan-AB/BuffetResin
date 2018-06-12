package gestionGalerie;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;







public class MonBoutonPhoto extends JButton
{ 
	ImageIcon ii;
	
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
		setBorderPainted(false);;
		
	}
	
	/**
	 * @return
	 */
	public ImageIcon getImageIcon() 
	{
		return ii;
	}
	
}

		

	
			
		
		
		
	
