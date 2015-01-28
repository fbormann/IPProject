package dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import entidades.Carro;
import entidades.Conta;
import entidades.Endereco;

public  class RepositorioContasArquivo implements RepositorioContas{

	private HSSFSheet contaSheet = null;
	private int rows = 0;
	private int rowBegins = 0;
	private int rowsEnds = 0;
	HSSFWorkbook wb;
	private FileOutputStream stream = null;

	public RepositorioContasArquivo(HSSFWorkbook wb){
		this.wb = wb;
		contaSheet = wb.getSheetAt(0);
		if(contaSheet == null)
			contaSheet = wb.createSheet("contas");
		rows = contaSheet.getLastRowNum();
		rowBegins = contaSheet.getFirstRowNum();
		rowsEnds = contaSheet.getLastRowNum();
	}

	public void adicionar(Conta conta) {
		HSSFRow row = contaSheet.createRow(contaSheet.getLastRowNum()+1);
		HSSFCell cell;
		int cellIndex = 0;
		String[] accountData = new String[13];
		accountData[0] = conta.getCPF();
		accountData[1] = conta.getNome();
		accountData[2] = conta.getEndereco().getBairro();
		accountData[3] = conta.getEndereco().getCEP();
		accountData[4] = conta.getEndereco().getCidade();
		accountData[5] = conta.getEndereco().getEstado();
		accountData[6]  = conta.getEndereco().getRua();
		accountData[7] = conta.getEndereco().getComplemento();
		accountData[8] = String.valueOf(conta.getEndereco().getNumero());
		accountData[9] = conta.getCarro().getCor();
		accountData[10] = conta.getCarro().getMarca();
		accountData[11] = conta.getCarro().getModelo();
		accountData[12] = conta.getCarro().getPlaca();


		for(int i = 0; i < accountData.length;i++){
			cell =  row.createCell(i);
			cell.setCellValue(accountData[i]);
		}

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("planilha.xls");
			this.wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		rows++;

		rowBegins = contaSheet.getFirstRowNum();
		rowsEnds = contaSheet.getLastRowNum(); //Update rows index;
	}

	public void remover(String CPF) {
		Iterator<Row> rowItr = contaSheet.rowIterator();
		Row removingRow = null;

		while(rowItr.hasNext()){
			Row row = rowItr.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()){
				Cell cell = cells.next();
				if(cell.getStringCellValue().equals(CPF)){
					removingRow = row;
				}
			}
		}

		contaSheet.removeRow(removingRow);
		int rowIndex = removingRow.getRowNum();

		if(rowIndex>=0 && rowIndex<rowsEnds){
			contaSheet.shiftRows(rowIndex+1,rowsEnds, -1);
		}
		rows--; //To fix the index counter at the Iterator.
		try {
			stream = new FileOutputStream("planilha.xls"); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		try {
			wb.write(stream);
			stream.close();
		}catch(IOException e){

		}

		rowBegins = contaSheet.getFirstRowNum();
		rowsEnds = contaSheet.getLastRowNum();//Update Rows Index.
	}

	public Conta buscar(String CPF) {

		Iterator<Row> rowItr = contaSheet.rowIterator();

		Conta conta = null;
		String[] accountData = new String[13];
		int index = 0;
		while(rowItr.hasNext()){
			Row row = rowItr.next();
			if(row.getCell(0).getStringCellValue().equals(CPF)){
				Iterator<Cell> cells = row.cellIterator();
				while(cells.hasNext()){
					Cell cell = cells.next();
					accountData[index] = cell.getStringCellValue();
					index++;
				}
			}
		}
		conta = new Conta();
		Endereco endereco = new Endereco();
		endereco.setBairro(accountData[2]);
		endereco.setCEP(accountData[3]);
		endereco.setCidade(accountData[4]);
		endereco.setEstado(accountData[5]);
		endereco.setRua(accountData[6]);
		endereco.setComplemento(accountData[7]);
		endereco.setNumero(Integer.parseInt(accountData[8]));
		conta.setCPF(accountData[0]);
		conta.setNome(accountData[1]);
		conta.setEndereco(endereco);
		Carro carro = new Carro();
		carro.setCor(accountData[9]);
		carro.setMarca(accountData[10]);
		carro.setModelo(accountData[11]);
		carro.setPlaca(accountData[12]);
		conta.setCarro(carro);
		return conta;
	}

	public void update(Conta conta) {
		String[] accountData = new String[13];
		accountData[0] = conta.getCPF();
		accountData[1] = conta.getNome();
		accountData[2] = conta.getEndereco().getBairro();
		accountData[3] = conta.getEndereco().getCEP();
		accountData[4] = conta.getEndereco().getCidade();
		accountData[5] = conta.getEndereco().getEstado();
		accountData[6]  = conta.getEndereco().getRua();
		accountData[7] = conta.getEndereco().getComplemento();
		accountData[8] = String.valueOf(conta.getEndereco().getNumero());
		accountData[9] = conta.getCarro().getCor();
		accountData[10] = conta.getCarro().getMarca();
		accountData[11] = conta.getCarro().getModelo();
		accountData[12] = conta.getCarro().getPlaca();
		int index = 0;

		Iterator<Row> rowItr = contaSheet.rowIterator();
		while(rowItr.hasNext()){
			Row row = rowItr.next();
			if(row.getCell(0).getStringCellValue().equals(conta.getCPF())){
				Iterator<Cell> cells = row.cellIterator();
				while(cells.hasNext()){
					Cell cell = cells.next();
					cell.setCellValue(accountData[index]);
					index++;
				}
			}
		}

		try {
			stream = new FileOutputStream("planilha.xls"); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}



		try {
			wb.write(stream);
			stream.close();
		}catch(IOException e){

		}

	}

	public boolean exist(String CPF) {
		Iterator<Row> rowItr = contaSheet.rowIterator();
		boolean result = false;
		while(rowItr.hasNext()){
			Row row = rowItr.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()){
				Cell cell = cells.next();
				if(cell.getStringCellValue().equals(CPF)){
					result = true;
				}
			}
		}
		return result;
	}


	public Iterator<Conta> iterator() {
		return new ContaIterator();
	}


	private class ContaIterator implements Iterator<Conta>{
		int index = rowBegins;

		private ContaIterator(){
			if(rowBegins == rowsEnds && rowsEnds != 0){
				index = rowBegins-1;
			}else{
				if(rowBegins != 0){
					index = rowBegins-1;
				}else{
					index = rowBegins;
				}
			}
		}

		public boolean hasNext() {
			return (index < rowsEnds);
		}


		public Conta next() {
			if(hasNext()){
				index++;
				HSSFRow row = contaSheet.getRow(index);
				HSSFCell cell = row.getCell(0);
				Conta conta = new Conta();
				if(cell != null){
					conta.setCPF(cell.getStringCellValue()); //Get the CPF.
					conta.setNome(row.getCell(1).getStringCellValue());//Get the name
				}
				return conta;//TODO:Preencher essa conta.

			}
			return null;
		}


		

	}



}
