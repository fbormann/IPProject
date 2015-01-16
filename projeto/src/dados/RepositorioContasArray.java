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
		if(this.exist(conta.getCPF())){
		for(int i = 0; i < this.contas.length;i++){
				if(!conta.getNome().equals("")){
					this.contas[i].setNome(conta.getNome());
				}
				if(!conta.getEndereco().getBairro().equals("")){
					this.contas[i].getEndereco().setBairro(conta.getEndereco().getBairro());
				}

				if(!conta.getEndereco().getCidade().equals("")){
					this.contas[i].getEndereco().setCidade(conta.getEndereco().getCidade());
				}

				if(!conta.getEndereco().getCEP().equals("")){
					this.contas[i].getEndereco().setCEP(conta.getEndereco().getCEP());
				}

				if(!conta.getEndereco().getEstado().equals("")){
					this.contas[i].getEndereco().setEstado(conta.getEndereco().getEstado());
				}

				if(!conta.getEndereco().getRua().equals("")){
					this.contas[i].getEndereco().setRua(conta.getEndereco().getRua());
				}

				if(conta.getEndereco().getNumero() != 0){
					this.contas[i].getEndereco().setNumero(conta.getEndereco().getNumero());
				}

				if(!conta.getNome().equals("")){
					this.contas[i].setNome(conta.getNome());
				}
				
				if(!conta.getCarro().getCor().equals("")){
					this.contas[i].getCarro().setCor(conta.getCarro().getCor());
				}
				
				if(!conta.getCarro().getMarca().equals("")){
					this.contas[i].getCarro().setMarca(conta.getCarro().getMarca());
				}
				
				if(!conta.getCarro().getModelo().equals("")){
					this.contas[i].getCarro().setModelo(conta.getCarro().getModelo());
				}
				
				if(!conta.getCarro().getPlaca().equals("")){
					this.contas[i].getCarro().setPlaca(conta.getCarro().getPlaca());
				}
				
			}
		}else{
			throw new ContaNaoExisteException();
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

		int indice = 0;
		for(int i = 0; i < this.contas.length;i++){
			if(!this.contas[i].getCPF().equals(CPF)){
				aux[indice] = this.contas[i];
				indice++;
			}
		}
		
		this.contas = aux;

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
