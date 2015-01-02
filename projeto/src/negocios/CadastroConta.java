package negocios;
import dados.RepositorioContas;
import entidades.Conta;
import excecoes.ContaJaCadastrada;
import excecoes.ContaNaoExiste;

public class CadastroConta {
	private RepositorioContas contas;

	public CadastroConta(RepositorioContas contas){
		this.contas = contas;
	}

	public void cadastrar(Conta cliente) throws ContaJaCadastrada{ //TODO: Criar "Conta ja criada Exception"
		contas.adicionar(cliente);
	}

	public void remover(String CPF) throws ContaNaoExiste{
		contas.remover(CPF);
	}

	public Conta buscar(String CPF) throws ContaNaoExiste{
		return contas.buscar(CPF);
	}


}
