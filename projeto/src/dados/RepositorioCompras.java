package dados;
import entidades.Compra;
import excecoes.CompraNaoExisteException;
import excecoes.NenhumaCompraCadastradaException;

public interface RepositorioCompras {
	
	public void adicionar(Compra compra);
	
	public void remover(String ID);
	
	public void update(Compra compra);
		
	String listarCompra();
	
	public Compra buscar(String ID);
	
	public boolean exist(String ID);
}
