package apparence;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MonLabel extends JLabel
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MonLabel() 
	{
		setForeground(Color.white);
		setFont(new Font("Arial", Font.BOLD,15));
	}
}
