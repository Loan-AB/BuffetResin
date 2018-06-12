package gestionGalerie;


import java.awt.Image;
import javax.swing.ImageIcon;


//Cette classe permet de récupèrer une photo
public class MonImage extends ImageIcon 
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  MesImages mesImages = new MesImages();
	
	protected  ImageIcon photoEntree;
	protected ImageIcon photoSortie;

	
		/**
		 * @author julien
		 * @param numImage
		 *  Récupération d'une image par son numéro dans un tableau et de lui donner une taille 
		 */
		public MonImage(int numImage) 
		{
				photoEntree=mesImages.recupererImage(numImage);
				
				//Transforme l'ImageIcon  en Image
				Image image = photoEntree.getImage();
				//la nouvelle image et mise à l'échelle
				Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH);  
				
				//la newimg est transformée en  ImageIcon
				photoSortie = new ImageIcon(newimg);
				photoSortie.setDescription(photoEntree.getDescription());
		}
	
		/**
		 * @author julien
		 * Récupération d'une image par son lien et de lui donne une taille 
		 * @param chemin
		 */
		public MonImage(String chemin) 
		{
				
				ImageIcon photoEntree = new ImageIcon(chemin);
				
				Image image = photoEntree.getImage(); // transform it 
				Image newimg = image.getScaledInstance(130, 130,  java.awt.Image.SCALE_SMOOTH); // Donne une taille à l'image à l'échelle donnée 
				
				photoSortie = new ImageIcon(newimg);
				photoSortie.setDescription(photoEntree.getDescription());
		}
	
		/**
		 * Constructeur de base
		 */
		public MonImage() 
		{
				
		}

	/**
	 * 	transformationImage
	 * cette methode permet de transformer le string que l'on envoie en imageIcon avec la bonne taille 
	 * la taille est recalculée par rapport a la largeur que nous avons envoié
	 * @param path
	 * @param width
	 * @return
	 * @author loanb
	 */
	public  ImageIcon transformationImage(String path, int largeur) 
	{
		ImageIcon ii = new ImageIcon(path);
		double ratio = (double)largeur/ii.getIconWidth();
		return new ImageIcon(ii.getImage().getScaledInstance((int)(ii.getIconWidth()*ratio), (int)(ii.getIconHeight()*ratio), Image.SCALE_DEFAULT));
	}

	/**
	 * transformationImage
	 * cette methode permet de transformer la descrito que l'on envoie en imageIcon avec la bonne taille 
	 * la taille est definir par rapport au paramètre d'entrée
	 * @param description
	 * @param i
	 * @param j
	 * @return
	 * @author loanb
	 */
	public  ImageIcon transformationImage(String description, int i, int j) 
	{
		ImageIcon ii = new ImageIcon(description);
//		System.out.println("MonImage je retourne votre description " +ii.getDescription());
		return new ImageIcon(ii.getImage().getScaledInstance(i, j, Image.SCALE_DEFAULT));
	}
	

}
