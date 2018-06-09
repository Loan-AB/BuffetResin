package gestionCalculatrice;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import apparence.MonBouton;



public class monBoutonCalculatrice extends MonBouton{

	Symbole s;
	PnlCalculatrice maman;
	
	public monBoutonCalculatrice(String value, PnlCalculatrice maman)
	{
	
		super(value);
		setPreferredSize(new Dimension(70, 50));
		try {
			s = new Nombre(Double.parseDouble(value));
		}
			catch (Exception e) {
				switch(value) {
				case "+":this.s = new OperAddition();break;
				case "-":this.s = new OperSoustraction();break;
				case "*":this.s = new OperMultiplication();break;
				case "/":this.s = new OperDivision();break;
				default:this.s=new OperEgal();
			}
		}

		this.maman = maman;
		
		this.addActionListener(new ActionListener() {
			
			@Override
				public void actionPerformed(ActionEvent arg0) 
			{
				maman.doOper(s);
				System.out.println(s);
			}
			
			});
	}
}