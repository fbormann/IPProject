package excecoes;

public class ProdutoNaoExisteException extends Exception {
	public ProdutoNaoExisteException(){
		super("Esse produto nao existe");
	}
}
