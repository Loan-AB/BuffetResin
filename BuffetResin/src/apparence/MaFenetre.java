package apparence;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gestionCalculatrice.PnlCalculatrice;
import gestionContact.*;
import gestionGalerie.*;


@SuppressWarnings("serial")
public class MaFenetre extends JFrame {
	
	PnlBas pnlBas;
	PnlHaut pnlHaut;
	PnlCentre pnlCentre;
	PnlAccueil pnlAccueil;
	CardLayout couche;
	PnlCalculatrice pnlCalculatrice;
	PnlContact pnlContact;
	PnlGalerie pnlGalerie;
	PnlFormulaireContact pnlFormulaire;
	PnlImage pnlImage;
	ArrayList<String> historiqueLayout;
	
	

	public MaFenetre()
	
	{
		
		pnlBas = new PnlBas();
		pnlCentre = new PnlCentre("coucou");
		pnlHaut = new PnlHaut();
		couche = new CardLayout();
		pnlAccueil = new PnlAccueil(this);
		pnlContact = new PnlContact(this);
		pnlCalculatrice = new PnlCalculatrice(this);
		pnlGalerie = new PnlGalerie(this);
		pnlImage = new PnlImage(this);
		//pas sure
		pnlFormulaire = new PnlFormulaireContact(this);
		historiqueLayout = new ArrayList<>();
		
		
		
		
		//pour que la fenetre soit au centre
		
		
		//this.setLocation(0,0); //on peux choisir
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //car la prorpiétl et statique cêst pour ça que on a accès
		
		
		
		//setLayout(new Box(defaultCloseOperation));
		this.setSize(460, 760);
		pnlBas.setLayout(new FlowLayout());
		pnlCentre.setLayout(new GridLayout());
		pnlHaut.setLayout(new FlowLayout());
		
		add(pnlHaut,BorderLayout.NORTH);
		add(pnlCentre);
		add(pnlBas, BorderLayout.SOUTH);
		
		pnlCentre.setLayout(couche);
		pnlCentre.add(pnlAccueil,"Accueil");
		pnlCentre.add(pnlContact,"Contact");
		pnlCentre.add(pnlCalculatrice,"Calculatrice");
		pnlCentre.add(pnlGalerie,"Galerie");
		pnlCentre.add(pnlFormulaire,"Formulaire");
		pnlCentre.add(pnlImage,"Image");
		
		couche.show(pnlCentre, "Accueil");
//		couche.show(pnlCentre, "Calculatrice");
		
		historiqueLayout.add("Accueil");

		
		this.setUndecorated(true);//Enleve le cadre de la frame 
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		
		
//		getRootPane().setBorder(new LineBorder(Color.WHITE, 20, true)); //loan 08.06.2018
	
		ActionListener lancerAppli = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
					changeCouche(((MonBouton)arg0.getSource()).getActionCommand());
			}
		};
		
		ActionListener backAppli = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(historiqueLayout.size()>1) //on peut supprimer la dernière couche
				{ 
					if (historiqueLayout.get(historiqueLayout.size()-2).equals("Contact"))
					{
						pnlFormulaire.dechargement();
					}
					
					historiqueLayout.remove(historiqueLayout.size()-1); //on la supprime
				}
				couche.show(pnlCentre, historiqueLayout.get(historiqueLayout.size()-1)); //on affiche la dernière couche
			}
		};

		pnlBas.setListenerBtn(lancerAppli, backAppli);
		pnlAccueil.setListenerBtn(lancerAppli);
		//setResizable(false); //fix la taille
		
		this.setVisible(true); //ça toujours a la fin
		this.setLocationRelativeTo(null); //Doit etre à la fin pour être au centre de l'écran
		
	}
	public void changeCouche(String nom) {
		System.out.println(nom+ " a tenté de s'ouvrire");
		if(!(historiqueLayout.get(historiqueLayout.size()-1).equals(nom))) {
			historiqueLayout.add( nom);
			couche.show(pnlCentre, nom);
		}
	}
	public void afficherContact(Contact contact) {
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
	
	public void ajouterContact(Contact contact) 
	{
		pnlContact.ajouterContact(contact);
	}
	public void supprimerContact(Contact contact) 
	{
		pnlContact.supprimerContact(contact);
		
	}
	public void afficherImage(ImageIcon icon , String description) 
	{
		pnlImage.setImage(icon,description);
		changeCouche("Image");
	}
	public void setImageFormulaireNouveauContact(ImageIcon ii) 
	{
		pnlFormulaire.setImage(ii);
		
	}
	public void setbContact(boolean b) 
	{
		pnlImage.setbContactBouton(b);
	}

	
}

