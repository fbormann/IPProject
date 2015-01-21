package dados;
import java.util.Iterator;

import entidades.Conta;


public interface RepositorioContas extends Iterable{

	void adicionar(Conta conta); 
		
	void remover(String CPF);
			
	Conta buscar(String CPF);
	
	void update(Conta conta);
	
	boolean exist(String CPF);
	
	String listarConta();

	public Iterator iterator();
	
}
