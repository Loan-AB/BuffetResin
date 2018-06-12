package gestionContact;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.MonJtextArea;
import apparence.MonLabel;
import apparence.PnlCentre;
import gestionCalculatrice.MonBoutonCalculatrice;
import gestionContact.*;
import gestionGalerie.MonBoutonPhoto;
import gestionGalerie.MonImage;

public class PnlFormulaireContact  extends PnlCentre 
{ 
	private MonBouton btnAnnuler;
	private MonBouton btnSupprimer;
	private MonBouton btnChoixImage;
	private MonBouton btnModifier;
	
	private JTextArea txtNom;
	private JTextArea txtPrenom;
	private JTextArea txtNumeroTel;
	private JTextArea txtNumeroMobile;
	private JTextArea txtEmail;
	boolean bModifier;
	
	private MaFenetre maman;
	private Contact contact;
	private JLabel lblImage;
	private ImageIcon iiformulaire;
	
	private ImageIcon iiDefaut;
	private MonLabel lblTitre;
	
	private MonLabel lblMail;
	private MonLabel lblPrenom;
	private MonLabel lblNom;
	private MonLabel lblTelMobile;
	private MonLabel lblTelMaison;
	/**
 * @param maman
 */
	public PnlFormulaireContact(MaFenetre maman) 
	{
			super("Formulaire");
			this.maman = maman;
		
			creatioComposant();
			afficherComposant();
			creationEvenement();
			definirModification(false);
	}

