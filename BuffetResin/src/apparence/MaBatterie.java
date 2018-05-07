package apparence;

import java.awt.Dimension;

import javax.swing.JProgressBar;

public class MaBatterie extends JProgressBar{
	int Progression;
	
public MaBatterie() {
	
	Progression = 50;
	
	infoPc(); //il va mettre le %v de batterie :D
	
	
	setSize(10, 20);
	setValue(Progression);
	setString(Progression + "%"); //ici on écrit le pourcentage de la batterie
	setStringPainted(true);
	
	
}

private void infoPc() {
	// TODO Auto-generated method stub
	
}




}
