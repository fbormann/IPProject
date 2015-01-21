package dados;
import entidades.Servico;
public interface RepositorioServico {
	
	void adicionar(Servico servico);
	
	void remover(String ID);
	
	void update(Servico servico);
	
	double consultaPreco(String ID);
			
	String listarServico();
	
	Servico buscar(String ID);
	
	boolean exist(String ID);
}
