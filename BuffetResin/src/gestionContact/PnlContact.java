package gestionContact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.FileInputStream;


import java.io.ObjectInputStream;

import java.util.ArrayList;


import javax.swing.DefaultListModel;

import javax.swing.JList;

import javax.swing.JScrollPane;


import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.MonLabel;
import apparence.PnlCentre;


public class PnlContact  extends PnlCentre 
{
	private static final long serialVersionUID = 1L;
	private MonLabel lblTitre;
	private MonBouton btnCreer;
	private JList<Contact> lstContact;
	private MaFenetre maman;
	private DefaultListModel<Contact> lm;
	private ArrayList<Contact> lContact;

	
	/**
	 * le constructeur du panel contact
	 * @param maman
	 * @author loanb
	 */
	public PnlContact(MaFenetre maman) 
	{
		super("Contact");
		this.maman = maman;
		creatioComposant();
		cretationDelaListe();
		add(btnCreer);
	}
	/**
	 * cretationDelaListe
	 * cette methode sert a crée tout la jliste qui contient tout les contact
	 * on y a joute même un evenement au clique.
	 * 
	 * @author loanb
	 */
	private void cretationDelaListe() 
	{
		//les éléments de la liste
				lstContact = new JList<>(lm);
				lstContact.setCellRenderer(new GraphiqueJlist());
				lstContact.setModel(lm);
				lstContact.setBackground(Color.LIGHT_GRAY);
				lstContact.setSelectedIndex(0); //pour ne pas avoir d'erreur de ne pas avoir selectionner
				JScrollPane scrollPane= new JScrollPane(lstContact); 
				scrollPane.setPreferredSize(new Dimension(450,580));
				
				scrollPane.setBackground(Color.WHITE);
				add(scrollPane,BorderLayout.CENTER);
				lstContact.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) {
						maman.afficherContact(lstContact.getSelectedValue());
					}
				});
		
	}
	/**
	 * creatioComposant
	 * on crée tout les composant utilsie pour le pnlContact
	 * @author loanb
	 */
	private void creatioComposant() 
	{
		btnCreer = new MonBouton("Créer un nouveau contact");
		lblTitre = new MonLabel();
		lblTitre.setText("Contact");
		lContact = new ArrayList<Contact>();
		System.out.println("Voici la liste des contacts au début du programme : ");
		lireToutLesContact();
		add(lblTitre);
		btnCreer.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				maman.afficherContact(null); //pour que l'image par defaut apparait 
				maman.definirModificationFormulaire(true);
				maman.changeCouche("Formulaire");
			}
		});
		//Affichage de la Jlist avec les images
		lm = new DefaultListModel<Contact>();
		for (Contact contact : lContact)
		{
			lm.addElement(contact);
		}
		
	}
	/*lireToutLesContact
	 * permet la lecture de tout les contact en mettant le chemin par defaut
	 * cette fonction appelle une autre fonctione pour lire tout les fichiers
	 * @author loanb
	 */
	private void lireToutLesContact() 
	{
		File chemin = new File(".\\src\\fichierContact\\"); 
		listerRepertoire(chemin);
	}
	
	/*
	 * La methode listerRepertoire 
	 * 
	 * cette methode sert a lister tout les fichiers et les désérialize
	 * 
	 * Entrée : @param repertoire
	 * Sortie : aucune
	 */

	public void listerRepertoire(File repertoire)
	{
		String [] listefichiers;
		int i;
		listefichiers=repertoire.list();
		for(i=0;i<listefichiers.length;i++)
			{
				if(listefichiers[i].endsWith(".txt")) // == true
				{
					System.out.println("fichier : " + listefichiers[i].toString());
					deSerializeObject(listefichiers[i].toString());
				}
			}
		}

	/**
	 * deSerializeObject
	 * permet la lecture d'un fichier et de crée cette objet dans le code
	 * @param nomFichier
	 * @author loanb
	 */
	public  void deSerializeObject(String nomFichier) 
	{ 
		try 
		{
			FileInputStream fichier = new FileInputStream(".\\src\\fichierContact\\"+nomFichier);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			Contact cs = (Contact) ois.readObject();
			lContact.add(cs);
			ois.close();
		}
		catch (java.io.IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * ajouterContact
	 * cette methode permet l'ajout du contact dans la jlist
	 * a a bonne place => ordre alphabetique
	 * @param contact
	 * @author loanb
	 */
	public void ajouterContact(Contact contact) 
	{
		if(!lm.contains(contact)) 
		{
			//pur l'ajout dans l'ordre alphabatique de manière automatique (lors de l'ajout)
			//je pense que c'est ici pour les trucs de la size de l'image
			int i=0;
			while(i<lm.size() && lm.elementAt(i).compareTo(contact) < 0) 
			{
				i++;
			}
			lm.add(i, contact);
			//qqch avec celler //loan help
			lstContact.setSelectedIndex(-1);
		}
	}
	/**
	 * supprimerContact
	 * cette methode permet de supprimer dans la jlist le contact que nous avons supprimer
	 * @param contact
	 * @author loanb
	 */
	public void supprimerContact(Contact contact) 
	{
		if(lm.contains(contact)) 
		{
			int i = 0 ;

		while(i<lm.size() && !lm.elementAt(i).equals(contact)) 
		{
			i++;
		}
		lm.remove(i);
		lstContact.setSelectedIndex(1);
		}
	}
}
