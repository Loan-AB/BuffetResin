package apparence;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PnlBackGround extends JPanel {
	
	JLabel labelWallPaper = new JLabel(new ImageIcon("./src/photoDefault/wallpaper1.png"));
	JPanel panelWallPaper = new JPanel();
	
	

	public PnlBackGround() {
		
		// TODO Auto-generated constructor stub
		
		add(panelWallPaper, BorderLayout.CENTER);
		panelWallPaper.add(labelWallPaper,BorderLayout.CENTER);
		setOpaque(false);
	}

}
