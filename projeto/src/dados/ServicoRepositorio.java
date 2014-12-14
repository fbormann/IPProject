package dados;
import entidades.Servico;
public interface ServicoRepositorio {
	
	void adicionar(Servico servico);
	
	void remover(String ID);
	
	void atualizar(String ID);
	
	double consultaPreco(String ID);
	
	double consultaPrecoNome(String nome);
	
	Servico[] listar();
	
	Servico consulta(String ID);
	
}
