package apparence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PnlAccueil extends PnlCentre 
{
	
	MonBouton btnContact;
	MonBouton btnGalerie;
	MonBouton btnCalculatrice;
	MaFenetre maman;
	JLabel labelWallPaper = new JLabel(new ImageIcon("./src/photoDefault/wallpaper1.png"));

	public PnlAccueil(MaFenetre maman) 
	{
		super("Acceuil");
		this.maman= maman;

		btnContact = new MonBouton("Contact","./src/photoDefault/Contact1.png");
		btnGalerie = new MonBouton("Galerie","./src/photoDefault/Gallery.png");
		btnCalculatrice = new MonBouton("Calculatrice","./src/photoDefault/Calculator.png");	
		setOpaque(false);
		add(btnContact);
		add(btnGalerie);
		add(btnCalculatrice);
		add(labelWallPaper);
		
	}

	public void setListenerBtn(ActionListener lancerContact, ActionListener lancerSecret,ActionListener lancerGalerie) 
	{
		btnContact.addActionListener(lancerContact);
		btnGalerie.addActionListener(lancerGalerie);
		btnCalculatrice.addActionListener(lancerSecret);
	}
	
	public void setListenerBtn(ActionListener lancerAppli) 
	{
		btnContact.addActionListener(lancerAppli);
		btnGalerie.addActionListener(lancerAppli);
		btnCalculatrice.addActionListener(lancerAppli);
	}
	
}
