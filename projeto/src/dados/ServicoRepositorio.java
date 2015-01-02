package dados;
import entidades.Servico;
import excecoes.ServicoJaCadastrado;
public interface ServicoRepositorio {
	
	void adicionar(Servico servico) throws ServicoJaCadastrado;
	
	void remover(String ID);
	
	void atualizar(String ID);
	
	double consultaPreco(String ID);
	
	double consultaPrecoNome(String nome);
	
	Servico[] listar();
	
	Servico consulta(String ID);
	
}
