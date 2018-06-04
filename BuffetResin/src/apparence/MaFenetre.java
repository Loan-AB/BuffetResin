package apparence;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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

import gestionContact.*;
import gestionGalerie.*;


@SuppressWarnings("serial")
public class MaFenetre extends JFrame {
	
	PnlBas pnlBas;
	PnlHaut pnlHaut;
	PnlCentre pnlCentre;
	PnlAccueil pnlAccueil;
	PnlContactGalerie pnlContactGalerie;
	CardLayout couche;
	PnlSecret pnlSecret;
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
		pnlSecret = new PnlSecret(this);
		pnlGalerie = new PnlGalerie(this);
		pnlImage = new PnlImage(this);
		pnlContactGalerie = new PnlContactGalerie(this);
		//pas sure
		pnlFormulaire = new PnlFormulaireContact(this);
		historiqueLayout = new ArrayList<>();
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
		pnlCentre.add(pnlContact, "Contact");
		pnlCentre.add(pnlSecret, "Secret");
		pnlCentre.add(pnlGalerie,"Galerie");
		pnlCentre.add(pnlFormulaire, "Formulaire");
		pnlCentre.add(pnlImage, "Image");
		pnlCentre.add(pnlContactGalerie, "ChoixImage");
		
		couche.show(pnlCentre, "Accueil");
		historiqueLayout.add("Accueil");

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

					changeCouche(((MonBouton)arg0.getSource()).getText());
			}
		};
		
		ActionListener backAppli = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(historiqueLayout.size()>1) { historiqueLayout.remove(historiqueLayout.size()-1); }
				couche.show(pnlCentre, historiqueLayout.get(historiqueLayout.size()-1));
			}
		};

		pnlBas.setListenerBtn(lancerAppli, backAppli);
		pnlAccueil.setListenerBtn(lancerAppli);
		setResizable(false); //fix la taille
		
		this.setVisible(true); //ça toujours a la fin
		
	}
	public void changeCouche(String nom) {
		if(!(historiqueLayout.get(historiqueLayout.size()-1).equals(nom))) {
			historiqueLayout.add( nom);
			couche.show(pnlCentre, nom);
		}
	}
	public void afficherContact(Contact contact) {
		pnlFormulaire.setContact(contact);
		changeCouche("Formulaire");
	}
	
	public void ajouterContact(Contact contact) {
		pnlContact.ajouterContact(contact);
	}
	public void supprimerContact(Contact contact) {
		pnlContact.supprimerContact(contact);
		
	}
	public void afficherImage(ImageIcon icon) {
		pnlImage.setImage(icon);
		changeCouche("Image");
	}
	public void setImageFormulaireNouveauContact(ImageIcon description) {
		pnlFormulaire.setImage(description);
		
	}

	
}

