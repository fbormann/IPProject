package dados;
import entidades.Conta;
import excecoes.ContaJaCadastrada;
import excecoes.ContaNaoExiste;

public class RepositorioContasArray implements RepositorioContas {
	private Conta[] contas;
	
	public RepositorioContasArray(){
		this.contas = new Conta[0];
	}

	public void adicionar(Conta conta) throws ContaJaCadastrada {
		Conta[] aux = new Conta[this.contas.length+1];

		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(conta.getCPF())){
				throw new ContaJaCadastrada();
			}else{
				aux[i] = this.contas[i];
			}
		}
		aux[aux.length-1] = conta;
		this.contas = aux;
	}


	public void remover(String CPF) throws ContaNaoExiste {
		Conta[] aux = new Conta[this.contas.length-1];
		boolean existe = false;
		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(CPF)){
				existe = true;
			}
		}
		
		if(!existe){
			throw new ContaNaoExiste();
		}
		
		for(int i = 0; i < this.contas.length;i++){
			if(!this.contas[i].getCPF().equals(CPF)){
				aux[i] = this.contas[i];
			}
		}
		
	}

	public Conta[] listar() {
		return null;
	}

	public Conta buscar(String CPF) throws ContaNaoExiste {
		Conta contaProcurada = new Conta();
		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(CPF)){
				contaProcurada = this.contas[i]; 
			}
		}
		if(contaProcurada == null){
			throw new ContaNaoExiste();
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
