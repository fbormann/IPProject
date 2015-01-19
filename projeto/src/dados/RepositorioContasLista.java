package dados;

import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumaContaCadastradaException;

public class RepositorioContasLista implements RepositorioContas{

	private Conta conta;
	private int contador;
	private RepositorioContasLista proximo;

	public RepositorioContasLista(){
		this.conta = null;
		this.proximo = null;
		this.contador = 0;
	}

	public void adicionar(Conta conta) throws ContaJaCadastradaException {
		if(this.conta == null){
			this.conta = conta;
			this.proximo = new RepositorioContasLista(); //criando o objeto
			contador++;
		}else{
			this.proximo.adicionar(conta);
		}
	}

	public boolean listaVazia(){
		boolean a = false;
		if(this.contador>0){
			a = true;
		}
		return a;
	}

	public void remover(String CPF) throws ContaNaoExisteException {
		if(this.conta!=null){
			if(this.conta.getCPF().equals(CPF)){
				this.conta = this.proximo.conta;
				this.proximo = this.proximo.proximo;
			}else{
				this.proximo.remover(CPF);
			}
		}else{
			throw new ContaNaoExisteException();
		}
	}

	public Conta[] listar() {
		return null;
	}
	//nao precisaremos desse metodo pois ele so iria checar se a lista esta vazia, mas ja temos o metodo listaVazia();
	public String listarConta() throws NenhumaContaCadastradaException {
		return null;
	}

	public Conta buscar(String CPF) throws ContaNaoExisteException {
		Conta contaBuscada = new Conta();
		if(this.exist(CPF)){
			if(this.conta.getCPF().equals(CPF)){
				contaBuscada = this.conta;
				return contaBuscada;
			}else{
				this.proximo.buscar(CPF);
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
				this.proximo.update(conta);
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
			this.proximo.exist(CPF);
		}
		return a;
	}
}
