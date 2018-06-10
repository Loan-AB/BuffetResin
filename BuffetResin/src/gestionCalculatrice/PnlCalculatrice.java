package gestionCalculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.management.relation.RelationServiceNotRegisteredException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	//JLabel fondCalculatrice = new JLabel(new ImageIcon("./src/photoDefault/wallpaper2.png"));
	
	double chiffre,chiffre2;
	OperationStrategy os;
	
//	@Override
//	  protected void paintComponent(Graphics g) {
//
//	    super.paintComponent(g);
//	        g.drawImage(new ImageIcon("./src/photoDefault/wallpaper1.png").getImage(), 0, 0, null);
//	}
	
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
	   // lblCalcul.setOpaque(true);
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
	    //lblCalcul.setOpaque(true);
	    //add(fondCalculatrice);
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
			else if(s instanceof Sigle){
				switch (((Sigle)s).getSigne()) {
				case ".":
					
					break;
				case "C":
					chiffre=0;
					chiffre2=0;
					lblCalcul.setText("0");
					break;
				case "<=":
					double aRetirer=0;
					double multiplicateur=0.1;
					while(aRetirer == 0) {
						aRetirer = chiffre % multiplicateur;
						multiplicateur*=10;
					}
					chiffre = (chiffre-aRetirer)/(multiplicateur*10);
					lblCalcul.setText(Double.toString(chiffre));
					break;
				default:
					break;
				}
			}
			else{
	
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
