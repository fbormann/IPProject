package comunicacao;

import dados.RepositorioComprasArray;
import entidades.Compra;
import negocios.*;

public class Oficina {
	private CadastroCompras compras;
	private CadastroConta contas;
	private CadastroServico servicos;
	private RepositorioComprasArray comprasArray;
	
	
	public Oficina(){
		comprasArray = new RepositorioComprasArray();
		this.compras = new CadastroCompras(comprasArray);
	}
	
	public void adicionarCompra(Compra compra){
		if(!this.compras.exist(compra.getId())){
			compras.cadastrarCompra(compra);
		}else{
			//TODO: implementar a logica por 
		}
		
		this.compras.cadastrarCompra(compra);
	}
}
