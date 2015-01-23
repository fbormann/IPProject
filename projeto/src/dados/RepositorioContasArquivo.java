package dados;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entidades.Conta;

public  class RepositorioContasArquivo implements RepositorioContas{

	private HSSFSheet contaSheet;
	private  HSSFRow[] row;
	public RepositorioContasArquivo(HSSFWorkbook wb){
       contaSheet = wb.createSheet("Contas");
       row = new HSSFRow[1];
       row[0] = contaSheet.createRow(1);
       HSSFCell teste = row[0].createCell((short) 2);
       teste.setCellValue("Teste");
       
	}
	
	public RepositorioContasArquivo(){}
	
	

	public void adicionar(Conta conta) {
		
	}

	public void remover(String CPF) {
		
	}

	public Conta buscar(String CPF) {
		return null;
	}

	public void update(Conta conta) {
		
	}

	public boolean exist(String CPF) {
		return false;
	}


	public Iterator<Conta> iterator() {
		return null;
	}

}
