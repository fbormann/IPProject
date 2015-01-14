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
		
		for(int i = 0; i < this.compras.length;i++){
			if(this.compras[i].getId().equals(compra.getId())){
				if(compra.getValor() != 0){
					this.compras[i].setValor(compra.getValor());
				}
				//TODO: Entender o que pode ser modificado aqui.
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

}
