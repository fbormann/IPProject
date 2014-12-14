package dados;
import entidades.Compra;

public interface RepositorioCompras {
	public void adicionar(Compra compra);
	
	public void remover(String ID);
	
	public void update(Compra compra);
	
	public Compra buscar(String ID);
}
