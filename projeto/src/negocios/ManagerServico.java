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
		if(this.servicos.exist(servico.getID())){
			throw new ServicoJaCadastradoException();
		}else{
			this.servicos.adicionar(servico);
		}
	}
	public void remover(String ID) throws ServicoNaoEncontradoException{
		if(this.servicos.exist(ID)){
			this.servicos.remover(ID);
		}else{
			throw new ServicoNaoEncontradoException();
		}
	}
	public double consultaPreco(String ID) throws ServicoNaoEncontradoException{
		double a = 0;
		if(this.servicos.exist(ID)){
			a = servicos.consultaPreco(ID);
		}else{
			throw new ServicoNaoEncontradoException();
		}
		return a;
	}
	public Servico buscar(String ID) throws ServicoNaoEncontradoException{
		if(this.servicos.exist(ID)){
			return servicos.buscar(ID);
		}else{
			throw new ServicoNaoEncontradoException();
		}
	}

	public boolean exist(String ID){
		return this.servicos.exist(ID);
	}

	public void update(Servico servico) throws ServicoNaoEncontradoException{
		if(this.servicos.exist(servico.getID())){
			this.servicos.update(servico);
		}else{
			throw new ServicoNaoEncontradoException();
		}
	}
	//vou esperar a gente discutir sobre esse metodo pra depois implementar!
	public String listarServico() throws NenhumServicoCadastradoException{
		return this.servicos.listarServico(); 
	}

	public Servico[] listar(){
		return this.servicos.listar();
	}

}
