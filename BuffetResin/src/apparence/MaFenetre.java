package apparence;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import gestionCalculatrice.PnlCalculatrice;
import gestionContact.*;
import gestionGalerie.*;

/**
 * @author loanb
 * C'est la fenetre ou tout s'affiche
 * tout se contruit ici
 */
@SuppressWarnings("serial")
public class MaFenetre extends JFrame 
{

	private ArrayList<String> coucheAutorisee = new ArrayList<String>();
	private PnlBas pnlBas;
	private PnlHaut pnlHaut;
	private PnlCentre pnlCentre;
	private PnlAccueil pnlAccueil;
	private CardLayout couche;
	private PnlCalculatrice pnlCalculatrice;
	private PnlContact pnlContact;
	private PnlGalerie pnlGalerie;
	private PnlFormulaireContact pnlFormulaire;
	private PnlImage pnlImage;
	private ArrayList<String> historiqueLayout;
	
	/**
	 * 
	 */
	public MaFenetre()
	{
		creatioComposant();
		miseEnPlaceCouches();
		creationEvent();
		historiqueLayout.add("Accueil");

		this.setVisible(true); //ça toujours a la fin
		this.setLocationRelativeTo(null); //Doit etre à la fin pour être au centre de l'écran
	}
	
	/**
	 * 
	 */
	private void creationEvent() 
	{
		ActionListener lancerAppli = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
					changeCouche(((MonBouton)arg0.getSource()).getActionCommand());
			}
		};
		
		ActionListener backAppli = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(historiqueLayout.size()>1) //on peut supprimer la dernière couche
				{ 
					historiqueLayout.remove(historiqueLayout.size()-1); //on la supprime
				}
				couche.show(pnlCentre, historiqueLayout.get(historiqueLayout.size()-1)); //on affiche la dernière couche
			}
		};
		pnlBas.setListenerBtn(lancerAppli, backAppli);
		pnlAccueil.setListenerBtn(lancerAppli);
	}

	/**
	 * 
	 */
	private void miseEnPlaceCouches() 
	{
		add(pnlHaut,BorderLayout.NORTH);
		add(pnlCentre,BorderLayout.CENTER);
		add(pnlBas, BorderLayout.SOUTH);
		pnlCentre.setLayout(couche);
		pnlCentre.add(pnlAccueil,"Accueil");
		pnlCentre.add(pnlContact,"Contact");
		pnlCentre.add(pnlCalculatrice,"Calculatrice");
		pnlCentre.add(pnlGalerie,"Galerie");
		pnlCentre.add(pnlFormulaire,"Formulaire");
		pnlCentre.add(pnlImage,"Image");
		
		//indique quel couche a mettre lors du démarrage de l'appli
		couche.show(pnlCentre, "Accueil");
	}

	/**
	 * tout les composant nécessaire a l'affichage de la frame de base
	 * on crée tout les panels de notre smartphone
	 * et on gère l'historique grâve a un historiquelayout
	 * @author loanb
	 */
	private void creatioComposant() 
	{
		coucheAutorisee.add("Accueil");coucheAutorisee.add("Galerie");coucheAutorisee.add("Calculatrice");coucheAutorisee.add("Contact");
		
		pnlBas = new PnlBas();
		pnlCentre = new PnlCentre("coucou");
		pnlHaut = new PnlHaut();
		couche = new CardLayout();
		pnlAccueil = new PnlAccueil(this);
		pnlContact = new PnlContact(this);
		pnlCalculatrice = new PnlCalculatrice(this);
		pnlGalerie = new PnlGalerie(this);
		pnlImage = new PnlImage(this);
		
		pnlFormulaire = new PnlFormulaireContact(this);
		historiqueLayout = new ArrayList<>();
		
		//nos 3 panels de bases
		pnlBas.setLayout(new FlowLayout());
		pnlCentre.setLayout(new GridLayout());
		pnlHaut.setLayout(new FlowLayout());
		
		//Definition de la taille de la frae de base
		this.setSize(460, 760);
		this.setUndecorated(true);//Enleve le cadre de la frame 
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		getRootPane().setBorder(new LineBorder(Color.WHITE, 20, true)); //loan 08.06.2018
		
	}

	/**
	 * ChangeCouche(nom) 
	 * elle permet la gestion de l'historique, lors d'un changement de couche , on ajoute 
	 * celle-ci a l'historique si elle est une couche autorisée
	 * @author loanb
	 * @param nom
	 */
	
	public void changeCouche(String nom) 
	{
		System.out.println(nom+ " a tenté de s'ouvrir");
		if(!(historiqueLayout.get(historiqueLayout.size()-1).equals(nom))) //si pas 2 fois de suite la même couche
		{
			
			if(coucheAutorisee.contains(historiqueLayout.get(historiqueLayout.size()-1))) 
			{
				historiqueLayout.add(nom);
			}
			else 
			{
				historiqueLayout.set(historiqueLayout.size()-1, nom);
			}
			couche.show(pnlCentre, nom);
		}
	}
	
	/**
	 * afficherContact
	 * peremet le contrôle des contact , si le contact exist ou si c'est un nouveau contact que l'on crée
	 * si c'est un nouveau contact on décharge le pnlFormulaire des données inutiles.
	 * @param contact
	 * @author loanb
	 */
	public void afficherContact(Contact contact) 
	{
		if (contact != null) 
		{
			pnlFormulaire.setContact(contact);
		}
		else 
		{
			pnlFormulaire.dechargement();
		}
		changeCouche("Formulaire");
	}
	
	/**
	 * ajouterContact
	 * permet d'ajouter un nouveau contact et de l'enregistrer
	 * @param contact
	 * @author loanb
	 */
	public void ajouterContact(Contact contact) 
	{
		pnlContact.ajouterContact(contact);
	}
	
	/**
	 * supprimerContact 
	 * supprimer le fichier du contact que nous demandons
	 * @param contact
	 * @author loanb
	 */
	public void supprimerContact(Contact contact) 
	{
		pnlContact.supprimerContact(contact);
	}
	
	/**
	 * AfficherImage 
	 * Permet d'affecter la nouvelle image au contact et d'afficher la bonne image dans le formulaire
	 * @param icon
	 * @param description
	 * @param numImage
	 */
	public void afficherImage(ImageIcon icon , String description, int numImage) 
	{
		pnlImage.setImage(icon,description, numImage);
		changeCouche("Image");
	}
	
	/**
	 * SetImageFormulaireNouveauContact
	 * permet de definir la nouvelle image du contact crée
	 * @param ii
	 *  permet d'ajouter un nouveau contact et de l'enregistrer
	 */
	public void setImageFormulaireNouveauContact(ImageIcon ii) 
	{
		pnlFormulaire.setImage(ii);
	}
	
	/**
	 * setbContact
	 * permet le choix si on affiche ou non le bouton supprimer ou valider
	 * dans la gallerie
	 * @param b
	 *  permet d'ajouter un nouveau contact et de l'enregistrer
	 */
	public void setbContact(boolean b) 
	{
		pnlImage.setbContactBouton(b);
	}
	
	/**
	 * supprimerImage
	 * permet la supression de l'image dans la gallerie
	 * @param numImage
	 * @author loanb
	 */
	public void supprimerImage(int numImage) 
	{
		pnlGalerie.supprimerImage(numImage);
	}
	
	/**
	 * definirModificationFormulaire
	 * permet de definit si le formulaire et en mode modification
	 * ou en mode vision.
	 * suivant le boolean , le pnlFormulaire affiche ou non les bouton de la modifications
	 * @param b
	 * @author loanb
	 */

	public void definirModificationFormulaire(boolean b) {
		pnlFormulaire.definirModification(b);
		
	}

}

