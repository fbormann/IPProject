package negocios;
import dados.RepositorioCompras;
import entidades.Compra;

public class CadastroCompras {
	private RepositorioCompras compras;
	public CadastroCompras(RepositorioCompras compras){
		this.compras = compras;
	}
	
	public void cadastrarCompra(Compra compra){
		compras.adicionar(compra);
	}
	//TODO: checar novas coisas para fazer.
}
