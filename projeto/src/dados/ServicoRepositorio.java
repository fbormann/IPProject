package dados;
import entidades.Servico;
import excecoes.ServicoJaCadastrado;
import excecoes.ServicoNaoEncontrado;
public interface ServicoRepositorio {
	
	void adicionar(Servico servico) throws ServicoJaCadastrado;
	
	void remover(String ID) throws ServicoNaoEncontrado;
	
	void atualizar(String ID);
	
	double consultaPreco(String ID);
	
	double consultaPrecoNome(String nome);
	
	Servico[] listar();
	
	Servico consulta(String ID);
	
}
