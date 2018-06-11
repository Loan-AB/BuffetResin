package gestionGalerie;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.MonLabel;
import apparence.PnlCentre;
import javafx.stage.FileChooser;



/**
 * Panel de la galerie photo
 * 
 *
 */
public class PnlGalerie extends PnlCentre 
{
	protected MaFenetre maman;
	protected MesImages mesImages = new MesImages();
	protected JPanel pnlPhoto = new JPanel();
	protected JScrollPane scrollPane = new JScrollPane(pnlPhoto);
	protected MonBoutonPhoto []bouttonPhoto= new MonBoutonPhoto[mesImages.Size()];
	//protected ImageIcon monImage; ???
	protected WrapLayout wrapLayout = new WrapLayout();
	protected MonBouton bouttonAjouter = new MonBouton("ajouter");
	protected JFileChooser fileChooser;
	protected JLabel lblTitre = new JLabel();
	
	protected JTextField sourceFileTextField;
	protected JTextField destinationFileTextField;
    
	protected FileFilter imagesFilter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png"); //Filtre que les images
    
    
    
	/**
	 * @author Julien
	 * @param maman
	 */
	/**
	 * @param maman
	 */
	public PnlGalerie(MaFenetre maman) 
	{
		super("Galerie");
		this.maman = maman;	
		lblTitre = new MonLabel();
		lblTitre.setText("Gallerie");
		add(lblTitre);
		add(scrollPane,BorderLayout.CENTER);
		
		pnlPhoto.setBackground(Color.LIGHT_GRAY);
		
		pnlPhoto.setLayout(new WrapLayout(4));
		scrollPane.getVerticalScrollBar().setUnitIncrement(20); //Permet de choisir la vitesse de la scrollbar Verticale
		
		scrollPane.setPreferredSize(new Dimension(450,580));
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));//Determine la taille de la scrollBar vetical
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setBorder(new LineBorder(Color.BLACK,1,false));// Bordure avec ligne noire , "false" car bordure non arrondi
		
		//Création du tableau de boutons avec des images
		for(int i=0;i<mesImages.Size();i++) 
			{
			//monImage = mesImages.recupererImage(i);???
			int p = i;
			bouttonPhoto[i] = new MonBoutonPhoto(new MonImage(i));
			pnlPhoto.add(bouttonPhoto[i]);
			bouttonPhoto[i].addMouseListener(new MouseAdapter()
			 {
				public void mouseClicked(MouseEvent e)
				{
					ImageIcon ii = ((MonBoutonPhoto)(e.getSource())).getImageIcon();
					MonImage m = new MonImage(); //instencier , pour ne pas avoir de static
					maman.afficherImage(m.transformationImage(ii.getDescription(),scrollPane.getWidth()),ii.getDescription(),p);//loan 08.06.2018
					
				}
			 });
			}
		
		add(bouttonAjouter);
		//Action du bouton ajouter une photo
		bouttonAjouter.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fileChooser = new JFileChooser();//Permet d'ajouter une image dans la gallerie en ouvrant une fenêtre de choix de fichier
				
				fileChooser.setCurrentDirectory(new File  
						(System.getProperty("user.home") + System.getProperty("file.separator")+ "Pictures"));
				fileChooser.addChoosableFileFilter(imagesFilter);	// Ajouter un choix du Filtre 
				fileChooser.setAcceptAllFileFilterUsed(false);		// N'Accepte pas tout les types de fichier
				
				fileChooser.setDialogTitle("Specify a file to save");   
				int userSelection = fileChooser.showSaveDialog(new JFrame());
				if (userSelection == JFileChooser.APPROVE_OPTION) 
				{
				    File fileToSave = fileChooser.getSelectedFile();
				    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				    try
				    {
				    	//Donne le lien pour enregistrer le fichier voulu
						Files.copy(fileToSave.toPath(),new File("./src/photoGallerie/" + fileToSave.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
					} 
				    catch (IOException e1)
				    
				    {
						e1.printStackTrace();
					}
				    MonBoutonPhoto btnP = new MonBoutonPhoto(new MonImage("./src/photoGallerie/" + fileToSave.getName()));
				    
				    pnlPhoto.add(btnP);
				    int numeroImage = bouttonPhoto.length;
					MonBoutonPhoto[] temp = new MonBoutonPhoto[bouttonPhoto.length+1];
					for(int i =0;i<bouttonPhoto.length;i++) { temp[i] = bouttonPhoto[i];}
					temp[bouttonPhoto.length] = btnP;
					bouttonPhoto = temp;
					btnP.addMouseListener(new MouseAdapter()
						{
							public void mouseClicked(MouseEvent e) 
							{
								ImageIcon ii = ((MonBoutonPhoto)(e.getSource())).getImageIcon();
								System.err.println(numeroImage);
								MonImage m = new MonImage(); //instencier , pour ne pas avoir de static
								maman.afficherImage(m.transformationImage(ii.getDescription(),scrollPane.getWidth()),ii.getDescription(),numeroImage);//loan 08.06.2018
								
							}
						});

					maman.changeCouche("Accueil");
					maman.changeCouche("Galerie");
					
				}
			}
		});		
	}
	/**
	 * @param numImage
	 */
	public void supprimerImage(int numImage) 
	{
		System.out.println(numImage);
		pnlPhoto.remove(bouttonPhoto[numImage]);
	}
}