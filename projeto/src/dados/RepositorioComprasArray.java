package dados;

import java.util.Iterator;


import entidades.Compra;


public class RepositorioComprasArray implements RepositorioCompras{
	private Compra[] compras;
	

	public RepositorioComprasArray(){
		this.compras = new Compra[0];
	}

	public void adicionar(Compra compra){
		Compra[] aux = new Compra[this.compras.length +1];
		for(int i = 0; i < this.compras.length; i++){
			aux[i] = compras[i];

		}
		aux[aux.length -1] = compra; //Adiciona o �ltimo item ao final do array;

		this.compras = aux;
	}

	public void remover(String ID){
		Compra[] aux = new Compra[this.compras.length];
		int indice = 0;
		for(int i = 0; i < this.compras.length;i++){
			if(!compras[i].getId().equals(ID)){ // If it is different do not remover
				aux[indice] = compras[i];
				indice++;
			}
		}
		this.compras = aux;
	}

	public void update(Compra compra) { //apenas o valor de uma compra pode ser modificado depois 
		
		for(int i = 0; i < this.compras.length;i++){
			if(this.compras[i].getId().equals(compra.getId())){
				if(compra.getValor() != 0){
					this.compras[i].setValor(compra.getValor());
				}
				this.compras[i] = compra;
			}
		}
	}

	public Compra buscar(String ID) {
		for(int i = 0; i < this.compras.length; i++){
			if(this.compras[i].getId().equals(ID)){
				return this.compras[i];
			}
		}

		return null;
	}
	
	public boolean exist(String ID){
		boolean exist = false;
		for(int i = 0; i < this.compras.length;i++){
			if(this.compras[i].getId().equals(ID)){
				exist = true;
			}
		}
		return exist;
	}

	public String listarCompra(){
		String r = "";
		if(this.compras!=null){
			for(int i = 0; i<this.compras.length; i++){
				r = r + this.compras[i].toString();
			}
		}
		return r;
	}
	
	private class CompraIterator implements Iterator<Compra>{

		int index = 0;

	      public boolean hasNext() {
	         return (index < compras.length);
	      }

	      public Compra next() {
	      
	         if(this.hasNext()){
	            return compras[index++];
	         }
	         return null;
	      }		
		public void remove() {
		}
		
	}
	

	public Iterator<Compra> getIterator() {
		return new CompraIterator();
	}


	public Iterator<Compra> iterator() {
		return new CompraIterator();
	}

	
	


}
