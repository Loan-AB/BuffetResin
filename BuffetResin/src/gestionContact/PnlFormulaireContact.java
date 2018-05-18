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
import javax.swing.JTextArea;

import apparence.MonBouton;
import apparence.MonLabel;
import apparence.PnlCentre;
import gestionContact.*;

public class PnlFormulaireContact  extends PnlCentre { //pas sure

	//concernant les lbl globaux vraiment important ?
	
	MonBouton btnValider;
	MonBouton btnAnnuler;
	JTextArea txtNom;
	JTextArea txtPrenom;
	JTextArea txtNumeroTel;
	JTextArea txtNumeroMobile;
	JTextArea txtEmail;
	public PnlFormulaireContact(String nom) {
		super("Formulaire");
	
		
		//pour la photo je ne sais pas encore , => on ouvre la galerie et on dit que "ajouter 
		//au contact xx) ou on modifier le contact et pn ajoute
		//il fazdra par la suite faire en sorte que si on a pas rempli de photo , cela met la phot par defaut.
		//nom,  prenom,  numeroTel,  numeroMobile,  email,  photo
		
		
		btnAnnuler = new MonBouton("Annuler", true);
		btnValider = new MonBouton("Valider", true);
		txtNom = new JTextArea(1,20);
		txtNom.setText("nom");
	
		txtNom.addFocusListener(null);
		add(txtNom);
		
		add(btnAnnuler ); 
		add(btnValider);
		
//		txtNom.addFocusListener(new FocusListener() {
//		    public void focusGained(FocusEvent e) {
//		    	txtNom.setText("");
//		    }
//
//		    public void focusLost(FocusEvent e) {
//		    	txtNom.setText("First Name");
//		    }
//		});
		
	}



	
}

