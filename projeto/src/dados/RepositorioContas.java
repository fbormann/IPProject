package dados;
import entidades.Conta;
import excecoes.ContaJaCadastrada;
import excecoes.ContaNaoExiste;

public interface RepositorioContas {

	public void adicionar(Conta conta) throws ContaJaCadastrada; //TODO: Modularizar isto para as classes necessarias
	
	public void remover(int index);
	
	public void remover(String CPF);
	
	public Conta[] listar();
	
	public Conta buscar(Conta conta);
	
	public Conta buscar(String CPF) throws ContaNaoExiste;

	public boolean exist(String CPF);
	
	
}
