package gestionGalerie;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.ShutdownChannelGroupException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import apparence.MaFenetre;
import apparence.PnlCentre;

public class RecuperationImage implements MouseListener {
	BouttonPhoto bouttonPhoto[];
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PhotoAgrandie photoAgrandie= new PhotoAgrandie(((JButton)e.getSource()).getIcon());

		System.out.println("salut");	
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}	
	
	
