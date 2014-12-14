package negocios;
import dados.RepositorioContas;
import entidades.Conta;

public class CadastroConta {
	private RepositorioContas contas;

	public CadastroConta(RepositorioContas contas){
		this.contas = contas;
	}

	public void cadastrar(Conta cliente){ //TODO: Criar "Conta ja criada Exception"
		contas.adicionar(cliente);
	}

	public void remover(String CPF){
		contas.remover(CPF);
	}

	public Conta buscar(String cpf){
		return contas.buscar(cpf);
	}


}
