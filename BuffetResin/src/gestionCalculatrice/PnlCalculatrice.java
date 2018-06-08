package gestionCalculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import apparence.MaFenetre;
import apparence.MonLabel;
import apparence.PnlCentre;


@SuppressWarnings("serial")
public class PnlCalculatrice extends PnlCentre {
	
	MaFenetre maman;
	monBoutonCalculatrice [] tabBouton;
	MonLabel lblCalcul;
	double chiffre,chiffre2;
	OperationStrategy os;
//	private JPanel contenu = new JPanel();
	
	public PnlCalculatrice(MaFenetre maman) 
	{
		super("Calculatrice");
		this.maman = maman;
		lblCalcul = new MonLabel();
//		Font police = new Font("Arial", Font.BOLD, 200);
		tabBouton =  new monBoutonCalculatrice[10];
		//Alors les char => 0-9 c'est 48-57
		lblCalcul.setText("salut");
		lblCalcul.setForeground(Color.BLACK);
		lblCalcul.setPreferredSize(new Dimension(200, 100));
	    
	    JPanel panEcran = new JPanel();
	    panEcran.setPreferredSize(new Dimension(320, 225));

	    /*
	     * 
	     * les chiffres
	     * 
	     */
	    
	    JPanel chiffre = new JPanel();
	    chiffre.setPreferredSize(new Dimension(240, 225));
		for (int i = 0; i < tabBouton.length; i++) 
		{
			
			if (i == 9) 
			{
				tabBouton[i]= new monBoutonCalculatrice (Integer.toString(i-9), this);
				tabBouton[i].setBackground(Color.PINK);
				chiffre.add(tabBouton[i]);
			}
			else
			{
				tabBouton[i]= new monBoutonCalculatrice (Integer.toString(i+1), this);
				tabBouton[i].setBackground(Color.PINK);
				chiffre.add(tabBouton[i]);
			}
		}
		
		/*
		 * 
		 * les opérations
		 * 
		 */
		
		JPanel operateur = new JPanel();      
	    operateur.setPreferredSize(new Dimension(160,280 ));
		operateur.add(new monBoutonCalculatrice("+", this));
	    operateur.add(new monBoutonCalculatrice("-", this));
	    operateur.add(new monBoutonCalculatrice("/", this));
	    operateur.add(new monBoutonCalculatrice("*", this));
	    operateur.add(new monBoutonCalculatrice("=", this));
//	    operateur.add(new monBoutonCalculatrice("C", this));
//	    operateur.add(new monBoutonCalculatrice("<=", this));
	    panEcran.setBackground(Color.CYAN);
	    
	    panEcran.add(lblCalcul);
	    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
	    this.add(panEcran, BorderLayout.NORTH);
	    this.add(chiffre, BorderLayout.WEST);
	    this.add(operateur, BorderLayout.EAST);
	}
	
	
	public void doOper(Symbole s) 
	{
		if(s instanceof Nombre) {
			chiffre = chiffre*10 +((Nombre)s).getValeur();
			lblCalcul.setText(Double.toString(chiffre));
		}
		else {
			if(s instanceof OperEgal) 
			{
				chiffre2=os.doOper(chiffre2, chiffre);
				lblCalcul.setText(Double.toString(chiffre2));
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
