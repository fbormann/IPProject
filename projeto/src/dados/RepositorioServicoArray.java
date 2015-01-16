package dados;


import entidades.Servico;
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
		this.servicos = aux;
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

		int indice = 0;

		for(int i = 0; i < this.servicos.length;i++){
			if(!this.servicos[i].getID().equals(ID)){
				aux[indice] = this.servicos[i];
				indice++;
			}
		}

		this.servicos = aux;
	}

	public void update(Servico servico) throws ServicoNaoEncontradoException {
		for(int i = 0; i<this.servicos.length; i++){
			if(this.servicos[i].getID().equals(servico.getID())){
				if(!servico.getNome().equals("")){
					this.servicos[i].setNome(servico.getNome());
				}
				if(servico.getPreco() != 0){
					this.servicos[i].setPreco(servico.getPreco());
				}
				//ID do produto nao pode ser alterado

			}else{
				throw new ServicoNaoEncontradoException();
			}
		}
	}

	public double consultaPreco(String ID) throws ServicoNaoEncontradoException{
		double a = 0;
		if(this.exist(ID)){
			for(int i = 0; i<this.servicos.length; i++){
				if(this.servicos[i].getID().equals(ID)){
					a = this.servicos[i].getPreco();
				}
			}
		}else{
			throw new ServicoNaoEncontradoException();
		}
		return a;
	}

	public Servico[] listar() {
		return this.servicos;
	}

	public Servico buscar(String ID) throws ServicoNaoEncontradoException {
		if(this.exist(ID)){
			for(int i = 0; i<this.servicos.length; i++){
				if(this.servicos[i].getID().equals(ID)){
					return this.servicos[i];
				}
			}
		}else{
			throw new ServicoNaoEncontradoException();
		}

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
