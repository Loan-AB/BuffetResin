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
public class PnlCalculatrice extends PnlCentre 
{
	
	MaFenetre maman;
	MonBoutonCalculatrice [] tabBouton;
	MonLabel lblCalcul;
	double chiffreStocker = 0,chiffreAfficher= 0;
	OperationStrategy os;
	Sigle sig;
	JPanel panEcran;
	JPanel chiffreStockers;
	JPanel operateur;
	
	public PnlCalculatrice(MaFenetre maman) 
	{
		super("Calculatrice");
		this.maman = maman;
		
		configurerLabel();
		creationPanels();
		ajoutContenu();
		
		//ajout des composant
	    this.add(panEcran, BorderLayout.NORTH);
	    this.add(chiffreStockers, BorderLayout.CENTER);
	    this.add(operateur, BorderLayout.EAST);
	}
	private void ajoutContenu() 
	{ 
		tabBouton =  new MonBoutonCalculatrice[9];
		for (int i = 0; i < tabBouton.length; i++) 
		{
			System.out.println(tabBouton.length);
			System.out.println(i);
			
				tabBouton[i]= new MonBoutonCalculatrice (Integer.toString(i+1), this);
				chiffreStockers.add(tabBouton[i]);
			
		}
		chiffreStockers.add(new MonBoutonCalculatrice(".", this));
		chiffreStockers.add(new MonBoutonCalculatrice("0",this));
		chiffreStockers.add(new MonBoutonCalculatrice("=", this));
		
	    operateur.setOpaque(false);
		operateur.add(new MonBoutonCalculatrice("+", this));
	    operateur.add(new MonBoutonCalculatrice("-", this));
	    operateur.add(new MonBoutonCalculatrice("/", this));
	    operateur.add(new MonBoutonCalculatrice("*", this));
	    operateur.add(new MonBoutonCalculatrice("C", this));
	    operateur.add(new MonBoutonCalculatrice("<=", this));
	    
	    panEcran.add(lblCalcul);
	    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	private void creationPanels() 
	{
	    panEcran = new JPanel();
	    panEcran.setPreferredSize(new Dimension(390, 100));
	    
	    chiffreStockers = new JPanel();
	    chiffreStockers.setPreferredSize(new Dimension(240, 225));
	    chiffreStockers.setOpaque(false);
	    
	    operateur = new JPanel();      
	    operateur.setPreferredSize(new Dimension(150,225 ));
		
	}
	
	private void configurerLabel() {

		lblCalcul = new MonLabel();
		lblCalcul.setText("0");
		lblCalcul.setFont( new Font("Arial", Font.BOLD, 50));
		lblCalcul.setForeground(Color.BLACK);
		lblCalcul.setPreferredSize(new Dimension(380, 75));
		lblCalcul.setHorizontalAlignment(JLabel.RIGHT);
	}
	
	public void doOper(Symbole s) 
	{
		if(s instanceof Nombre) 
		{
			chiffreAfficher = chiffreAfficher*10 +((Nombre)s).getValeur(); //*10 pour les dizaine , dentaine etc
			lblCalcul.setText(Double.toString(chiffreAfficher));
		}
		else 
		{
			if(s instanceof OperEgal) 
			{
				chiffreAfficher=os.doOper(chiffreStocker, chiffreAfficher);
				lblCalcul.setText(Double.toString(chiffreAfficher));
			}
			else if(s instanceof Sigle)
			{
				switch (((Sigle)s).getSigne()) 
				{//bon je suis perdue XD
					case ".":
						//lorsque l'on clique dessus on ne doit plus faire *10
						//on doit écrire a droite du . 
						//un truc comme changement du sens `?
						 
						
						break;
					case "C":
						chiffreStocker=0;
						chiffreAfficher=0;
						lblCalcul.setText("0");
						break;
					case "<=": //questions :(
						
						if (lblCalcul.getText().length() > 0) //donc si ce n'est pas vide
						{
						StringBuilder strB = new StringBuilder(lblCalcul.getText());
						strB.deleteCharAt(lblCalcul.getText().length()-1);
						lblCalcul.setText(strB.toString());
						chiffreAfficher = Double.parseDouble(lblCalcul.getText()); 
						System.out.println(chiffreAfficher + "actu");
						System.out.println(chiffreStocker + "stock");
						}
						// merci https://www.youtube.com/watch?v=Ym9_qF4iGHg
						// pour la solution est l'explication du code
						break;
				}
			}
			else
			{
				os=(Operation)s;
				chiffreStocker = chiffreAfficher;
				chiffreAfficher = 0;
				lblCalcul.setText(Double.toString(chiffreAfficher));
			}
		}
	}
	public void setchiffreStocker1 (int chiffreStocker)
	{
		System.out.println(chiffreStocker);
	}
}   
