package negocios;
import java.util.Iterator;

import dados.RepositorioCompras;
import entidades.Compra;
import excecoes.CompraNaoExisteException;

public class ManagerCompras {

	private RepositorioCompras compras;

	public ManagerCompras(RepositorioCompras compras){
		this.compras = compras;
	}

	public void cadastrarCompra(Compra compra){
		this.compras.adicionar(compra);
	}

	public void removerCompra(String ID) throws CompraNaoExisteException{
		if(this.compras.exist(ID)){
			this.compras.remover(ID);
		}else{
			throw new CompraNaoExisteException();
		}
	}

	public void updateCompra(Compra compra) throws CompraNaoExisteException{
		if(this.compras.exist(compra.getId())){
			this.compras.update(compra);
		}else{
			throw new CompraNaoExisteException();
		}
	}

	public Compra buscarCompra(String ID) throws CompraNaoExisteException{
		Compra c = new Compra();
		if(this.compras.exist(ID)){
			c = this.compras.buscar(ID);
		}else{
			throw new CompraNaoExisteException();
		}
		return c;
	}

	public boolean exist(String ID){
		return this.compras.exist(ID);
	}
	
	public Iterator<Compra> getIterator(){
		return this.compras.iterator();
	}
	

	
	
}
