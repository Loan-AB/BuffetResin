package apparence;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import composant.MonBouton;
import main.main;
import vue.Panel_Gridlayout;

public class MaFenetre extends JFrame {
	
	public MaFenetre()
	{
		this.setSize(200, 200);
		//pour que la fenetre soit au centre
		this.setLocationRelativeTo(null);
		
		//this.setLocation(5, 10); on peux choisir
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //car la prorpiétl et statique cêst pour ça que on a accès


		
		Panel_Gridlayout monPanel = new Panel_Gridlayout();
		

		this.add(monPanel);
		
		

		this.setVisible(true); //ça toujours a la fin
		
		

	
	}
}

