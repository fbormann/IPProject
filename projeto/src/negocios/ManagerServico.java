package negocios;
import entidades.Servico;
import excecoes.NenhumServicoCadastradoException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
import excecoes.TipoNaoSelecionadoException;
import dados.RepositorioServico;
public class ManagerServico {
	
	private RepositorioServico servicos;
	
	public ManagerServico(RepositorioServico produtos){
		this.servicos = produtos;
	}
	public void cadastrar(Servico servico) throws ServicoJaCadastradoException, TipoNaoSelecionadoException{
		servicos.adicionar(servico);
	}
	public void remover(String ID) throws ServicoNaoEncontradoException{
		servicos.remover(ID);
	}
	public double consultaPreco(String ID) throws ServicoNaoEncontradoException{
		return servicos.consultaPreco(ID);
	}
	
	public Servico buscar(String ID) throws ServicoNaoEncontradoException{
		return servicos.buscar(ID);
	}

	public boolean exist(String ID){
		return this.servicos.exist(ID);
	}
	
	public void update(Servico servico) throws ServicoNaoEncontradoException{
		this.servicos.update(servico);
	}
	
	public String listarServico() throws NenhumServicoCadastradoException{
		return this.servicos.listarServico(); 
	}
	
	public Servico[] listar(){
		return this.servicos.listar();
	}
	
}
