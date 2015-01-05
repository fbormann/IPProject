package excecoes;

public class ContaNaoExisteException extends Exception {
	public ContaNaoExisteException(){
		super("Essa conta nao existe.");
	}
}
