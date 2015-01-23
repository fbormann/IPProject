package dados;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entidades.Conta;

public class RepositorioContaArquivo implements RepositorioContas{

	private HSSFSheet contaSheet;
	
	public RepositorioContaArquivo(HSSFWorkbook wb){
       contaSheet = wb.createSheet("Contas");
	}
	
	

	public void adicionar(Conta conta) {
		
	}

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


	public Iterator<Conta> iterator() {
		return null;
	}

}
