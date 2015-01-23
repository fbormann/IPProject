package dados;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entidades.Servico;

public class RepositorioServicoArquivo implements RepositorioServico{

	private HSSFSheet servicosSheet;

	public RepositorioServicoArquivo(HSSFWorkbook wb){
		servicosSheet = wb.createSheet("servicos");


	}

	public Iterator<Servico> iterator() {
		return null;
	}

	public void adicionar(Servico servico) {
		// TODO Auto-generated method stub

	}

	public void remover(String ID) {
		// TODO Auto-generated method stub

	}

	public void update(Servico servico) {
		// TODO Auto-generated method stub

	}

	public double consultaPreco(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Servico buscar(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

}
