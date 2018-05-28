package gestionGalerie;

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

public class RecuperationImage implements MouseListener {

	
	
	
	BouttonPhoto bouttonPhoto[];
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PhotoAgrandie frame= new PhotoAgrandie(((JButton)e.getSource()).getIcon());
		//JLabel label = new JLabel(bouttonPhoto[1].getIcon());
		//JLabel label = new JLabel();
		
		
		
		
		System.out.println("salut");
	
		
		
		
	
	
		
		
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}	
	
	
