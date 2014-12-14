package exceções;

public class ProdutoJaCadastrado extends Exception {
	public ProdutoJaCadastrado(){
		super("Produto já cadastrado");
	}

}
