package apparence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;



import javax.swing.JPanel;
import javax.swing.border.LineBorder;



public class PnlHaut extends JPanel
{
	/**
	 * 
	 * Panel qui contient tout ce qui est dans le haut du smartphone
	 * il ne changera jamais
	 * @author loanb
	 */
	private static final long serialVersionUID = 1L;
	private java.util.Date time;
	private MonLabel lblTime;
	private	DateFormat df;
	MonBouton BtnFermer ;
	
	/**
	 * 
	 */
	public PnlHaut() 
	{
		setSize(480, 100);
		setBackground(Color.CYAN);
		BtnFermer= new MonBouton("Exit","./src/photoDefault/On.png",20);
		time  = new java.util.Date();
		df = new SimpleDateFormat("dd/MM/yyy HH:mm");
		//test pour les composant du haut
		lblTime = new MonLabel();
		setBorder(new LineBorder(Color.BLACK,1,false));
		// le haut : 
		this.add(lblTime);
		lblTime.setText(df.format(time));
		lblTime.setForeground(Color.BLACK);
		this.add(BtnFermer);
		
		/*
		 * 
		 * @author resin
		 */
		BtnFermer.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
			System.exit(0);
				
			}
		});
		this.setLayout(new BorderLayout());
	}
	
}
