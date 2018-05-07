package apparence;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MaFenetre extends JFrame {
	
	PnlBas pnlBas;
	PnlHaut pnlHaut;
	PnlCentre pnlCentre;
	
	@SuppressWarnings("deprecation")
	public MaFenetre()
	{
		pnlBas = new PnlBas();
		pnlCentre = new PnlCentre("coucou");
		pnlHaut = new PnlHaut();
		
		//pour le temps
		
		java.util.GregorianCalendar calendar = new GregorianCalendar();
		java.util.Date time  = calendar.getTime();
		
		//test pour les composant du bas
		MonBouton btnhome = new MonBouton("home", true);
		MonBouton btnretour = new MonBouton("retour", true);
		MonBouton btnsuivant = new MonBouton("suivant", true);
		
		//test pour les composant du haut
		MonLabel lblTime = new MonLabel();
		
		
		
		//pour que la fenetre soit au centre
		this.setLocationRelativeTo(null);
		
		//this.setLocation(5, 10); on peux choisir
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //car la prorpiétl et statique cêst pour ça que on a accès

		
		
		//setLayout(new Box(defaultCloseOperation));
		this.setSize(480, 800);
		pnlBas.setLayout(new FlowLayout());
		pnlCentre.setLayout(new GridLayout());
		pnlHaut.setLayout(new FlowLayout());
	
		
		//ajout dans la fenetre  , les panels
		add(pnlHaut,BorderLayout.NORTH);
		add(pnlCentre,BorderLayout.CENTER);
		add(pnlBas, BorderLayout.SOUTH);
		
		//ajout du matos dans les panel

		// le haut : 
		pnlHaut.add(lblTime);
		lblTime.setText(time.toLocaleString()); //sera réglé par un timer ou prise du temps du pc
		
		//System.out.println("time" + time);
		
		//le centre : 
		
		//le bas : 
		
		pnlBas.add(btnretour);
		pnlBas.add(btnhome);
		pnlBas.add(btnsuivant);
		

		this.setVisible(true); //ça toujours a la fin
	

	
	}

	
}

