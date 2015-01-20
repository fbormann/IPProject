package negocios;
import dados.RepositorioContas;
import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumaContaCadastradaException;

public class ManagerConta {
	private RepositorioContas contas;

	public ManagerConta(RepositorioContas contas){
		this.contas = contas;
	}

	public void cadastrar(Conta conta) throws ContaJaCadastradaException{ 
		this.contas.adicionar(conta);
	}

	public void remover(String CPF) throws ContaNaoExisteException{
		this.contas.remover(CPF);
	}

	public Conta buscar(String CPF) throws ContaNaoExisteException{
		return this.contas.buscar(CPF);
	}
	
	public boolean exist(String CPF) {
		return this.contas.exist(CPF);
	}
	
	public void update(Conta conta) throws ContaNaoExisteException{
		this.contas.update(conta);
	}
	
	public String listarConta() throws NenhumaContaCadastradaException{
		return this.contas.listarConta();
	}
	
	public Conta[] listar(){
		return this.contas.listar();
	}

}
