package dados;
import java.util.Iterator;


import entidades.Conta;


public class RepositorioContasArray implements RepositorioContas {
	private Conta[] contas;

	public RepositorioContasArray(){
		this.contas = new Conta[0];
	}

	public void adicionar(Conta conta){
		Conta[] aux = new Conta[this.contas.length+1];

		for(int i = 0; i < this.contas.length;i++){

			aux[i] = this.contas[i];

		}
		aux[aux.length-1] = conta;
		this.contas = aux;
	}

	public void update(Conta conta){
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
		}
	

	public void remover(String CPF) {
		Conta[] aux = new Conta[this.contas.length-1];

		int indice = 0;
		for(int i = 0; i < this.contas.length;i++){
			if(!this.contas[i].getCPF().equals(CPF)){
				aux[indice] = this.contas[i];
				indice++;
			}
		}

		this.contas = aux;

	}

	public Conta buscar(String CPF){
		Conta contaProcurada = new Conta();
		for(int i = 0; i < this.contas.length;i++){
			if(this.contas[i].getCPF().equals(CPF)){
				contaProcurada = this.contas[i]; 
			}
		}

		return contaProcurada;

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
	
	private class ContaIterator implements Iterator<Conta>{

		int index = 0;

	      public boolean hasNext() {
	         return (index < contas.length);
	      }

	      public Conta next() {
	      
	         if(this.hasNext()){
	            return contas[index++];
	         }
	         return null;
	      }		
	
	
		public void remove() {
		}
		
	}
	

	

	public Iterator<Conta> iterator() {
		return new ContaIterator();
	}

	

	
}
