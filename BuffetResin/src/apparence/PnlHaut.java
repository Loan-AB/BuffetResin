package apparence;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PnlHaut extends JPanel{
	private java.util.Date time;
	private MonLabel lblTime;
	private MaBatterie prbBatterie;
	private	DateFormat df;
	
	public PnlHaut() {
		setSize(480, 100);
		setBackground(Color.red);
		time  = new java.util.Date();
		df = new SimpleDateFormat("dd/MM/yyy HH:mm");
		//test pour les composant du haut
		lblTime = new MonLabel();
		prbBatterie = new MaBatterie();

		// le haut : 
		this.add(lblTime);
		this.add(prbBatterie);
		lblTime.setText(df.format(time)); //sera réglé par un timer ou prise du temps du pc
		
	}
	
	public void majDate() {
		lblTime.setText(df.format(time));
	}
	
	public void majBatterie() {
		//
	}
}
