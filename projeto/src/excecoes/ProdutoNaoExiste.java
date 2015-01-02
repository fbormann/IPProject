package excecoes;

public class ProdutoNaoExiste extends Exception {
	public ProdutoNaoExiste(){
		super("Esse produto nao existe");
	}
}
