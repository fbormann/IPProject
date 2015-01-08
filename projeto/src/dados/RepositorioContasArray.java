package dados;
import entidades.Conta;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;

public class RepositorioContasArray implements RepositorioContas {
	private Conta[] contas;
	
	public RepositorioContasArray(){
		this.contas = new Conta[0];
	}

	public void adicionar(Conta conta) throws ContaJaCadastradaException {
		Conta[] aux = new Conta[this.contas.length+1];

		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(conta.getCPF())){
				throw new ContaJaCadastradaException();
			}else{
				aux[i] = this.contas[i];
			}
		}
		aux[aux.length-1] = conta;
		this.contas = aux;
	}

	
	public void update(Conta conta) throws ContaNaoExisteException{
		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(conta.getCPF())){
				this.contas[i] = conta;
			}
		}
	}

	public void remover(String CPF) throws ContaNaoExisteException {
		Conta[] aux = new Conta[this.contas.length-1];
		boolean existe = false;
		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(CPF)){
				existe = true;
			}
		}
		
		if(!existe){
			throw new ContaNaoExisteException();
		}
		
		for(int i = 0; i < this.contas.length;i++){
			if(!this.contas[i].getCPF().equals(CPF)){
				aux[i] = this.contas[i];
			}
		}
		
	}

	public Conta[] listar() {
		return this.contas;
	}

	public Conta buscar(String CPF) throws ContaNaoExisteException {
		Conta contaProcurada = new Conta();
		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(CPF)){
				contaProcurada = this.contas[i]; 
			}
		}
		if(contaProcurada == null){
			throw new ContaNaoExisteException();
		}else{
			return contaProcurada;
		}
	}

	public boolean exist(String CPF) {
		boolean existe = false;
		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(CPF)){
				existe = true;
			}
		}
		
		return existe;
	}
}
