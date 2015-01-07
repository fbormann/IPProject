package negocios;
import dados.RepositorioContas;
import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;

public class ManagerConta {
	private RepositorioContas contas;

	public ManagerConta(RepositorioContas contas){
		this.contas = contas;
	}

	public void cadastrar(Conta conta) throws ContaJaCadastradaException{ 
		contas.adicionar(conta);
	}

	public void remover(String CPF) throws ContaNaoExisteException{
		contas.remover(CPF);
	}

	public Conta buscar(String CPF) throws ContaNaoExisteException{
		return contas.buscar(CPF);
	}
	
	public boolean exist(String CPF){
		return contas.exist(CPF);
	}


}
