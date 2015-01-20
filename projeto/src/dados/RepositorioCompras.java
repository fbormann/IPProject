package dados;
import java.util.Iterator;

import entidades.Compra;

public interface RepositorioCompras{
	
	public void adicionar(Compra compra);
	
	public void remover(String ID);
	
	public void update(Compra compra);
		
	String listarCompra();
	
	public Compra buscar(String ID);
	
	public boolean exist(String ID);
	
	public Iterator getIterator();
}
