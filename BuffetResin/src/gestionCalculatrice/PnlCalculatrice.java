package gestionCalculatrice;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.PnlCentre;

public class PnlCalculatrice extends PnlCentre {
	MaFenetre maman;
	monBoutonCalculatrice [] tabBouton;
	JTextArea txtChiffre;
	double chiffre,chiffre2;
	OperationStrategy os;
	
	public PnlCalculatrice(MaFenetre maman) 
	{
		super("Calculatrice");
		this.maman = maman;
		tabBouton =  new monBoutonCalculatrice[8];
		
		//Alors les char => 0-9 c'est 48-57
		
		add(new monBoutonCalculatrice("+", this));
		add(new monBoutonCalculatrice("-", this));
		add(new monBoutonCalculatrice("/", this));
		add(new monBoutonCalculatrice("*", this));
		add(new monBoutonCalculatrice("=", this));
		txtChiffre = new JTextArea();
		txtChiffre.setPreferredSize(new Dimension(100,20));
		add(txtChiffre);
		
		for (int i = 0; i < tabBouton.length; i++) 
		{
			tabBouton[i]= new monBoutonCalculatrice (Integer.toString(i), this);
			tabBouton[i].setBackground(Color.PINK);
			add(tabBouton[i]);
			
			
		}
		
	}
	
	public void doOper(Symbole s) {
		if(s instanceof Number) {
			chiffre = chiffre*10 +((Number)s).getValeur();
			txtChiffre.setText(Double.toString(chiffre));
		}
		else {
			if(s instanceof OperEgal) {
				chiffre2=os.doOper(chiffre2, chiffre);
				txtChiffre.setText(Double.toString(chiffre2));
			}
			else {
				os=(Operation)s;
				chiffre2=chiffre;
			}
			chiffre = 0;
		}
	}
	
	public void setChiffre1 (int chiffre)
	{
//		txtChiffre.setText(txtChiffre.getText() + chiffre);
		System.out.println(chiffre);
	}
}
