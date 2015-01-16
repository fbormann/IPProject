package negocios;
import dados.RepositorioCompras;
import entidades.Compra;
import excecoes.CompraNaoExisteException;

public class ManagerCompras {
	
	private RepositorioCompras compras;
	
	public ManagerCompras(RepositorioCompras compras){
		this.compras = compras;
	}
	
	public void cadastrarCompra(Compra compra){
		this.compras.adicionar(compra);
	}
	
	public void removerCompra(String ID) throws CompraNaoExisteException{
		this.compras.remover(ID);
	}
	
	public void updateCompra(Compra compra) throws CompraNaoExisteException{
		this.compras.update(compra);
	}
	
	public Compra buscarCompra(String ID) throws CompraNaoExisteException{
		return this.compras.buscar(ID);
	}
	
	public boolean exist(String ID){
		return this.compras.exist(ID);
	}
}
