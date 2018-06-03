package gestionContact;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.MonLabel;
import apparence.PnlCentre;
import gestionContact .*;

public class PnlContact  extends PnlCentre {

	MonLabel lblTitre;
	MonBouton btnCreer;
	JList<Contact> lstContact;
	Contact[] tabContact;
	MaFenetre maman;
	DefaultListModel<Contact> lm;
	
	
	 ArrayList<Contact> lContact; //il n'aime pas les static on pourra le passer en paramètre je pense
	
	
	public PnlContact(MaFenetre maman) {
		
		super("Contact");
		this.maman = maman;

		btnCreer = new MonBouton("Créer un nouveau contact", true);
		lblTitre = new MonLabel();
		lblTitre.setText("Contact");
		
		lContact = new ArrayList<Contact>();
		
		System.out.println("listercontact");
		lireToutLesContact();
		
		add(lblTitre);
		
		
		btnCreer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maman.changeCouche("Formulaire");
			}
		});
		
		
		//Affichage de la Jlist avec les images
		lm = new DefaultListModel<Contact>();

		for (Contact contact : lContact) {
			lm.addElement(contact);
		}
			
		//les éléments de la liste
		lstContact = new JList<>(lm);
		lstContact.setCellRenderer(new ContactCellRenderer());
		lstContact.setModel(lm);

		lstContact.setSelectedIndex(0); //pour ne pas avoir d'erreur de ne pas avoir selectionner
		JScrollPane scrollPane= new JScrollPane(lstContact); 
		scrollPane.setPreferredSize(new Dimension(460,600));
		add(scrollPane);
		
		lstContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maman.afficherContact(lstContact.getSelectedValue());
			}
		});
		
		add(btnCreer);
	}
	
	private void lireToutLesContact() {

		File chemin = new File(".\\src\\fichierContact\\"); 
		listerRepertoire(chemin);
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
	public  void deSerializeObject(String nomFichier) { 
		try {
			FileInputStream fichier = new FileInputStream(".\\src\\fichierContact\\"+nomFichier);
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
	public void ajouterContact(Contact contact) 
	{
		if(!lm.contains(contact)) 
		{
			int i=0;
			while(i<lm.size() && lm.elementAt(i).compareTo(contact) < 0) {
				i++;
			}
			lm.add(i, contact);
			lstContact.setSelectedIndex(-1);
		}
	}
	
	
	public void supprimerContact(Contact contact) {
		if(lm.contains(contact)) 
		{
			int i = 0 ;

		while(i<lm.size() && !lm.elementAt(i).equals(contact)) {
			i++;
		}
		lm.remove(i);
		lstContact.setSelectedIndex(1);
		}
	}
}
