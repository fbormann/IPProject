package dados;

import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumaContaCadastradaException;

public class RepositorioContasLista implements RepositorioContas{

	private Conta conta;
	private RepositorioContasLista proximo;

	public RepositorioContasLista(){
		this.conta = null;
		this.proximo = null;
	}

	public Conta getConta(){
		return this.conta;
	}

	public RepositorioContasLista getProximo(){
		return this.proximo;
	}

	public void adicionar(Conta conta) throws ContaJaCadastradaException{
		if(this.conta == null){
			this.conta = conta;
			this.proximo = new RepositorioContasLista(); //criando o objeto
		}else{
			this.proximo.adicionar(conta);
		}
	}

	public int quantidade(){
		int contador = 0;
		Conta c = new Conta();
		c = this.conta;
		while(c != null){
			contador++;
			c = this.proximo.getConta();
		}
		return contador;
	}

	public void remover(String CPF) throws ContaNaoExisteException {
		if(this.conta != null){
			if(this.conta.getCPF().equals(CPF)){
				this.conta = this.proximo.conta; 
				this.proximo = this.proximo.proximo;
			}else{
				if(this.proximo.getConta() != null){ //conferir se o proximo nao eh null
					this.proximo.remover(CPF);
				}else{
					throw new ContaNaoExisteException();
				}
			}
		}else{
			throw new ContaNaoExisteException();
		}
	}

	public Conta buscar(String CPF) throws ContaNaoExisteException {
		Conta contaBuscada = new Conta();
		if(this.exist(CPF)){
			if(this.conta.getCPF().equals(CPF)){
				contaBuscada = this.conta;
				return contaBuscada;
			}else{
				if(this.proximo.getConta() != null){ //conferir se o proximo nao eh null
					this.proximo.buscar(CPF);
				}else{
					throw new ContaNaoExisteException();
				}
			}
		}else{
			throw new ContaNaoExisteException();
		}

		return null;
	}

	public void update(Conta conta) throws ContaNaoExisteException {
		if(this.exist(conta.getCPF())){
			if(this.conta.getCPF().equals(conta.getCPF())){
				if(!this.conta.getNome().equals(conta.getNome())){
					this.conta.setNome(conta.getNome());
				}
				if(!this.conta.getEndereco().getRua().getClass().equals("")){
					this.conta.getEndereco().setRua(conta.getEndereco().getRua());
				}
				if(this.conta.getEndereco().getNumero()!=0){
					this.conta.getEndereco().setNumero(conta.getEndereco().getNumero());
				}
				if(!this.conta.getEndereco().getComplemento().equals("")){
					this.conta.getEndereco().setComplemento(conta.getEndereco().getComplemento());
				}
				if(!this.conta.getEndereco().getCEP().equals("")){
					this.conta.getEndereco().setCEP(conta.getEndereco().getComplemento());
				}
				if(!this.conta.getEndereco().getBairro().equals("")){
					this.conta.getEndereco().setBairro(conta.getEndereco().getBairro());
				}
				if(!this.conta.getEndereco().getCidade().equals("")){
					this.conta.getEndereco().setCidade(conta.getEndereco().getCidade());
				}
				if(!this.conta.getEndereco().getEstado().equals("")){
					this.conta.getEndereco().setEstado(conta.getEndereco().getEstado());
				}
				if(!this.conta.getCarro().getMarca().equals("")){
					this.conta.getCarro().setMarca(conta.getCarro().getMarca());
				}
				if(!this.conta.getCarro().getModelo().equals("")){
					this.conta.getCarro().setModelo(conta.getCarro().getModelo());
				}
				if(!this.conta.getCarro().getCor().equals("")){
					this.conta.getCarro().setCor(conta.getCarro().getCor());
				}
				if(!this.conta.getCarro().getPlaca().equals("")){
					this.conta.getCarro().setPlaca(conta.getCarro().getPlaca());
				}
			}else{
				if(this.proximo.getConta() != null){
					this.proximo.update(conta);
				}else{
					throw new ContaNaoExisteException();
				}
			}
		}else{
			throw new ContaNaoExisteException();
		}
	}

	public boolean exist(String CPF) {
		boolean a = false;
		if(this.conta.getCPF().equals(CPF)){
			a = true;
		}else{
			if(this.proximo.getConta() != null){
				this.proximo.exist(CPF);
			}
		}
		return a;
	}
	//vai listar todas as contas que está na Lista
	public String listarConta() throws NenhumaContaCadastradaException {
		String a = "";
		Conta c = new Conta();
		while(c != null){
			a = a + c.toString();
			c = this.proximo.getConta();
		}

		return null;
	}
}
