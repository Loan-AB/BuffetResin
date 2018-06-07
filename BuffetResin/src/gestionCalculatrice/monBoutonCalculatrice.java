package gestionCalculatrice;

import java.awt.Color;
import java.awt.Cursor;
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
		try {
			s = new Number(Double.parseDouble(value));
		}
			catch (Exception e) {
				switch(value) {
				case "+":this.s = new OperAdd();break;
				case "-":this.s = new OperSub();break;
				case "*":this.s = new OperMul();break;
				case "/":this.s = new OperDiv();break;
				default:this.s=new OperEgal();
			}
		}

		this.maman = maman;
		setBackground(Color.PINK);
		
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