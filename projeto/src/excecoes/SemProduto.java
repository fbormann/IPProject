package excecoes;

public class SemProduto extends Exception {
	public SemProduto(){
		super("Nao temos mais esse produto no estoque");
	}
}
