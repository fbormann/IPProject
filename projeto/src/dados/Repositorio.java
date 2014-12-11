package dados;

public interface Repositorio {

	public void adicionar(Object servico); //TODO: Modularizar isto para as classes necessarias
	
	public void remover(int index);
	
	public void remover(Object objeto);
	
	public Object[] listar();
	
	
}
