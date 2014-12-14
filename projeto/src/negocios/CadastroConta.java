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

	public boolean remover(Conta cliente){
		if(contas.procurar(cliente.getCPF())){ //IF conta exists.
			contas.remover(cliente);
		}else{
			return false; //If it wasn't deleted.
		}
		return true; //If it was deleted
	}

	public Conta buscar(String cpf){
		return contas.buscar(cpf);
	}


}
