package gestionCalculatrice;

public class SigRetour extends Sigle {

	public SigRetour(String signe) {
		super(signe);
	}

	public static String retour(String valeurString) {
		
		if (valeurString.length() > 3) //donc si ce n'est pas vide
		{
//			System.out.println(valeurString + "av");
		StringBuilder strB = new StringBuilder(valeurString);
		strB.deleteCharAt(valeurString.length()-3);
//		System.out.println(Double.parseDouble(strB.toString()));
//		String temp = strB.toString();
		System.out.println(Double.parseDouble(strB.toString()) + "oui oui");
//		return Double.parseDouble(temp);
//		return strB.toString();
		return "";
		}
		else
		{
			return "0.0";
			//ben c'est plu petit quoi donc le chiffre passe a zero
		}
		// merci https://www.youtube.com/watch?v=Ym9_qF4iGHg
		// pour la solution est l'explication du code
		
	}

}
