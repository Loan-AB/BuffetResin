package apparence;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import gestionGalerie.MonImage;

public class PnlBas extends JPanel 
{
// Panel qui contient les 3 bouttons de base
	
	private MonBouton btnHome;
	private MonBouton btnBack;
	
	/**
	 * 
	 */
	public PnlBas()
	{
		setSize(480, 70);
		setBackground(Color.CYAN);
		//test pour les composant du bas
		btnHome = new MonBouton("Accueil");
		btnBack = new MonBouton("retour");

		setBorder(new LineBorder(Color.BLACK,1,false));
		MonImage m = new MonImage(); //instencier , pour ne pas avoir de static
		btnHome.setIcon(m.transformationImage( "./src/photoDefault/Home.png", 15));
		btnBack.setIcon(m.transformationImage( "./src/photoDefault/Back.png", 15));
		this.add(btnBack);
		this.add(btnHome);
	}
	/**
	 * @param home
	 * @param back
	 */
	public void setListenerBtn(ActionListener home, ActionListener back) 
	{
		btnHome.addActionListener(home);
		btnBack.addActionListener(back);
	}
}
