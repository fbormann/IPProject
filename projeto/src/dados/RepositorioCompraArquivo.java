package dados;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entidades.Compra;

public class RepositorioCompraArquivo implements RepositorioCompras{

	private HSSFSheet compraSheet;
	public RepositorioCompraArquivo(HSSFWorkbook wb){
		compraSheet = wb.createSheet("compras");
	}
	
	@Override
	public Iterator<Compra> iterator() {
		return null;
	}

	@Override
	public void adicionar(Compra compra) {
		
	}

	@Override
	public void remover(String ID) {
		
	}

	@Override
	public void update(Compra compra) {
		
	}

	@Override
	public Compra buscar(String ID) {
		return null;
	}

	@Override
	public boolean exist(String ID) {
		return false;
	}

}
