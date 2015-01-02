package dados;
import entidades.Conta;
import excecoes.ContaJaCadastrada;
import excecoes.ContaNaoExiste;

public interface RepositorioContas {

	public void adicionar(Conta conta) throws ContaJaCadastrada; //TODO: Modularizar isto para as classes necessarias
		
	public void remover(String CPF) throws ContaNaoExiste;
	
	public Conta[] listar();
	
	public Conta buscar(String CPF) throws ContaNaoExiste;

	public boolean exist(String CPF);
	
	
}
