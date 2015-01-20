package dados;
import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumaContaCadastradaException;

public interface RepositorioContas {

	void adicionar(Conta conta); 
		
	void remover(String CPF);
			
	Conta buscar(String CPF);
	
	void update(Conta conta);
	
	boolean exist(String CPF);
	
	String listarConta();
	
}
