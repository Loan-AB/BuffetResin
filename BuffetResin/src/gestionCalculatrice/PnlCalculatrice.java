package gestionCalculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
		tabBouton =  new monBoutonCalculatrice[8];
		//Alors les char => 0-9 c'est 48-57
		lblCalcul.setText("salut");
		lblCalcul.setText("");
		lblCalcul.setHorizontalAlignment(JLabel.RIGHT);
		lblCalcul.setPreferredSize(new Dimension(480, 100));
	    
	    JPanel panEcran = new JPanel();
	    panEcran.setPreferredSize(new Dimension(480, 200));

	    JPanel chiffre = new JPanel();
//	    chiffre.setPreferredSize(new Dimension(165, 225));
		for (int i = 0; i < tabBouton.length; i++) 
		{
			tabBouton[i]= new monBoutonCalculatrice (Integer.toString(i), this);
			tabBouton[i].setBackground(Color.PINK);
			chiffre.add(tabBouton[i]);
		}
		JPanel operateur = new JPanel();      
	    operateur.setPreferredSize(new Dimension(55, 225));
		operateur.add(new monBoutonCalculatrice("+", this));
	    operateur.add(new monBoutonCalculatrice("-", this));
	    operateur.add(new monBoutonCalculatrice("/", this));
	    operateur.add(new monBoutonCalculatrice("*", this));
	    operateur.add(new monBoutonCalculatrice("=", this));
	    
	    panEcran.add(lblCalcul);
	    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
	    this.add(panEcran, BorderLayout.NORTH);
	    this.add(chiffre, BorderLayout.CENTER);
	    this.add(operateur, BorderLayout.EAST);

	   
		lblCalcul = new MonLabel();
		lblCalcul.setPreferredSize(new Dimension(100,20));
		add(lblCalcul);
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
