package apparence;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class ButtonAccueil extends Canvas {
	ImageIcon  image;
	public ButtonAccueil(String name,String path)
	{
		
		this.setSize(new Dimension(100,100));
		image = new ImageIcon(path); // transform it 
//		Image newimg = image.getScaledInstance(60,60,  java.awt.Image.SCALE_AREA_AVERAGING); // scale it the smooth way  
		image.getIconWidth();
		image.getIconHeight();
//		ImageIcon photoSortie = new ImageIcon(newimg);
		//JLabel label = new JLabel(MonImage.transformationImage(image.getDescription(),this.getWidth()));
		setBackground(Color.BLACK);
		//label.setOpaque(true);
		//label.setBackground(Color.WHITE);
		//add(label);
		//setIcon(entreePhoto);
		//setBorder(new RoudedBorder(20));
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image.getImage(), 10, 10, 10, 10, null);
	}
}
