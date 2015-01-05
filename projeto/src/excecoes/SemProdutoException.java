package excecoes;

public class SemProdutoException extends Exception {
	public SemProdutoException(){
		super("Nao temos mais esse produto no estoque");
	}
}
