package dados;

import entidades.Conta;


public interface RepositorioContas extends Iterable<Conta>{

	void adicionar(Conta conta); 
		
	void remover(String CPF);
			
	Conta buscar(String CPF);
	
	void update(Conta conta);
	
	boolean exist(String CPF);
	
	
}
