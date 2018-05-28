package apparence;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import gestionContact.Contact;
import gestionContact.PnlContact;
import gestionContact.PnlFormulaireContact;
import gestionGalerie.PnlGalerie;
import gestionGalerie.*;


@SuppressWarnings("serial")
public class MaFenetre extends JFrame {
	
	PnlBas pnlBas;
	PnlHaut pnlHaut;
	PnlCentre pnlCentre;
	PnlAccueil pnlAccueil;
	CardLayout couche;
	PnlSecret pnlSecret;
//	PnlContact pnlContact;
	PnlGalerie pnlGalerie;
	PnlFormulaireContact pnlFormulaire;
	

	public MaFenetre()
	{
		pnlBas = new PnlBas();
		pnlCentre = new PnlCentre("coucou");
		pnlHaut = new PnlHaut();
		couche = new CardLayout();
		pnlAccueil = new PnlAccueil(this);
//		pnlContact = new PnlContact(this);
		pnlSecret = new PnlSecret(this);
		pnlGalerie = new PnlGalerie(this);
		//pas sure
		pnlFormulaire = new PnlFormulaireContact(this);
		
		//pour que la fenetre soit au centre
		this.setLocationRelativeTo(null);
		
		//this.setLocation(5, 10); on peux choisir
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //car la prorpiétl et statique cêst pour ça que on a accès
		
		//setLayout(new Box(defaultCloseOperation));
		this.setSize(480, 800);
		pnlBas.setLayout(new FlowLayout());
		pnlCentre.setLayout(new GridLayout());
		pnlHaut.setLayout(new FlowLayout());
		
		add(pnlHaut,BorderLayout.NORTH);
		add(pnlCentre);
		add(pnlBas, BorderLayout.SOUTH);
		
		pnlCentre.setLayout(couche);
		pnlCentre.add(pnlAccueil, "Accueil");
//		pnlCentre.add(pnlContact, "Contact");
		pnlCentre.add(pnlSecret, "Secret");
		pnlCentre.add(pnlGalerie,"Galerie");
		pnlCentre.add(pnlFormulaire, "Formulaire");
		
		couche.show(pnlCentre, "Acceuil");

		//ajout dans la fenetre  , les panels
		/*
		ActionListener lancerGalerie = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//couche.show(pnlCentre, "Accueil");
			}
		};
		pnlAccueil.setListenerBtn(lancerContact, lancerSecret, lancerGalerie);
		*/
		ActionListener lancerAppli = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				couche.show(pnlCentre, ((MonBouton)arg0.getSource()).getText());
			}
		};
		
		pnlAccueil.setListenerBtn(lancerAppli);
		pnlBas.setListenerBtn(lancerAppli);
		
		setResizable(false); //fix la taille
		
		this.setVisible(true); //ça toujours a la fin
		
	}
	public void changeCouche(String nom) {
		couche.show(pnlCentre, nom);
	}
	public void afficherContact(Contact contact) {
		pnlFormulaire.setContact(contact);
		couche.show(pnlCentre, "Formulaire");
	}
	
	public void ajouterContact(Contact contact) {
//		pnlContact.ajouterContact(contact);
	}

	
}

