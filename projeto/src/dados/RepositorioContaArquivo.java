package dados;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entidades.Conta;

public class RepositorioContaArquivo implements RepositorioContas{

	HSSFWorkbook wb;
	
	public RepositorioContaArquivo(){
		wb = new HSSFWorkbook();
		
	}
	
	@Override
	public void forEach(Consumer<? super Conta> arg0) {
		
	}

	@Override
	public Spliterator<Conta> spliterator() {
		return null;
	}

	@Override
	public void adicionar(Conta conta) {
		
	}

	@Override
	public void remover(String CPF) {
		
	}

	@Override
	public Conta buscar(String CPF) {
		return null;
	}

	@Override
	public void update(Conta conta) {
		
	}

	@Override
	public boolean exist(String CPF) {
		return false;
	}

	@Override
	public String listarConta() {
		return null;
	}

	@Override
	public Iterator<Conta> iterator() {
		return null;
	}

}
