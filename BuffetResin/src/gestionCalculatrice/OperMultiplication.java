package gestionCalculatrice;

public class OperMultiplication extends Operation {

	/* (non-Javadoc)
	 * @see gestionCalculatrice.OperationStrategy#doOper(double, double)
	 */
	@Override
	public double doOper(double nb1, double nb2) {
		return nb1*nb2;
	}

}
