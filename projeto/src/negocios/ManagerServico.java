package negocios;
import entidades.Servico;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
import dados.RepositorioServico;
public class ManagerServico {
	
	private RepositorioServico produtos;
	
	public ManagerServico(RepositorioServico produtos){
		this.produtos = produtos;
	}
	public void cadastrar(Servico servico) throws ServicoJaCadastradoException{
		produtos.adicionar(servico);
	}
	public void remover(String ID) throws ServicoNaoEncontradoException{
		produtos.remover(ID);
	}
	public double consultaPreco(String ID){
		return produtos.consultaPreco(ID);
	}
	
	public Servico buscar(String ID){
		return produtos.buscar(ID);
	}

	public boolean exist(String ID){
		return this.produtos.exist(ID);
	}
	
	public void update(Servico servico) throws ServicoNaoEncontradoException{
		this.produtos.update(servico);
	}
	
}
