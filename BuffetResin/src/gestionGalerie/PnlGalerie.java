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

public class PnlGalerie extends PnlCentre {
	protected MaFenetre maman;
	protected MesImages mesImages = new MesImages();
	protected JPanel panelPhoto = new JPanel();
	protected JScrollPane scrollPane = new JScrollPane(panelPhoto);
	protected BouttonPhoto []bouttonPhoto= new BouttonPhoto[mesImages.Size()];
	protected ImageIcon monImage;
	protected WrapLayout wrapLayout = new WrapLayout();
	MonBouton bouttoAjoute = new MonBouton("ajouter");
	JFileChooser fileChooser;
	JLabel lblTitre = new JLabel();
	private FileFilter imagesFilter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
	JTextField sourceFileTextField;
    JTextField destinationFileTextField;
	public PnlGalerie(MaFenetre maman) {
		super("Galerie");
		this.maman = maman;	
		lblTitre = new MonLabel();
		lblTitre.setText("Gallerie");
		add(lblTitre);
		add(scrollPane,BorderLayout.CENTER);
		
		//panelPhoto.setBackground(Color.LIGHT_GRAY);
		panelPhoto.setBackground(new Color(0.0f, 0.0f, 0.0f,0.0f));
		panelPhoto.setLayout(new WrapLayout(4));
		scrollPane.getVerticalScrollBar().setUnitIncrement(50); //choisir vizesse
		scrollPane.setBackground(new Color(0.0f, 0.0f, 0.0f,0.0f));
		scrollPane.setPreferredSize(new Dimension(460,580));
		//scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));//Determine la taille de la scrollBar vetical
		
		scrollPane.setBorder(new LineBorder(Color.BLACK,1,false));
		for(int i=0;i<mesImages.Size();i++) {
			monImage = mesImages.recupererImage(i);
			int p = i;
			bouttonPhoto[i] = new BouttonPhoto(new MonImage(i));
			panelPhoto.add(bouttonPhoto[i]);
			bouttonPhoto[i].addMouseListener(new MouseAdapter()
			 {
				public void mouseClicked(MouseEvent e) {
					ImageIcon ii = ((BouttonPhoto)(e.getSource())).getImageIcon();
					maman.afficherImage(MonImage.transformationImage(ii.getDescription(),scrollPane.getWidth()),ii.getDescription(),p);//loan 08.06.2018
					
				}
			});
		}
		add(bouttoAjoute);
		bouttoAjoute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("C:\\Users\\loanb\\Pictures");
				fileChooser.setDialogTitle("Specify a file to save");   
				int userSelection = fileChooser.showSaveDialog(new JFrame());
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
				    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				    try {
						Files.copy(fileToSave.toPath(),new File("./src/photoGallerie/" + fileToSave.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				    BouttonPhoto btnP = new BouttonPhoto(new MonImage("./src/photoGallerie/" + fileToSave.getName()));
				    
				    panelPhoto.add(btnP);
				    int numeroImage = bouttonPhoto.length;
					BouttonPhoto[] temp = new BouttonPhoto[bouttonPhoto.length+1];
					for(int i =0;i<bouttonPhoto.length;i++) { temp[i] = bouttonPhoto[i];}
					temp[bouttonPhoto.length] = btnP;
					bouttonPhoto = temp;
					btnP.addMouseListener(new MouseAdapter()
					 {
						public void mouseClicked(MouseEvent e) {
							ImageIcon ii = ((BouttonPhoto)(e.getSource())).getImageIcon();
							System.err.println(numeroImage);
							maman.afficherImage(MonImage.transformationImage(ii.getDescription(),scrollPane.getWidth()),ii.getDescription(),numeroImage);//loan 08.06.2018
							
						}
					});

					maman.changeCouche("Accueil");
					maman.changeCouche("Galerie");
					
				}
			}
		});		
	}
	public void supprimerImage(int numImage) {
		System.out.println(numImage);
		panelPhoto.remove(bouttonPhoto[numImage]);
	}
}