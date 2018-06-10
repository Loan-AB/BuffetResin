package apparence;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MonLabel extends JLabel
{	
	public MonLabel() 
	{
		setForeground(Color.white);
		setFont(new Font("Arial", Font.BOLD,15));
	}
}
