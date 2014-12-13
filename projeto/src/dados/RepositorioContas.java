package dados;
import entidades.Conta;

public interface RepositorioContas {

	public void adicionar(Conta conta); //TODO: Modularizar isto para as classes necessarias
	
	public void remover(int index);
	
	public void remover(Conta objeto);
	
	public Conta[] listar();
	
	public Conta buscar(Conta conta);
	
	public Conta buscar(String CPF);

	public boolean procurar(String CPF);
	
	
}
