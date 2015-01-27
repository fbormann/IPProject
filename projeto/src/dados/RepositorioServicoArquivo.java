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

import entidades.Conta;
import entidades.Lavagem;
import entidades.Otimizacao;
import entidades.Produto;
import entidades.Servico;

public class RepositorioServicoArquivo implements RepositorioServico{

	private HSSFSheet servicosSheet;
	private HSSFWorkbook wb;
	private int rows;
	private int rowBegins;
	private int rowsEnds;
	public RepositorioServicoArquivo(HSSFWorkbook wb){
		servicosSheet = wb.getSheetAt(2);
		if(servicosSheet == null){
			servicosSheet = wb.createSheet("servicos");
		}

		this.wb = wb;
		rows = servicosSheet.getLastRowNum();
		rowBegins = servicosSheet.getFirstRowNum();
		rowsEnds = servicosSheet.getLastRowNum();

	}

	public Iterator<Servico> iterator() {
		return new ServicoIterator();
	}

	public void adicionar(Servico servico) {
		HSSFRow row = servicosSheet.createRow(servicosSheet.getLastRowNum()+1);
		HSSFCell cell;
		int cellIndex = 0;
		String[] servicoData = new String[4];
		servicoData[0] = servico.getID();
		servicoData[1] = servico.getNome();
		servicoData[2] = String.valueOf(servico.getPreco());
		if(servico instanceof Lavagem){
			servicoData[3] = "Lavagem";
		}else if(servico instanceof Otimizacao){
			servicoData[3] = "Otimizacao";
		}else if(servico instanceof Produto){
			servicoData[3] = "Produto";
		}

		for(int i = 0; i < servicoData.length;i++){
			cell =  row.createCell(i);
			cell.setCellValue(servicoData[i]);
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

		rowBegins = servicosSheet.getFirstRowNum();
		rowsEnds = servicosSheet.getLastRowNum(); //Update rows index;


	}

	public void remover(String ID) {

	}

	public void update(Servico servico) {

	}

	public double consultaPreco(String ID) {
		return 0;
	}

	@Override
	public Servico buscar(String ID) {
		return null;
	}

	@Override
	public boolean exist(String ID) {
		Iterator<Row> rowItr = servicosSheet.rowIterator();
		boolean result = false;
		while(rowItr.hasNext()){
			Row row = rowItr.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()){
				Cell cell = cells.next();
				if(cell.getStringCellValue().equals(ID)){
					result = true;
				}
			}
		}
		return result;

	}

	public HSSFSheet getServicosSheet() {
		return servicosSheet;
	}

	public void setServicosSheet(HSSFSheet servicosSheet) {
		this.servicosSheet = servicosSheet;
	}

	private class ServicoIterator implements Iterator<Servico>{
		int index = rowBegins;

		private ServicoIterator(){
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


		public Servico next() {
			if(hasNext()){
				index++;
				HSSFRow row = servicosSheet.getRow(index);
				HSSFCell cell = row.getCell(0);

				Servico servico = null;
				switch(row.getCell(3).getStringCellValue()){
				case "Lavagem":
					servico = new Lavagem();
					break;
				case "Otimizacao":
					servico = new Otimizacao();
					break;
				case "Produto":
					servico = new Produto();
					break;
				}

				if(cell != null){
					servico.setID(cell.getStringCellValue()); //Get the CPF.
					servico.setNome(row.getCell(1).getStringCellValue());//Get the name
				}
				return servico;//TODO:Preencher essa conta.

			}
			return null;
		}

	}

}
