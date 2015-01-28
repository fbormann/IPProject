package dados;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import entidades.Compra;
import entidades.Conta;
import entidades.Lavagem;
import entidades.Otimizacao;
import entidades.Produto;
import entidades.Servico;

public class RepositorioCompraArquivo implements RepositorioCompras{

	private HSSFSheet compraSheet;
	private HSSFWorkbook wb;
	private int rows;
	private int rowsEnds;
	private int rowsBegins;

	public RepositorioCompraArquivo(HSSFWorkbook wb){

		compraSheet = wb.getSheetAt(1);
		if(compraSheet == null)
			compraSheet = wb.createSheet("compras");
		this.wb = wb;
		rowsEnds = compraSheet.getLastRowNum();
		rowsBegins = compraSheet.getFirstRowNum();
	}

	@Override
	public Iterator<Compra> iterator() {
		return new CompraIterator();
	}

	@Override
	public void adicionar(Compra compra) {
		HSSFRow row = compraSheet.createRow(compraSheet.getLastRowNum()+1);
		HSSFCell cell;
		String[] compraData = new String[3 + compra.getServicos().length];
		compraData[0] = compra.getId();
		compraData[1] = compra.getContaCPF();
		compraData[2] = String.valueOf(compra.getValor());

		for(int i = 0; i < compra.getServicos().length;i++){
			Servico servico = compra.getServicos()[i];
			compraData[3+i] = servico.toString() + "\n:"+ servico.getClass().toString().substring(servico.getClass().toString().indexOf(".")+1); //3+i because it needs to go over all other elements.
		}


		for(int i = 0; i < compraData.length;i++){
			cell =  row.createCell(i);
			cell.setCellValue(compraData[i]);
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
		rowsBegins = compraSheet.getFirstRowNum();
		rowsEnds = compraSheet.getLastRowNum(); //Update rows index;

	}

	@Override
	public void remover(String ID) {

		Iterator<Row> rowItr = compraSheet.rowIterator();
		Row removingRow = null;

		while(rowItr.hasNext()){
			Row row = rowItr.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()){ //TODO:Checar somente Index 0
				Cell cell = cells.next();
				if(cell.getStringCellValue().equals(ID)){
					removingRow = row;
				}
			}
		}

		compraSheet.removeRow(removingRow);
		int rowIndex = removingRow.getRowNum();

		if(rowIndex>=0 && rowIndex<rowsEnds){
			compraSheet.shiftRows(rowIndex+1,rowsEnds, -1);
		}
		rows--; //To fix the index counter at the Iterator.
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream("planilha.xls");
			wb.write(stream);
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		rowsBegins = compraSheet.getFirstRowNum();
		rowsEnds = compraSheet.getLastRowNum();//Update Rows Index.
	}

	@Override
	public void update(Compra compra) {

	}

	@Override
	public Compra buscar(String ID) {
		Compra compra;
		compra = new Compra();
		Iterator<Row> rowItr = compraSheet.rowIterator();
		Row rowData;
		String[] compraData = null;
		int index = 0;
		while(rowItr.hasNext()){
			Row row = rowItr.next();
			if(row.getCell(0).getStringCellValue().equals(ID)){
				Iterator<Cell> cells = row.cellIterator();
				compraData = new String[row.getLastCellNum()];
				while(cells.hasNext()){
					Cell cell = cells.next();
					compraData[index] = cell.getStringCellValue();
					index++;
				}
			}
		}

		compra.setId(compraData[0]);
		compra.setContaCPF(compraData[1]);
		compra.setValor(Double.parseDouble(compraData[2]));
		Servico servicoadc;

		Servico[] servicos = new Servico[compraData.length-3];
		for(int i = 3; i < compraData.length;i++){
			String servico = compraData[i];
			switch(servico.substring(servico.lastIndexOf("."))){
			case "Lavagem":
				servicoadc = new Lavagem();
				break;
			case "Otimizacao":
				servicoadc = new Otimizacao();
				break;
			case "Produto":
				servicoadc = new Produto();
				break;
			}

		}


		return compra;
	}

	@Override
	public boolean exist(String ID) {
		Iterator<Row> rowItr = compraSheet.rowIterator();
		boolean result = false;
		while(rowItr.hasNext()){
			Row row = rowItr.next();
			Cell cellID = row.getCell(0);
			if(cellID.getStringCellValue().equals(ID)){
				result = true;
			}
		}

		return result;

	}

	private class CompraIterator implements Iterator<Compra>{
		int index = rowsBegins;

		private CompraIterator(){
			if(rowsBegins == rowsEnds && rowsEnds != 0){
				index = rowsBegins-1;
			}else{
				if(rowsBegins != 0){
					index = rowsBegins-1;
				}else{
					index = rowsBegins;
				}
			}
		}

		public boolean hasNext() {
			return (index < rowsEnds);
		}


		public Compra next() {
			if(hasNext()){
				index++;
				HSSFRow row = compraSheet.getRow(index);
				HSSFCell cell = row.getCell(0);
				Compra compra = new Compra();
				if(cell != null){
					compra.setId(cell.getStringCellValue());
					compra.setContaCPF(row.getCell(1).getStringCellValue());
				}
				return compra;

			}
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}
}


