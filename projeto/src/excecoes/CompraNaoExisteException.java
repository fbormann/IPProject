package excecoes;

public class CompraNaoExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompraNaoExisteException(){
		super("Essa compra nao existe");
	}
}
