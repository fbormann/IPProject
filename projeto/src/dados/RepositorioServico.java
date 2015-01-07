package dados;
import entidades.Servico;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
public interface RepositorioServico {
	
	void adicionar(Servico servico) throws ServicoJaCadastradoException;
	
	void remover(String ID) throws ServicoNaoEncontradoException;
	
	void update(String ID) throws ServicoNaoEncontradoException;
	
	double consultaPreco(String ID);
	
	double consultaPrecoNome(String nome);
	
	Servico[] listar();
	
	Servico consulta(String ID);
	
	boolean exist(String ID);
}
