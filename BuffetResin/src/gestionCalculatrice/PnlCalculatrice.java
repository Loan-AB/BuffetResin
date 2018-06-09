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
	
	public PnlCalculatrice(MaFenetre maman) 
	{
		super("Calculatrice");
		this.maman = maman;
		lblCalcul = new MonLabel();
		tabBouton =  new monBoutonCalculatrice[9];
		lblCalcul.setText("0.0");
		lblCalcul.setFont( new Font("Arial", Font.BOLD, 50));
		lblCalcul.setForeground(Color.BLACK);
		lblCalcul.setPreferredSize(new Dimension(380, 75));
	    
	    JPanel panEcran = new JPanel();
	    panEcran.setPreferredSize(new Dimension(390, 100));

	    /*
	     * 
	     * les chiffres
	     * 
	     */
	    
	    JPanel chiffre = new JPanel();
	    chiffre.setPreferredSize(new Dimension(240, 225));
	    chiffre.setOpaque(false);
		for (int i = 0; i < tabBouton.length; i++) 
		{
			System.out.println(tabBouton.length);
			System.out.println(i);
			
				tabBouton[i]= new monBoutonCalculatrice (Integer.toString(i+1), this);
				chiffre.add(tabBouton[i]);
			
		}
		 chiffre.add(new monBoutonCalculatrice(".", this));
		 chiffre.add(new monBoutonCalculatrice("0",this));
		 chiffre.add(new monBoutonCalculatrice("=", this));
		
		/*
		 * 
		 * les opérations
		 * 
		 */
		
		JPanel operateur = new JPanel();      
	    operateur.setPreferredSize(new Dimension(150,225 ));
	    operateur.setOpaque(false);
		operateur.add(new monBoutonCalculatrice("+", this));
	    operateur.add(new monBoutonCalculatrice("-", this));
	    operateur.add(new monBoutonCalculatrice("/", this));
	    operateur.add(new monBoutonCalculatrice("*", this));
	    operateur.add(new monBoutonCalculatrice("C", this));
	    operateur.add(new monBoutonCalculatrice("<=", this));
	    
	    panEcran.add(lblCalcul);
	    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
	    this.add(panEcran, BorderLayout.NORTH);
	    this.add(chiffre, BorderLayout.CENTER);
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
				chiffre = 0;
				lblCalcul.setText(Double.toString(chiffre));
			}
		
		}
	}
	public void setChiffre1 (int chiffre)
	{
		System.out.println(chiffre);
	}
}

//class ResetListener implements ActionListener {
//    public void actionPerformed(ActionEvent arg0){
//      clicOperateur = false;
//      update = true;
//      chiffre1 = 0;
//      operateur = "";
//      ecran.setText("");
//    }
//  }      
