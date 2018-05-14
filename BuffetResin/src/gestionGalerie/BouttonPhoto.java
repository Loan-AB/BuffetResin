package gestionGalerie;

import test.MonImage;

public class BouttonPhoto extends JBoutton  {
	
	MonImage monImage;
	

	
	public BouttonPhoto(MonImage monImage) {
		
		
		// TODO Auto-generated constructor stub	
		
		
		monImage.photo.getIconHeight();
		setIcon(monImage.photo);
		}
	}

