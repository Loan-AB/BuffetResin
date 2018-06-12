package gestionCalculatrice;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import apparence.MonBouton;



public class MonBoutonCalculatrice extends MonBouton
{

	/**
	 * cette methode permet de crée les bouton correcte avec les évenement qui correspond a leur texte
	 * @author loanb
	 */
	private static final long serialVersionUID = 1L;
	Symbole s;
	PnlCalculatrice maman;

	public MonBoutonCalculatrice(String value, PnlCalculatrice maman)
	{
		super(value);
		setPreferredSize(new Dimension(70, 50));
		try {
			s = new Nombre(Double.parseDouble(value));
		}
			catch (Exception e) 
		{
			switch(value) 
			{
				case "+":this.s = new OperAddition();break;
				case "-":this.s = new OperSoustraction();break;
				case "*":this.s = new OperMultiplication();break;
				case "/":this.s = new OperDivision();break;
				case "C":this.s = new SigEffacer("C");break;
				case "<=":this.s = new SigRetour("<=");break;
//				case ".":this.s = new SigPoint(".");break;
				default:this.s=new OperEgal();
			}
		}
		this.maman = maman;
		
		this.addActionListener(new ActionListener() 
		{
			@Override
				public void actionPerformed(ActionEvent arg0) 
			{
				maman.doOper(s);
				System.out.println(s);
			}
			});
	}
}