package dados;
import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;

public interface RepositorioContas {

	public void adicionar(Conta conta) throws ContaJaCadastradaException; 
		
	public void remover(String CPF) throws ContaNaoExisteException;
	
	public Conta[] listar();
	
	public Conta buscar(String CPF) throws ContaNaoExisteException;
	
	public void update(Conta conta) throws ContaNaoExisteException;
	
	public boolean exist(String CPF);
	
}
