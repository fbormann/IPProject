package dados;
import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumaContaCadastradaException;

public interface RepositorioContas {

	public void adicionar(Conta conta) throws ContaJaCadastradaException; 
		
	public void remover(String CPF) throws ContaNaoExisteException;
	
	public Conta[] listar();
	
	public String listarConta() throws NenhumaContaCadastradaException;
	
	public Conta buscar(String CPF) throws ContaNaoExisteException;
	
	public void update(Conta conta) throws ContaNaoExisteException;
	
	public boolean exist(String CPF);
	
}