	/**
	 * 
	 */
	private void creationEvenement() 
	{
		this.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentShown(ComponentEvent arg0) 
			{
				bModifier=true;
			}
			
			@Override
			public void componentHidden(ComponentEvent arg0) 
			{
				if(bModifier) 
				{
					dechargement();
					definirModification(false);
				}
			}
		});
		
		
		btnAnnuler.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				dechargement();
				maman.changeCouche("Contact");
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				contact.suppressioncontact();
				maman.supprimerContact(contact);
				maman.changeCouche("Contact");
			}
		});
		
		btnChoixImage.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				maman.setbContact(true);
				maman.changeCouche("Galerie");
				bModifier=false;
			}
		});
		
		txtNumeroMobile.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				// TODO Auto-generated method stub
				if(!(e.getKeyChar() < 58 && e.getKeyChar() > 47)) 
				{
					txtNumeroMobile.setText(txtNumeroMobile.getText().replaceAll(e.getKeyChar()+"", ""));
					//e.setKeyCode(KeyEvent.VK_BACK_SPACE);
				}				
			}
		});
		
		txtNumeroTel.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				// TODO Auto-generated method stub
				if(!(e.getKeyChar() < 58 && e.getKeyChar() > 47)) 
				{
					txtNumeroTel.setText(txtNumeroTel.getText().replaceAll(e.getKeyChar()+"", ""));
					//e.setKeyCode(KeyEvent.VK_BACK_SPACE);
				}				
			}
		});
		
		btnModifier.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(btnModifier.getText().equals("Modifier")) 
				{
					definirModification(true); //donc on affiche tout.
				}
				else 
				{
					boolean probleme = false;
					java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[\\p{L}\\p{N}\\._%+-]+@[\\p{L}\\p{N}\\.\\-]+\\.[\\p{L}]{2,}$"); //voir Regex
					if(!p.matcher(txtEmail.getText()).matches())//mail
					{
						probleme = true;
						lblMail.setForeground(Color.red);
					}
					else {
						lblMail.setForeground(Color.WHITE);
					}
					if(txtNom.getText().isEmpty())//nom  vide
					{
						probleme = true;
						lblNom.setForeground(Color.red);
					}
					else {
						lblNom.setForeground(Color.WHITE);					
					}
					if(txtPrenom.getText().isEmpty()) // prenom  vide
					{
						probleme = true;
						lblPrenom.setForeground(Color.red);
					}
					else {
						lblPrenom.setForeground(Color.WHITE);
					}
					if(!probleme) 
					{
						definirModification(false);
						
						
						if(contact == null) //si on crée un nouveau contact	
						{ 	
							
							nouveauContact();
						}
						else 
						{
							modifierContact();
							
						}
						
					}
				}
			}


		});
	}
	protected void modifierContact() {
		
		contact.setNom(txtNom.getText());
		contact.setPrenom(txtPrenom.getText());
		contact.setNumeroTel(txtNumeroTel.getText());
		contact.setNumeroMobile(txtNumeroMobile.getText());
		contact.setEmail(txtEmail.getText());
		contact.setPhotoDescription(iiformulaire.getDescription());
		MonImage m = new MonImage(); //instencier , pour ne pas avoir de static
		contact.setPhoto(m.transformationImage(iiformulaire.getDescription(), 120, 120));
		contact.setPhotoDescription(iiformulaire.getDescription());
		contact.enregistrer();
		maman.ajouterContact(contact);
		
	}

	protected void nouveauContact() {
		contact = new Contact(txtNom.getText(), txtPrenom.getText(), txtNumeroTel.getText(),
				txtNumeroMobile.getText(), txtEmail.getText(), iiformulaire.getDescription().toString(), iiformulaire);
		contact.enregistrer();
		maman.ajouterContact(contact);	
	}

	/**
	 * 
	 */
	private void afficherComposant() 
	{
		add(btnModifier);
		add(lblImage);
		lblNom = new MonLabel();
		lblNom.setText("Nom :\t ");
		lblNom.setPreferredSize(new Dimension(120, 20));
		txtNom.setPreferredSize(new Dimension(200, 20));
		add(lblNom);
		add(txtNom);
		
		lblPrenom = new MonLabel();
		lblPrenom.setText("Prénom :\t ");
		lblPrenom.setPreferredSize(new Dimension(120, 20));
		txtPrenom.setPreferredSize(new Dimension(200, 20));
		add(lblPrenom);
		add(txtPrenom);
		
		lblTelMaison = new MonLabel();
		lblTelMaison.setText("Tél. Fixe :\t ");
		lblTelMaison.setPreferredSize(new Dimension(120, 20));
		txtNumeroTel.setPreferredSize(new Dimension(200, 20));
		add(lblTelMaison);
		add(txtNumeroTel);
		
		lblTelMobile = new MonLabel();
		lblTelMobile.setText("Tél. Mobile :\t ");
		lblTelMobile.setPreferredSize(new Dimension(120, 20));
		txtNumeroMobile.setPreferredSize(new Dimension(200, 20));
		add(lblTelMobile);
		add(txtNumeroMobile);
		
		lblMail = new MonLabel();
		lblMail.setText("E-Mail :\t ");
		lblMail.setPreferredSize(new Dimension(120, 20));
		txtEmail.setPreferredSize(new Dimension(200, 20));
		add(lblMail);
		add(txtEmail);
		System.out.println("cc");
		add(btnAnnuler); 
		add(btnSupprimer);
		add(btnChoixImage);
		bModifier = true;
}
	/**
	 * 
	 */
	private void creatioComposant() 
	{
		btnAnnuler = new MonBouton("Annuler");
		btnSupprimer = new MonBouton("Suprimmer");
		btnChoixImage = new MonBouton("ChoixImage");
		txtNom = new MonJtextArea("Nom");
		txtPrenom = new MonJtextArea("Prenom");
		txtNumeroTel = new MonJtextArea("Telephonne");
		txtNumeroMobile = new MonJtextArea("Mobile");
		txtEmail = new MonJtextArea("Email");
		txtNom.addFocusListener(null);
		iiDefaut = new ImageIcon(".\\src\\photoDefault\\default.png");
		lblImage = new JLabel("",JLabel.CENTER);
		lblTitre = new MonLabel();
		lblTitre.setSize(new Dimension(100, 100));
		btnModifier = new MonBouton("Modifier");
		lblImage.setPreferredSize(new Dimension(480,200));
	
	}
	/**
	 * @param b
	 */
	public void definirModification(boolean b) 
	{
		txtEmail.setEditable(b);
		txtNom.setEditable(b);
		txtPrenom.setEditable(b);
		txtNumeroMobile.setEditable(b);
		txtNumeroTel.setEditable(b);
		btnSupprimer.setVisible(b);
		btnChoixImage.setVisible(b);
		if (b) 
		{
			btnModifier.setText("Valider");
			btnAnnuler.setText("Anuller");
		}
		else
		{
			btnModifier.setText("Modifier");
			btnAnnuler.setText("retour");
		}
	}
	/**
	 * 
	 */
	public void dechargement() 
	{
		contact = null;
		txtNom.setText("");
		txtPrenom.setText("");
		txtEmail.setText("");
		txtNumeroMobile.setText("");
		txtNumeroTel.setText("");
		maman.setbContact(false);
		setImage(iiDefaut); 
		
		//remise des txt en blanc
		lblNom.setForeground(Color.white);
		lblMail.setForeground(Color.white);
		lblPrenom.setForeground(Color.white);
	}
	/**
	 * @param contact
	 */
	public void setContact(Contact contact) 
	{
		//ajout des élément dans les txt.
		this.contact = contact;
		txtNom.setText(contact.getNom());	
		lblImage.setIcon(contact.getPhoto());
		txtEmail.setText(contact.getEmail());
		txtNumeroMobile.setText(contact.getNumeroMobile());
		txtNumeroTel.setText(contact.getNumeroTel());
		txtPrenom.setText(contact.getPrenom());
		
		/*
		 * Contrôle de l'image si elle existe toujours dans la galerie
		 * si ce n'est pas le cas on remplace l'image par celle par defaut
		 * et on modifie et enregistre le contact
		 * 
		 */
		if ( new ImageIcon (contact.getPhotoDescription()).getImageLoadStatus() != MediaTracker.COMPLETE)  //ça passe
		{	
			miseEnPlaceImageDefaut();
		}
		else
		{
			setImage(new ImageIcon (contact.getPhotoDescription()));	
		}
	}
	
	private void miseEnPlaceImageDefaut() 
	{
		//on indique la nouvelle image
		System.out.println("salut je suis vide");
		setImage(new ImageIcon (iiDefaut.getDescription()));
		
		//redefinition de la nouvelle image dans contact + sauvegarde
		MonImage m = new MonImage(); //instencier , pour ne pas avoir de static
		contact.setPhoto(m.transformationImage(iiDefaut.getDescription(), 120, 120));
		contact.setPhotoDescription(iiDefaut.getDescription());
		modifierContact(); //enregistre
		
	}

	/**
	 * @param laNouvelleimage
	 */
	public void setImage(ImageIcon laNouvelleimage) 
	{
		this.iiformulaire = laNouvelleimage;
		setlblImage(laNouvelleimage);//pour l'affichage
	}
	public ImageIcon getImage() 
	{
		return iiformulaire; //pour l'affichage
	}
	
	/**
	 * @param MaFutureIcone
	 */
	
	private void setlblImage (ImageIcon MaFutureIcone) //affichage du label avec la bonne image
	{
		MonImage m = new MonImage(); //instencier , pour ne pas avoir de static
		System.out.println(MaFutureIcone.getDescription() + " icone ?");
		
		lblImage.setIcon(m.transformationImage(MaFutureIcone.getDescription(), lblImage.getWidth()));
		if (lblImage.getIcon().getIconHeight() < 0) //si une icone a sa ahauteur negative c'est quelle n'est pas chargée correctement 
		{
			miseEnPlaceImageDefaut(); //recommance le processus de contrôle 
		}
		System.out.println(lblImage.getIcon().getIconHeight());
		
	}
}

