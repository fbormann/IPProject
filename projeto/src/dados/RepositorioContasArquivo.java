package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entidades.Conta;

public  class RepositorioContasArquivo implements RepositorioContas{

	private HSSFSheet contaSheet;
	private int rows = 0;
	private HSSFWorkbook wb;
	public RepositorioContasArquivo(HSSFWorkbook wb){

		contaSheet = wb.createSheet("contas");

		this.wb = wb;
		
		
	
	}




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
		return new ContaIterator();
	}


	private class ContaIterator implements Iterator<Conta>{
		int index = 0;
		@Override
		public boolean hasNext() {
			return (index < rows);
		}

		@Override
		public Conta next() {
			if(hasNext()){
				//return rows[index++];
			}
			return null;
		}

	}

}
