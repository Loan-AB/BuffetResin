package gestionCalculatrice;

/**
 * @author loanb
 * permet d'oblig� la methodes dans tout les operations
 */
public interface OperationStrategy {
	/**
	 * @param nb1
	 * @param nb2
	 * @return
	 */
	public double doOper(double nb1, double nb2);
}
