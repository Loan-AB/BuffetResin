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
		
		
		JLabel labelWallPaper = new JLabel(new ImageIcon("./src/photoDefault/wallpaper1.png"));
		JPanel panelWallPaper = new JPanel();
		add(panelWallPaper, BorderLayout.CENTER);
		panelWallPaper.add(labelWallPaper,BorderLayout.CENTER);
		
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
		pnlCentre.add(pnlAccueil, "Accueil");
		pnlCentre.add(pnlContact, "Contact");
		pnlCentre.add(pnlSecret, "Secret");
		pnlCentre.add(pnlGalerie,"Galerie");
		pnlCentre.add(pnlFormulaire, "Formulaire");
		pnlCentre.add(pnlImage, "Image");
		pnlCentre.add(pnlContactGalerie, "ChoixImage");
		
		couche.show(pnlCentre, "Accueil");
		historiqueLayout.add("Accueil");

		
		this.setUndecorated(true);//Enleve le cadre de la frame 
		//setBackground(Color.BLACK);
		//getRootPane().setBorder(new LineBorder(Color.BLACK, 20, false));
		getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 20, 20, Color.BLACK));
		
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
			public void actionPerformed(ActionEvent arg0) 
			{
					changeCouche(((MonBouton)arg0.getSource()).getText());
			}
		};
		
		ActionListener backAppli = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(historiqueLayout.size()>1) //on peut supprimer la dernière couche
				{ 
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

