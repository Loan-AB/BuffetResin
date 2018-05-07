package apparence;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MaFenetre extends JFrame {
	
	PnlBas pnlBas;
	PnlHaut pnlHaut;
	PnlCentre pnlCentre;
	
	public MaFenetre()
	{
		pnlBas = new PnlBas();
		pnlCentre = new PnlCentre("coucou");
		pnlHaut = new PnlHaut();
		//pour que la fenetre soit au centre
		this.setLocationRelativeTo(null);
		
		//this.setLocation(5, 10); on peux choisir
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //car la prorpiétl et statique cêst pour ça que on a accès

		
		
		setLayout(new Box());
		this.setSize(480, 800);
		pnlBas.setLayout(new fLO());
		pnlCentre.setLayout(new BorderLayout());
		pnlHaut.setLayout(new BorderLayout());
	
		add(pnlHaut,BorderLayout.NORTH);
		add(pnlCentre, BorderLayout.CENTER);
		add(pnlBas, BorderLayout.SOUTH);
		
	
		

		this.setVisible(true); //ça toujours a la fin
		
		

	
	}
}

