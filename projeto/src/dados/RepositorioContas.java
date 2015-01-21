package dados;
import entidades.Conta;


public interface RepositorioContas {

	void adicionar(Conta conta); 
		
	void remover(String CPF);
			
	Conta buscar(String CPF);
	
	void update(Conta conta);
	
	boolean exist(String CPF);
	
	String listarConta();
	
}
