package dados;
import entidades.Compra;
import excecoes.CompraNaoExiste;

public interface RepositorioCompras {
	public void adicionar(Compra compra);
	
	public void remover(String ID) throws CompraNaoExiste;
	
	public void update(Compra compra);
	
	public Compra buscar(String ID);
}
