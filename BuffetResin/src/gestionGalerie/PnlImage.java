package gestionGalerie;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URLConnection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

import apparence.MaFenetre;
import apparence.MonBouton;
import apparence.PnlCentre;

public class PnlImage extends PnlCentre implements ImageObserver {
	JLabel image;
	ImageIcon monImageIcon;
	MaFenetre maman;
	MonBouton btnDelete;
	MesImages imagesListe =  new MesImages();
	
	public PnlImage(MaFenetre mama) {
		super("Galerie");
		this.maman = maman;
		
		btnDelete = new MonBouton("Supprimer", true);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.err.println(monImageIcon.getDescription()); //contient l'url de l'image
			//	System.out.println(monImageIcon.getDescription());  
			
			
				
			
				
			
				
			
			
			
				
				
			
				
			
			
		
		 
		
			
			}
		});
		add(btnDelete,BorderLayout.NORTH);
		
		
		// TODO Auto-generated constructor stub
		image = new JLabel();
		add(image);		
	}
	public void setImage(ImageIcon photo) {
		monImageIcon = photo;
		image.setIcon(photo);
	}
	
//	private void delete(File file) {
//		
//		
//		
//		try{
//    		
//    		File fichier = file;
//    		
//    		
//        	
//    		if(fichier.delete()){
//    			System.out.println(fichier.getName() + " is deleted!");
//    		}else{
//    			System.out.println("Delete operation is failed.");
//    		}
//    	   
//    	}catch(Exception e){
//    		
//    		e.printStackTrace();
//    		
//    	}
//    }

}
