package dados;
import entidades.Servico;
public interface RepositorioServico extends Iterable<Servico>{
	
	void adicionar(Servico servico);
	
	void remover(String ID);
	
	void update(Servico servico);
	
	double consultaPreco(String ID);
	
	Servico buscar(String ID);
	
	boolean exist(String ID);
}
