package dados;

import entidades.Conta;
import entidades.Servico;
import excecoes.ContaNaoExisteException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;

public class RepositorioServicoArray implements RepositorioServico{
	private Servico[] servicos;
	
	public RepositorioServicoArray(){
		this.servicos = new Servico[0];
	}

	public void adicionar(Servico servico) throws ServicoJaCadastradoException {
		Servico[] aux = new Servico[this.servicos.length+1];
		for(int i = 0; i < this.servicos.length;i++){
			if(this.servicos[i].getID().equals(servico.getID())){
				throw new ServicoJaCadastradoException();
			}else{
				aux[i] = this.servicos[i];
			}
		}
		
		aux[aux.length-1] = servico;
		
	}

	public void remover(String ID) throws ServicoNaoEncontradoException{
		Servico[] aux = new Servico[this.servicos.length-1];
		boolean existe = false;
		for(int i = 0; i < this.servicos.length;i++){
			if(this.servicos[i].getID().equals(ID)){
				existe = true;
			}
		}
		
		if(!existe){
			throw new ServicoNaoEncontradoException();
		}
		
		for(int i = 0; i < this.servicos.length;i++){
			if(!this.servicos[i].getID().equals(ID)){
				aux[i] = this.servicos[i];
			}
		}
	}

	public void update(String ID) throws ServicoNaoEncontradoException {
		
	}

	public double consultaPreco(String ID) {
		return 0;
	}

	public double consultaPrecoNome(String nome) {
		return 0;
	}

	public Servico[] listar() {
		return null;
	}

	public Servico consulta(String ID) {
		return null;
	}
	
	
	public boolean exist(String ID){
		boolean exist = false;
		for(int i = 0; i < this.servicos.length;i++){
			if(this.servicos[i].getID().equals(ID)){
				exist = true;
			}
		}
		return exist;
	}
	

}
