package dados;
import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumaContaCadastradaException;

public interface RepositorioContas {

	void adicionar(Conta conta) throws ContaJaCadastradaException; 
		
	void remover(String CPF) throws ContaNaoExisteException;
			
	Conta buscar(String CPF) throws ContaNaoExisteException;
	
	void update(Conta conta) throws ContaNaoExisteException;
	
	boolean exist(String CPF);
	
	String listarConta() throws NenhumaContaCadastradaException;
	
}
