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
public class PnlCalculatrice extends PnlCentre 
{
	MaFenetre maman;
	MonBoutonCalculatrice [] tabBouton;
	MonLabel lblCalcul;
	double chiffreStocker,chiffreAfficher;
	OperationStrategy os;
	Sigle sig;
	JPanel panEcran;
	JPanel chiffreStockers;
	JPanel operateur;
	double sens;
	
	/**
	 * constructeur du pnlCalculatrice
	 * @param maman
	 */
	public PnlCalculatrice(MaFenetre maman) 
	{
		super("Calculatrice");
		this.maman = maman;
		sens = 10;
		configurerLabel();
		creationPanels();
		ajoutContenu();
		
		//ajout des composant
	    this.add(panEcran, BorderLayout.NORTH);
	    this.add(chiffreStockers, BorderLayout.CENTER);
	    this.add(operateur, BorderLayout.EAST);
	}
	/**ajoutContenu
	 * permet l'ajout du contenu des panels 
	 * @author loanb
	 */
	private void ajoutContenu() 
	{ 
		tabBouton =  new MonBoutonCalculatrice[9];
		for (int i = 0; i < tabBouton.length; i++) 
		{
				tabBouton[i]= new MonBoutonCalculatrice (Integer.toString(i+1), this);
				chiffreStockers.add(tabBouton[i]);
			
		}
//		chiffreStockers.add(new MonBoutonCalculatrice(".", this));
		chiffreStockers.add(new MonBoutonCalculatrice("0",this));
		
		operateur.setOpaque(false);
	
		operateur.add(new MonBoutonCalculatrice("+", this));
	    operateur.add(new MonBoutonCalculatrice("-", this));
	    operateur.add(new MonBoutonCalculatrice("/", this));
	    operateur.add(new MonBoutonCalculatrice("*", this));
	    operateur.add(new MonBoutonCalculatrice("C", this));
	    operateur.add(new MonBoutonCalculatrice("<=", this));
		operateur.add(new MonBoutonCalculatrice("=", this));
	    
	    panEcran.add(lblCalcul);
	    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	/**creationPanels
	 * creation des panels qui contiendra les élémewnt de la caluclatrice 
	 * afin d'avoir un meilleure design
	 * @author loanb
	 */
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
	
	/**
	 * configurerLabel
	 * configuration du label ou tout sera visible pour l'utilisateur
	 * @author loanb
	 */
	private void configurerLabel() {

		lblCalcul = new MonLabel();
		lblCalcul.setText("0");
		lblCalcul.setFont( new Font("Arial", Font.BOLD, 50));
		lblCalcul.setForeground(Color.BLACK);
		lblCalcul.setBackground(Color.white);
		lblCalcul.setOpaque(true);
		lblCalcul.setPreferredSize(new Dimension(380, 75));
		lblCalcul.setHorizontalAlignment(JLabel.RIGHT);
	}
	
	/**
	 * doOper
	 * definir l'action par rapport au bouton selectionner 
	 * @param s
	 * @author loanb
	 */
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
//				lblCalcul.setText(Double.toString(chiffreAfficher));
			}
			else if(s instanceof Sigle)
			{
				switch (((Sigle)s).getSigne()) 
				{
					case "C":
						chiffreStocker = chiffreAfficher =  SigEffacer.effacer(chiffreStocker,chiffreAfficher);
//						lblCalcul.setText(Double.toString(chiffreAfficher));
						break;
					case "<=": //ne fonctionne pour une raison inconnue
						//alors j'écrit ici ce qui est écrit dans SigRetour.retour(xxx)
//						SigRetour.retour(lblCalcul.toString());
						
		
//						chiffreAfficher = Double.parseDouble(SigRetour.retour(lblCalcul.toString()));
						
						if (lblCalcul.getText().length() > 3) //donc si ce n'est pas vide
						{
						StringBuilder strB = new StringBuilder(lblCalcul.getText());
						strB.deleteCharAt(lblCalcul.getText().length()-3);
						lblCalcul.setText(strB.toString());
						chiffreAfficher = Double.parseDouble(strB.toString()); 
						}
						else
						{
							
							lblCalcul.setText("0.0");
							chiffreAfficher = 0.0; 
							//ben c'est plu petit quoi donc le chiffre passe a zero
						}
						// le code pour le bouton retour a etait pris sur le site :
						// https://www.youtube.com/watch?v=Ym9_qF4iGHg
						// pour la solution est l'explication du code
						break;
				}
			}
			else
			{
				os=(Operation)s;
				chiffreStocker = Double.parseDouble(lblCalcul.getText());
				chiffreAfficher = 0;
//				lblCalcul.setText(Double.toString(chiffreAfficher));
			}
			lblCalcul.setText(Double.toString(chiffreAfficher));
		}
	}
	/**
	 * 
	 * @param chiffreStocker
	 * @author loanb
	 */
	public void setchiffreStocker (int chiffreStocker)
	{
		System.out.println(chiffreStocker);
		this.chiffreStocker = chiffreStocker;
	}
}   
