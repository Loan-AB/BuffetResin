package apparence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;
import javax.swing.JTextArea;

public class MonJtextArea extends JTextArea {

	String textHolder;
	public MonJtextArea(String textHolder) {
		super(1,25);
		this.textHolder = textHolder;
		setForeground(Color.darkGray);
		setText(textHolder);
		this.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txt().equals("")) {
					setForeground(Color.darkGray);
					txt(textHolder);
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if(txt().equals(textHolder)) {
					setForeground(Color.black);
					txt("");
				}
			}
		});
		
	}
	
	private String txt() {
		return super.getText();
	}
	
	private void txt(String s) {
		super.setText(s);
	}
	
	public String getText() {

		if (super.getText().equals(textHolder) ) {
			return "";
		}
		else {
			return super.getText();
		}
	}
	
	public void setText(String donneeText) {
		setForeground(Color.BLACK);
		if(donneeText.equals("")) {
			setForeground(Color.darkGray);			
			super.setText(textHolder);
		}else {
			super.setText(donneeText);	
		}
		
		
	}

	
	
}
