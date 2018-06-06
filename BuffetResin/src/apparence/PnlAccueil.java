package apparence;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PnlAccueil extends PnlCentre {
	
	BouttonApplication btnContact;
	MonBouton btnGalerie;
	MonBouton btnSecret;
	MaFenetre maman;

	public PnlAccueil(MaFenetre maman) {
		super("Acceuil");

		this.maman= maman;
		
		
		//btnContact = new BouttonApplication(");
		btnContact = new BouttonApplication("./src/photoBoutton/Contact.png","Contact");
		btnGalerie = new BouttonApplication("./src/photoBoutton/Gallerie.png","Galerie");
		btnSecret = new BouttonApplication("./src/photoBoutton/Jeu.png","Secret");	

		
		add(btnContact);
		add(btnGalerie);
		add(btnSecret);
		
		
	}

	public void setListenerBtn(ActionListener lancerContact, ActionListener lancerSecret,
			ActionListener lancerGalerie) {
		btnContact.addActionListener(lancerContact);
		btnGalerie.addActionListener(lancerGalerie);
		btnSecret.addActionListener(lancerSecret);
		
	}
	
	public void setListenerBtn(ActionListener lancerAppli) {
		btnContact.addActionListener(lancerAppli);
		btnGalerie.addActionListener(lancerAppli);
		btnSecret.addActionListener(lancerAppli);
		
	}
	
}
