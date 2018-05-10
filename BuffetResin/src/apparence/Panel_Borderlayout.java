package apparence;


import java.awt.BorderLayout;

import javax.swing.*;


public class Panel_Borderlayout extends JPanel{
	
	public Panel_Borderlayout()
	{
		
		
		
		this.setLayout(new BorderLayout());
		JLabel monlabel = new JLabel("salut");
		
		this.add(new MonBouton("test", true), BorderLayout.CENTER);
		this.add(monlabel,BorderLayout.NORTH);
	}
	
	

}
