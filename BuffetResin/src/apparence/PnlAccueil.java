package apparence;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PnlAccueil extends PnlCentre {
	
	MonBouton btnContact;
	MonBouton btnGalerie;
	MonBouton btnSecret;
	MaFenetre maman;

	public PnlAccueil(MaFenetre maman) {
		super("Acceuil");

		this.maman= maman;
		
		//btnContact = new BouttonApplication("./src/photoBoutton/Contact.png");
		btnContact = new MonBouton("Galerie", true);
		btnGalerie = new MonBouton("Galerie", true);
		btnSecret = new MonBouton("Secret", true);	

		
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
