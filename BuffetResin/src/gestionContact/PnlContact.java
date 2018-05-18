package gestionContact;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import javax.swing.JList;
import javax.swing.JScrollPane;


import apparence.MonBouton;
import apparence.MonLabel;
import apparence.PnlCentre;
import gestionContact .*;

public class PnlContact  extends PnlCentre {

	MonLabel lblTitre;
	MonBouton btnModifier;
	MonBouton btnCreer;
	JList<Contact> lstContact;
	Contact[] tabContact;
	
	
	 ArrayList<Contact> lContact; //il n'aime pas les static on pourra le passer en paramètre je pense
	
	
	public PnlContact(String nom) {
		
		super(nom);
		// Contact -- Modifier -- Créer
		
		btnModifier = new MonBouton("Modifier", true);
		btnCreer = new MonBouton("Créer", true);
		lblTitre = new MonLabel();
		lblTitre.setText("Contact");
		
		
		lContact = new ArrayList<Contact>();
		
//		creeContact(); on en a déja quelque'un
		System.out.println("listercontact");
		lireToutLesContact();
		
		add(lblTitre);
		add(btnCreer);
		add(btnModifier);
		
		
		//Affichage de la Jlist avec les images
		DefaultListModel<Contact> lm = new DefaultListModel<Contact>();

		for (Contact contact : lContact) {
			lm.addElement(contact);
		}
			
		//les élément de la liste
		lstContact = new JList<>(lm);
		lstContact.setCellRenderer(new ContactCellRenderer());
		lstContact.setModel(lm);

		lstContact.setSelectedIndex(0); //pour ne pas avoir d'erreur de ne pas avoir selectionner
		JScrollPane scrollPane= new JScrollPane(lstContact); 
		scrollPane.setPreferredSize(new Dimension(460,600));
		add(scrollPane);

	}
	
	private void lireToutLesContact() {

		File chemin = new File("C:\\Users\\loanb\\Downloads\\ImageContact\\"); 
		listerRepertoire(chemin);
		
//		deSerializeObject();//lecture des fichiers serialiser
		
	}

	private void creeContact(String nom , String prenom , String numeroTel ,String numeroMobile ,String email ,ImageIcon photo ) 
	{
		System.out.println("le formulaire");
		System.out.println("validation si tout champ pleinn et contact existe pas deja=> puis création");
		String nomFichier = nom+prenom;
		serializeObject( nomFichier,  nom,  prenom,  numeroTel,  numeroMobile,  email,  photo); //écrire
	}
	
	/*
	 * La methode listerRepertoire 
	 * 
	 * but : cette methode sert a lister tout les fichiers et les désérialize
	 * 
	 * Entrée : le chemin du repertoire ou contien les fichier
	 * Sortie : aucune
	 */
	public void listerRepertoire(File repertoire){

		String [] listefichiers;

		int i;
		listefichiers=repertoire.list();
		for(i=0;i<listefichiers.length;i++)
			{
				if(listefichiers[i].endsWith(".txt")) // == true
					{
					System.out.println(listefichiers[i].toString());
					deSerializeObject(listefichiers[i].toString());
						
					}
			}
		}
	
	/*
	 * Les methodes suivante servent a la création et la lecture des fichiers
	 * 
	 */
	
	public  void serializeObject(String nomFichier, String nom, String prenom, String numeroTel, String numeroMobile, String email, ImageIcon photo) {
		Contact cs = new Contact(nom,prenom,numeroTel,numeroMobile,email,photo);

		try {
			FileOutputStream fichier = new FileOutputStream("C:\\Users\\loanb\\Downloads\\ImageContact\\"+nomFichier+".txt");
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(cs);
			oos.flush();
			oos.close();
		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public  void deSerializeObject(String nomFichier) { 
		
		try {
			FileInputStream fichier = new FileInputStream("C:\\Users\\loanb\\Downloads\\ImageContact\\"+nomFichier);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			Contact cs = (Contact) ois.readObject();
			
			lContact.add(cs);

		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
