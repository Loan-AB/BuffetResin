package gestionGalerie;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import apparence.PnlCentre;

public class PhotoAgrandie extends PnlCentre {
	ImageIcon grandeImage = new ImageIcon();
	JLabel labelPhoto;
	public PhotoAgrandie(Icon image) {
		super("photo");
		labelPhoto=new JLabel(image);
		add(labelPhoto);
		setSize(480, 800);	
	}
}
