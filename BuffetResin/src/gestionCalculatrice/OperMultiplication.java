package gestionCalculatrice;

public class OperMultiplication extends Operation {

	/* (non-Javadoc)
	 * @see gestionCalculatrice.OperationStrategy#doOper(double, double)
	 * doOper
	 * permet multiplications de 2 nombre
	 * @author loanb
	 */
	@Override
	public double doOper(double nb1, double nb2) {
		return nb1*nb2;
	}

}
