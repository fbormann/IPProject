package dados;


import java.util.Iterator;


import entidades.Servico;

public class RepositorioServicoArray implements RepositorioServico{
	private Servico[] servicos;

	public RepositorioServicoArray(){
		this.servicos = new Servico[0];
	}

	public void adicionar(Servico servico){
		Servico[] aux = new Servico[this.servicos.length+1];
		for(int i = 0; i < this.servicos.length;i++){

			aux[i] = this.servicos[i];

		}

		aux[aux.length-1] = servico;
		this.servicos = aux;
	}

	public void remover(String ID){
		Servico[] aux = new Servico[this.servicos.length-1];

		int indice = 0;

		for(int i = 0; i < this.servicos.length;i++){
			if(!this.servicos[i].getID().equals(ID)){
				aux[indice] = this.servicos[i];
				indice++;
			}
		}

		this.servicos = aux;
	}

	public void update(Servico servico){
		for(int i = 0; i<this.servicos.length; i++){
			if(this.servicos[i].getID().equals(servico.getID())){
				if(!servico.getNome().equals("")){
					this.servicos[i].setNome(servico.getNome());
				}
				if(servico.getPreco() != 0){
					this.servicos[i].setPreco(servico.getPreco());
				}
				//ID do produto nao pode ser alterado

			}
		}
	}

	public double consultaPreco(String ID){
		double a = 0;
			for(int i = 0; i<this.servicos.length; i++){
				if(this.servicos[i].getID().equals(ID)){
					a = this.servicos[i].getPreco();
				}
			}
		
		return a;
	}
	//esse metodo retorna a referencia do array
	public Servico[] listar() {
		return this.servicos;
	}
	//esse metodo vai retornar as descricoes de todos os servicos cadastrados no array
	public String listarServico(){
		String r = "";
		if(this.servicos != null){
			for(int i = 0; i<this.servicos.length; i++){
				r += r + this.servicos[i].toString();
			}
		}
		return r;
	}
	
	public Servico buscar(String ID){
		for(int i = 0; i<this.servicos.length; i++){
			if(this.servicos[i].getID().equals(ID)){
				return this.servicos[i];
			}
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

	private class ServicoIterator implements Iterator{

		int index = 0;

	      public boolean hasNext() {
	         return (index < servicos.length);
	      }

	      public Object next() {
	      
	         if(this.hasNext()){
	            return servicos[index++];
	         }
	         return null;
	      }		
		
	
		public void remove() {
		}
		
	}
	
	
	

	public Iterator iterator() {
		return new ServicoIterator();
	}

	

}
