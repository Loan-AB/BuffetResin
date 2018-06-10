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
	double chiffreStocker,chiffreStockerAfficher;
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
			chiffreStocker = chiffreStocker*10 +((Nombre)s).getValeur(); //*10 pour les dizaine , dentaine etc
			lblCalcul.setText(Double.toString(chiffreStocker));
		}
		else 
		{
			if(s instanceof OperEgal) 
			{
				chiffreStockerAfficher=os.doOper(chiffreStockerAfficher, chiffreStocker);
				lblCalcul.setText(Double.toString(chiffreStockerAfficher));
			}
			else if(s instanceof Sigle)
			{
				switch (((Sigle)s).getSigne()) 
				{//bon je suis perdue XD
					case ".":
						
						break;
					case "C":
						chiffreStocker=0;
						chiffreStockerAfficher=0;
						lblCalcul.setText("0");
						break;
					case "<=":
						
//						double aRetirer=0;
//						double multiplicateur=0.1;
//						while(aRetirer == 0) 
//						{
//							aRetirer = chiffreStocker % multiplicateur;
//							multiplicateur*=10;
//						}
//						chiffreStocker = (chiffreStocker-aRetirer)/(multiplicateur*10);
//						lblCalcul.setText(Double.toString(chiffreStocker));
						
						
						
						break;
					default:
						break;
				}
			}
			else
			{
				os=(Operation)s;
				chiffreStockerAfficher=chiffreStocker;
				chiffreStocker = 0;
				lblCalcul.setText(Double.toString(chiffreStocker));
			}
		}
	}
	public void setchiffreStocker1 (int chiffreStocker)
	{
		System.out.println(chiffreStocker);
	}
}   
