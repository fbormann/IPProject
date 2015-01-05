package dados;
import entidades.Compra;
import excecoes.CompraNaoExisteException;

public interface RepositorioCompras {
	public void adicionar(Compra compra);
	
	public void remover(String ID) throws CompraNaoExisteException;
	
	public void update(Compra compra);
	
	public Compra buscar(String ID);
}
