package negocios;
import java.util.Iterator;

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
		if(this.contas.exist(conta.getCPF())){
			throw new ContaJaCadastradaException();
		}else{
			this.contas.adicionar(conta);
		}
	}

	public void remover(String CPF) throws ContaNaoExisteException{
		if(this.contas.exist(CPF)){
			this.contas.remover(CPF);
		}else{
			throw new ContaNaoExisteException();
		}
	}

	public Conta buscar(String CPF) throws ContaNaoExisteException{
		Conta c = new Conta();
		if(this.contas.exist(CPF)){
			c = this.contas.buscar(CPF);
		}else{
			throw new ContaNaoExisteException();
		}
		return c;
	}

	public boolean exist(String CPF) {
		return this.contas.exist(CPF);
	}

	public void update(Conta conta) throws ContaNaoExisteException{
		if(this.contas.exist(conta.getCPF())){
			this.contas.update(conta);
		}else{
			throw new ContaNaoExisteException();
		}
	}
	//nao sei se esta certo; lembrando que esse metodo vai listar TODAS as contas existentes!
	public String listarConta() throws NenhumaContaCadastradaException{
		String a = "";
		if(this.contas.listarConta() != null){
			a = a + this.contas.listarConta();
		}else{
			throw new NenhumaContaCadastradaException();
		}
		return a;
	}
	
	public Iterator iterator(){
		return this.contas.iterator();
	}

	
}
