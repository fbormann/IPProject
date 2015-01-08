package negocios;
import dados.RepositorioCompras;
import entidades.Compra;

public class ManagerCompras {
	
	private RepositorioCompras compras;
	
	public ManagerCompras(RepositorioCompras compras){
		this.compras = compras;
	}
	
	public void cadastrarCompra(Compra compra){
		compras.adicionar(compra);
	}
	
	public boolean exist(String ID){
		return this.compras.exist(ID);
	}
}
