package dados;

import java.util.Iterator;

import entidades.Compra;

public class RepositorioComprasLista implements RepositorioCompras {

	private Compra compra;
	private RepositorioComprasLista proximo;

	private RepositorioComprasLista(){
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
					this.proximo.buscar(ID);
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
					this.proximo.buscar(ID);
				}
			}
		}
		return a;
	}

	public Iterator<Compra> getIterator() {
		return null;
	}

	public Iterator<Compra> iterator() {
		return null;
	}




}
