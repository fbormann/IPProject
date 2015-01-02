package excecoes;

public class SemProduto extends Exception {
	public SemProduto(){
		super("Não temos mais esse produto no estoque");
	}
}
