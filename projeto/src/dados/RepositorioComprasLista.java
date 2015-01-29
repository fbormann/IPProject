package dados;

import java.util.Iterator;

import entidades.Compra;
import entidades.Conta;

public class RepositorioComprasLista implements RepositorioCompras {

	private Compra compra;
	private RepositorioComprasLista proximo;
	int size = 0;

	public RepositorioComprasLista(){
		this.compra = null;
		this.proximo = null;
	}

	public Compra getCompra(){
		return this.compra;
	}

	public RepositorioComprasLista getProximo(){
		return this.proximo;
	}

	public void adicionar(Compra compra) {
		if(this.compra == null){
			this.compra = compra;
			this.proximo = new RepositorioComprasLista();
		}else{
			this.proximo.adicionar(compra);
		}

		size++;
	}

	public void remover(String ID) {
		if(this.compra != null){
			if(this.compra.getId().equals(ID)){
				this.compra = this.proximo.getCompra();
				this.proximo = this.proximo.proximo;
			}else{
				if(this.proximo.getCompra() != null){
					this.proximo.remover(ID);
				}
			}
		}

		size--;
	}

	public void update(Compra compra) {
		if(this.compra.getId().equals(compra.getId())){
			if(this.compra.getValor() != 0){
				this.compra.setValor(compra.getValor());
			}
		}else{
			if(this.proximo.getCompra() != null){
				this.proximo.update(compra);
			}
		}
	}

	public Compra buscar(String ID) {
		Compra compraBuscada = new Compra();
		if(this.compra != null){
			if(this.compra.getId().equals(ID)){
				compraBuscada = this.compra;
			}else{
				if(this.proximo.getCompra() != null){
					compraBuscada = this.proximo.buscar(ID);
				}
			}
		}
		return compraBuscada;
	}

	public boolean exist(String ID) {
		boolean a = false;
		if(this.compra != null){
			if(this.compra.getId().equals(ID)){
				a = true;
			}else{
				if(this.proximo.getCompra() != null){
					a = this.proximo.exist(ID);
				}
			}
		}
		return a;
	}

	public Compra get(int index){
		Compra compra = this.compra;
		int i = 0;
		while(i < index){
			compra = this.proximo.compra;
		}

		return compra;
	}

	public Iterator<Compra> getIterator() {
		return new CompraIterator();
	}

	private class CompraIterator implements Iterator<Compra>{
		int index = 0;

		@Override
		public boolean hasNext() {
			return (index < size);
		}

		@Override
		public Compra next() {
			Compra compra = get(index);
			index++;
			return compra;
		}

	}

	@Override
	public Iterator<Compra> iterator() {
		return new CompraIterator();
	}

}
