package gestionGalerie;

import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

	//source : http://www.camick.com/java/source/WrapLayout.java
	//https://tips4java.wordpress.com/2008/11/06/wrap-layout/


	/**
	 *  FlowLayout subclass that fully supports wrapping of components.
	 */
	//Sous-classe FlowLayout qui prend entièrement en charge l'encapsulation des composants.
public  class WrapLayout extends FlowLayout
{
	private Dimension preferredLayoutSize;

	/**
	* Constructs a new <code>WrapLayout</code> with a left
	* alignment and a default 5-unit horizontal and vertical gap.
	*/
	
	/**
	 * Construit un nouveau <code>WrapLayout</code> avec un code gauche.
	 * alignement et un espace par défaut de 5 unités horizontales et verticales.
	*/
	
	public WrapLayout()
	{
		super();
	}

	/**
	* Constructs a new <code>FlowLayout</code> with the specified
	* alignment and a default 5-unit horizontal and vertical gap.
	* The value of the alignment argument must be one of
	* <code>WrapLayout</code>, <code>WrapLayout</code>,
	* or <code>WrapLayout</code>.
	*  @param align the alignment value
	*/
	
	/**Construit un nouveau <code>FlowLayout</code> avec le code spécifié.
	 * alignement et un espace par défaut de 5 unités horizontales et verticales.
	 * La valeur de l'argument d'alignement doit être l'une des valeurs suivantes
	 * <code>WrapLayout</code>, <code>WrapLayout</code>,
	 * ou <code>WrapLayout</code>.
	 * @param align la valeur d'alignement
	 */
	
	public WrapLayout(int align)
	{
		super(align);
	}

	/**
	* Creates a new flow layout manager with the indicated alignment
	* and the indicated horizontal and vertical gaps.
	* <p>
	* The value of the alignment argument must be one of
	* <code>WrapLayout</code>, <code>WrapLayout</code>,
	* or <code>WrapLayout</code>.
	* @param align the alignment value
	* @param hgap the horizontal gap between components
	* @param vgap the vertical gap between components
	*/
	
   /**Crée un nouveau gestionnaire de disposition des flux avec l'alignement indiqué.
    * et les espaces horizontaux et verticaux indiqués.
	* <p>
	* La valeur de l'argument d'alignement doit être l'une des valeurs suivantes
	* <code>WrapLayout</code>, <code>WrapLayout</code>,
	* ou <code>WrapLayout</code>.
	* @param align la valeur d'alignement
	* @param hgap l'écart horizontal entre les composants.
	* @param vgap l'écart vertical entre les composants.
	  */

	
	public WrapLayout(int align, int hgap, int vgap)
	{
		super(align, hgap, vgap);
	}

	/**
	* Returns the preferred dimensions for this layout given the
	* <i>visible</i> components in the specified target container.
	* @param target the component which needs to be laid out
	* @return the preferred dimensions to lay out the
	* subcomponents of the specified container
	*/
	
	
	@Override
	public Dimension preferredLayoutSize(Container target)
	{
		return layoutSize(target, true);
	}

	/**
	* Returns the minimum dimensions needed to layout the <i>visible</i>
	* components contained in the specified target container.
	* @param target the component which needs to be laid out
	* @return the minimum dimensions to lay out the
	* subcomponents of the specified container
	*/
	
	
	
	@Override
	public Dimension minimumLayoutSize(Container target)
	{
		Dimension minimum = layoutSize(target, false);
		minimum.width -= (getHgap() + 1);
		return minimum;
	}

	/**
	* Returns the minimum or preferred dimension needed to layout the target
	* container.
	*
	* @param target target to get layout size for
	* @param preferred should preferred size be calculated
	* @return the dimension to layout the target container
	*/
	
	/**
	 * Retourne la dimension minimale ou préférée nécessaire à la mise en page de la cible.
	 * conteneur.
	
	 * @param cible cible cible pour obtenir la taille de la mise en page pour
	 * @param preferred should preferred size should preferred size be calculated
	 * Retourne la dimension pour mettre en page le conteneur cible.
	
	*/
	
