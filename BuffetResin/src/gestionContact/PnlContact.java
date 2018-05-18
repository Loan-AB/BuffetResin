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
import exoCorr.City;
import exoCorr.Person;
import gestionContact.*;

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

	private void creeContact() 
	{
		System.out.println("le formulaire");
		System.out.println("validation si tout champ pleinn et contact existe pas deja=> puis création");
		//cération
		//Phase test des para : 
		String nom = "Beffet"  ; 
		String prenom = "prouti" ; 
		String numeroTel = "078 715 37 72";
		String numeroMobile = "01545 4545 454 78";
		String email= "fhdsuifhi@hjsdhfkj.com" ; 
		String nomFichier = nom+prenom ; 
		ImageIcon photo = new ImageIcon("C:\\Users\\loanb\\Downloads\\ImageContact\\chang.jpg");
		//fin
		serializeObject( nomFichier,  nom,  prenom,  numeroTel,  numeroMobile,  email,  photo); //écrire
	}
	
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
}
