package dados;

import java.util.Iterator;

import entidades.Servico;

public class RepositorioServicoLista implements RepositorioServico{

	private Servico servico;
	private RepositorioServicoLista proximo;

	public RepositorioServicoLista(){
		this.servico = null;
		this.proximo = null;
	}

	public RepositorioServicoLista getProximo(){
		return this.proximo;
	}

	public Servico getServico(){
		return this.servico;
	}

	public int quantidade(){
		int contador = 0;
		if(this.servico != null){
			contador++;
			this.servico = this.proximo.getServico();
		}
		return contador;
	}

	public void adicionar(Servico servico){
		if(this.servico == null){
			this.servico = servico;
			this.proximo = new RepositorioServicoLista();
		}else{
			this.proximo.adicionar(servico);
		}
	}

	public void remover(String ID) {
		if(this.servico != null){
			if(this.servico.getID().equals(ID)){
				this.servico = this.proximo.servico;
				this.proximo = this.proximo.proximo;
			}else{
				if(this.proximo.getServico() != null){
					this.proximo.remover(ID);
				}
			}
		}
	}

	public void update(Servico servico) {
		if(this.servico.getID().equals(servico.getID())){
			if(!this.servico.getNome().equals("")){
				this.servico.setNome(servico.getNome());
			}
			if(this.servico.getPreco() != 0){
				this.servico.setPreco(servico.getPreco());
			}
		}else{
			if(this.proximo.getServico() != null){
				this.proximo.update(servico);
			}
		}
	}

	public double consultaPreco(String ID) {
		double a = 0;
		if(this.servico.getID().equals(ID)){
			a = this.servico.getPreco();
		}else{
			if(this.proximo.getServico() != null){
				a = this.proximo.consultaPreco(ID);
			}
		}
		return a;
	}

	public Servico buscar(String ID) {
		Servico servicoBuscado = null;
		if(this.servico.getID().equals(ID)){
			servicoBuscado = this.servico;
		}else{
			if(this.proximo.getServico() != null){
				servicoBuscado = this.proximo.buscar(ID);
			}
		}
		return servicoBuscado; 
	}

	public boolean exist(String ID) {
		boolean a = false;
		if(this.servico == null){
			a = false;
		}else{
			if(this.servico.getID().equals(ID)){
				a = true;
			}else{
				if(this.proximo.getServico() != null){
					a = this.proximo.exist(ID); //retornar a chamada do metodo = recursao
				}
			}
		}
		return a;
	}

	public Iterator<Servico> iterator() {
		return null;
	}

}