	private Dimension layoutSize(Container target, boolean preferred)
	{
	synchronized (target.getTreeLock())
	{
		//  Each row must fit with the width allocated to the containter.
		//  When the container width = 0, the preferred width of the container
		//  has not yet been calculated so lets ask for the maximum.

		/**
		 * 
		 * Chaque rangée doit correspondre à la largeur allouée au contenant.
		 * Lorsque la largeur du conteneur = 0, la largeur préférée du conteneur.
		 * n'a pas encore été calculé, alors demandons le maximum.
		
		 */
		
		int targetWidth = target.getSize().width;
		Container container = target;

		while (container.getSize().width == 0 && container.getParent() != null)
		{
			container = container.getParent();
		}

		targetWidth = container.getSize().width;

		if (targetWidth == 0)
			targetWidth = Integer.MAX_VALUE;

		int hgap = getHgap();
		int vgap = getVgap();
		Insets insets = target.getInsets();
		int horizontalInsetsAndGap = insets.left + insets.right + (hgap * 2);
		int maxWidth = targetWidth - horizontalInsetsAndGap;

		//  Fit components into the allowed width
		//  Monter les composants dans la largeur autorisée.

		Dimension dim = new Dimension(0, 0);
		int rowWidth = 0;
		int rowHeight = 0;

		int nmembers = target.getComponentCount();

		for (int i = 0; i < nmembers; i++)
		{
			Component m = target.getComponent(i);

			if (m.isVisible())
			{
				Dimension d = preferred ? m.getPreferredSize() : m.getMinimumSize();

				//  Can't add the component to current row. Start a new row.

				//  Impossible d'ajouter le composant à la ligne courante. Commencez une nouvelle rangée.
				
				if (rowWidth + d.width > maxWidth)
				{
					addRow(dim, rowWidth, rowHeight);
					rowWidth = 0;
					rowHeight = 0;
				}

				//  Add a horizontal gap for all components after the first
				//  Ajouter un espace horizontal pour tous les composants après le premier.

				if (rowWidth != 0)
				{
					rowWidth += hgap;
				}

				rowWidth += d.width;
				rowHeight = Math.max(rowHeight, d.height);
			}
		}

		addRow(dim, rowWidth, rowHeight);

		dim.width += horizontalInsetsAndGap;
		dim.height += insets.top + insets.bottom + vgap * 2;

		//	When using a scroll pane or the DecoratedLookAndFeel we need to
		//  make sure the preferred size is less than the size of the
		//  target containter so shrinking the container size works
		//  correctly. Removing the horizontal gap is an easy way to do this.
		
		/** Lorsque vous utilisez un panneau de défilement ou le DecoratedLookAndFeel nous avons besoin de
		 *  s'assurer que la taille préférée est inférieure à la taille de l'objet.
		 *  Le conteneur cible pour réduire la taille du conteneur fonctionne.
		 *  correctement. L'élimination de l'espace horizontal est un moyen facile de le faire.
		 */
		Container scrollPane = SwingUtilities.getAncestorOfClass(JScrollPane.class, target);

		if (scrollPane != null && target.isValid())
		{
			dim.width -= (hgap + 1);
		}

		return dim;
	}
	}

	/*
	 *  A new row has been completed. Use the dimensions of this row
	 *  to update the preferred size for the container.
	 *
	 *  @param dim update the width and height when appropriate
	 *  @param rowWidth the width of the row to add
	 *  @param rowHeight the height of the row to add
	 */
	
	/*
	 * Une nouvelle ligne a été complétée. Utilisez les dimensions de cette rangée
	 * pour mettre à jour la taille préférée pour le conteneur.
	 *
	 * @param dim met à jour la largeur et la hauteur lorsque c'est approprié.
	 * @param rowWidth Largeur de la largeur de la rangée à ajouter
	 * @param rowHauteur de la hauteur de la ligne à ajouter
	 */
	private void addRow(Dimension dim, int rowWidth, int rowHeight)
	{
		dim.width = Math.max(dim.width, rowWidth);

		if (dim.height > 0)
		{
			dim.height += getVgap();
		}

		dim.height += rowHeight;
	}
}