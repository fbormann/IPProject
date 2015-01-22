package excecoes;

public class CEPInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CEPInvalidoException(){
		super("CEP esta no formato incorreto");
	}

}
