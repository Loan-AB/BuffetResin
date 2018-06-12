package apparence;


import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PnlAccueil extends PnlCentre 
{
	
	MonBouton btnContact;
	MonBouton btnGalerie;
	MonBouton btnCalculatrice;
	MaFenetre maman;
	/**
	 * ce panel sert de panel qui donne accès tout les application entre elle
	 * @author loanb
	 */
	
	public PnlAccueil(MaFenetre maman) 
	{
		super("Acceuil");
		this.maman= maman;

		btnContact = new MonBouton("Contact","./src/photoDefault/Contact1.png");
		btnGalerie = new MonBouton("Galerie","./src/photoDefault/Gallery.png");
		btnCalculatrice = new MonBouton("Calculatrice","./src/photoDefault/Calculator.png");	
		setOpaque(false);
		add(btnContact);
		add(btnGalerie);
		add(btnCalculatrice);
		
	}

	/**
	 * Cette methode sert a ajouter les listener au bouton voulu
	 * @param lancerContact
	 * @param lancerSecret
	 * @param lancerGalerie
	 * @author loanb
	 */
	public void setListenerBtn(ActionListener lancerContact, ActionListener lancerSecret,ActionListener lancerGalerie) 
	{
		btnContact.addActionListener(lancerContact);
		btnGalerie.addActionListener(lancerGalerie);
		btnCalculatrice.addActionListener(lancerSecret);
	}
	
	/**
	 * sert lors du lancement d'ajouter tout.
	 * @param lancerAppli
	 * @author loanb
	 */
	public void setListenerBtn(ActionListener lancerAppli) 
	{
		btnContact.addActionListener(lancerAppli);
		btnGalerie.addActionListener(lancerAppli);
		btnCalculatrice.addActionListener(lancerAppli);
	}
	
}
