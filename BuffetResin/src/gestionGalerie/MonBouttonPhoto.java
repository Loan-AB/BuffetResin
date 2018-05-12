package gestionGalerie;



public class MonBouttonPhoto extends JBoutton  {
	
	MesImage[] mesImages;
	
	public MonBouttonPhoto() {
		// TODO Auto-generated constructor stub

		for(int i=0;i>mesImages.length;i++) {
			mesImages[i].getIconHeight();
			setIcon(mesImages[i]);
		}
		
	}

}
