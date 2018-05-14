package gestionGalerie;

import java.io.File;

public class MesImages extends ImageIcon {
	
	File content [];
	
	public MesImages() {
		// TODO Auto-generated constructor stub
		
		File source = new File("C:/Users/julie/eclipse-workspace/ProjetSmartphoneETestPerso/src/test/Photo");
		// de quoi descendre dans les sous répertoires et ainsi tester le nom
		content = source.listFiles();
	}

}
