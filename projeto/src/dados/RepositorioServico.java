package dados;
import entidades.Servico;
import excecoes.NenhumServicoCadastradoException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
public interface RepositorioServico {
	
	void adicionar(Servico servico) throws ServicoJaCadastradoException;
	
	void remover(String ID) throws ServicoNaoEncontradoException;
	
	void update(Servico servico) throws ServicoNaoEncontradoException;
	
	double consultaPreco(String ID) throws ServicoNaoEncontradoException;
		
	Servico[] listar();
	
	String listarServico() throws NenhumServicoCadastradoException;
	
	Servico buscar(String ID) throws ServicoNaoEncontradoException;
	
	boolean exist(String ID);
}
