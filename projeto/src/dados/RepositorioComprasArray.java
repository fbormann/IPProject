package dados;
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

		aux[aux.length -1] = compra; //Adiciona o último item ao final do array;

		this.compras = aux;
	}

	public void remover(String ID){
		Compra[] aux = new Compra[this.compras.length];

		for(int i = 0; i < this.compras.length;i++){
			if(!compras[i].getId().equals(ID)){ // If it is different do not remove
				aux[i] = compras[i];
			}
		}
		
		this.compras = aux;
	}

	public void update(Compra compra) {

	}

	public Compra buscar(String ID) {
		for(int i = 0; i < this.compras.length; i++){
			if(this.compras[i].getId().equals(ID)){
				return this.compras[i];
			}
		}

		return null;
	}

}
