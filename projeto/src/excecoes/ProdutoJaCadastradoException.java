package excecoes;

public class ProdutoJaCadastradoException extends Exception {
	public ProdutoJaCadastradoException(){
		super("Produto ja cadastrado");
	}

}
