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

import apparence.BouttonApplication;
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
	protected WrapLayout wrapLayout = new WrapLayout(3);
	MonBouton bouttoAjoute = new MonBouton("ajouter",true);
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
		panelPhoto.setBackground(Color.BLUE);
		panelPhoto.setLayout(new WrapLayout(3));
		scrollPane.setPreferredSize(new Dimension(460,600));
		scrollPane.setBorder(new LineBorder(Color.BLACK,1,false));
		for(int i=0;i<mesImages.Size();i++) {
			monImage = mesImages.recupererImage(i);
			bouttonPhoto[i] = new BouttonPhoto(new MonImage(i));
			panelPhoto.add(bouttonPhoto[i]);
			bouttonPhoto[i].addMouseListener(new MouseAdapter()
			 {
				public void mouseClicked(MouseEvent e) {
					ImageIcon ii = ((BouttonPhoto)(e.getSource())).getImageIcon();
					maman.afficherImage(MonImage.transformationImage(ii.getDescription(),scrollPane.getWidth()));
				}
			});
		}
		add(bouttoAjoute);
	bouttoAjoute.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser("./src/photoGallerie");
			fileChooser.setDialogTitle("Specify a file to save");   
			int userSelection = fileChooser.showSaveDialog(new JFrame());
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    File fileToSave = fileChooser.getSelectedFile();
			    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
			}
		}
	});		
	}
}