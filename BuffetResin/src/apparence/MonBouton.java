package apparence;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import gestionGalerie.MonImage;



public class MonBouton extends JButton {
	
	String coucou;
	public MonBouton(String coucou)
	{
		super("");
		this.coucou = coucou;
		//this.setText(coucou);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		
		this.setOpaque(true);
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	public MonBouton(String coucou,String path )
	{
		super("");
		this.setBorderPainted(false); //pour ne pas voir les bordures
		this.coucou = coucou;
		super.setText("");
		this.setFocusPainted(false);
		this.setSize(new Dimension(100,100));
		this.setOpaque(false); //pour que le fond soit opaque
		this.setIcon(MonImage.transformationImage( new ImageIcon(path), 100));
		this.setBackground(Color.BLACK);
	}
	
	public MonBouton(String coucou,String path,int taille )
	{
		super("");
		this.setBorderPainted(false); //pour ne pas voir les bordures
		this.coucou = coucou;
		super.setText("");
		this.setFocusPainted(false);
		this.setSize(new Dimension(50,50));
		this.setOpaque(false); //pour que le fond soit opaque
		this.setIcon(MonImage.transformationImage( new ImageIcon(path),taille));
		this.setBackground(Color.BLACK);
	}
	
	public String getText() {
		return coucou;
	}
	
	@Override
	public void setText(String text) {
		if(getIcon() == null) {
			super.setText(text);
		}
		coucou = text;
	}

}
