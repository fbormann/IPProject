package comunicacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import dados.RepositorioCompraArquivo;
import dados.RepositorioComprasArray;
import dados.RepositorioComprasLista;
import dados.RepositorioContasArquivo;
import dados.RepositorioContasLista;
import dados.RepositorioServicoArquivo;
import dados.RepositorioServicoArray;
import dados.RepositorioContasArray;
import dados.RepositorioServicoLista;
import entidades.Compra;
import entidades.Conta;
import entidades.Servico;
import excecoes.CEPInvalidoException;
import excecoes.CPFInvalidoException;
import excecoes.CompraNaoExisteException;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.PlacaInvalidaException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
import excecoes.TipoNaoSelecionadoException;
import negocios.*;


public class OficinaFacade {
	public static RepositorioComprasArray comprasArray = new RepositorioComprasArray();
	public static RepositorioContasArray contasArray = new RepositorioContasArray();
	public static RepositorioServicoArray servicosArray = new RepositorioServicoArray();
	public static ManagerCompras compras;
	public static ManagerConta contas;
	public static ManagerServico servicos;
	public static RepositorioContasArquivo contasArquivo;
	public static RepositorioCompraArquivo comprasArquivo;
	public static RepositorioServicoArquivo servicosArquivo;
	public static boolean hasStarted = false;
	static HSSFWorkbook wb;

	public static void inicializar(String repositoryType){
		switch(repositoryType){
		case "array":
			compras = new ManagerCompras(comprasArray);
			contas = new ManagerConta(contasArray);
			servicos = new ManagerServico(servicosArray);
			break;
		case "arquivo":
			String pathname = "planilha.xls"; //Guarda o caminho relativo ate a planilha.
			File file = new File(pathname);
			POIFSFileSystem fs;
			InputStream inputStream = null;
			try
			{
				if(file.exists()){
					inputStream = new FileInputStream (pathname);
					fs = new POIFSFileSystem(inputStream);
					wb = new HSSFWorkbook(fs);
					contasArquivo = new RepositorioContasArquivo(wb);
					contas = new ManagerConta(contasArquivo);
					comprasArquivo = new RepositorioCompraArquivo(wb);
					compras = new ManagerCompras(comprasArquivo);
					servicosArquivo = new RepositorioServicoArquivo(wb);
					servicos = new ManagerServico(servicosArquivo);
				}else{
					file.createNewFile();
					inputStream = new FileInputStream (new File("planilha.xls"));
					FileOutputStream output = new FileOutputStream(new File(pathname));
					wb = new HSSFWorkbook();
					wb.createSheet("contas");
					wb.createSheet("compras");
					wb.createSheet("servicos");
					wb.write(output);
					contasArquivo = new RepositorioContasArquivo(wb);
					contas = new ManagerConta(contasArquivo);
					comprasArquivo = new RepositorioCompraArquivo(wb);
					compras = new ManagerCompras(comprasArquivo);
					servicosArquivo = new RepositorioServicoArquivo(wb);
					servicos = new ManagerServico(servicosArquivo);
					
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.println ("File not found in the specified path.");
				e.printStackTrace ();
			} catch (IOException e) {
				e.printStackTrace();
			}



			

			try {
				inputStream.close(); //Fechamos um input para utilizarmos o output.
			} catch (IOException e) {
				e.printStackTrace();
			}

			FileOutputStream stream = null;
			try {
				stream = new FileOutputStream("planilha.xls"); 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}



			try {
				wb.write(stream);
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}


			break;
		case "lista": //IF HE CHOOSES TO USE LISTS INSTEAD.

			RepositorioComprasLista comprasLista = new RepositorioComprasLista();
			RepositorioContasLista 	contasLista = new RepositorioContasLista();
			RepositorioServicoLista servicosLista = new RepositorioServicoLista();
			compras = new ManagerCompras(comprasLista);
			contas = new ManagerConta(contasLista);
			servicos = new ManagerServico(servicosLista);


			break;
		}


	}

	//VENDA
	public static Iterator<Compra> comprasIterator(){
		return compras.getIterator();
	}

	public static void adicionarCompra(Compra compra){
		compras.cadastrarCompra(compra);
	}
	public static boolean compraExiste(String ID){
		return compras.exist(ID);
	}
	public static void removerCompra(String ID) throws CompraNaoExisteException {
		compras.removerCompra(ID);
	}
	public static Compra buscarCompra(String ID) throws CompraNaoExisteException{
		return compras.buscarCompra(ID);
	}
	public static void updateCompra(Compra compra) throws CompraNaoExisteException{
		compras.updateCompra(compra);
	}

	//CLIENTE

	public static boolean validadeCEP(String CEP) throws CEPInvalidoException{
		return contas.validadeCEP(CEP);
	}

	public static Iterator<Conta> contaIterator(){
		return contas.iterator();
	}
	public static void adicionarConta(Conta conta) throws CPFInvalidoException, CEPInvalidoException, PlacaInvalidaException, ContaJaCadastradaException {
		if(ManagerConta.validadeCPF(conta.getCPF()) && ManagerConta.validadeCEP(conta.getEndereco().getCEP()) && ManagerConta.validadePlaca(conta.getCarro().getPlaca())){
			contas.cadastrar(conta);
		}
	}
	public static void removerConta(String CPF) throws ContaNaoExisteException, CPFInvalidoException{
		contas.remover(CPF);
	}
	public static void updateConta(Conta conta) throws CPFInvalidoException, ContaNaoExisteException, CEPInvalidoException, PlacaInvalidaException{
		if(!conta.getEndereco().getCEP().equals("")){
			ManagerConta.validadeCEP(conta.getEndereco().getCEP());
		}
		if(!conta.getCarro().getPlaca().equals("")){
			ManagerConta.validadePlaca(conta.getCarro().getPlaca());
		}
		contas.update(conta);
	}

	public static Conta buscarConta(String CPF) throws ContaNaoExisteException, CPFInvalidoException{
		Conta contaBuscada = new Conta();
		if(ManagerConta.validadeCPF(CPF)){
			contaBuscada = contas.buscar(CPF);
		}else{
			throw new CPFInvalidoException();
		}
		return contaBuscada;
	}
	public static boolean contaExiste(String CPF) throws CPFInvalidoException{
		return contas.exist(CPF);
	}

	//SERVICO
	public static Iterator<Servico> servicoIterator(){
		return servicos.getIterator();
	}

	//esses metodos a seguir nao vao checar as excecoes pois elas ja estao sendo checadas na camada de negocios
	public static void adicionarServico(Servico servico) throws ServicoJaCadastradoException, TipoNaoSelecionadoException{
		servicos.cadastrar(servico);
	} 
	public static void removerServico(String ID) throws ServicoNaoEncontradoException{
		servicos.remover(ID);
	}
	public static void updateServico(Servico servico) throws ServicoNaoEncontradoException{
		servicos.update(servico);
	}
	public static double consultaPreco(String ID) throws ServicoNaoEncontradoException{
		return servicos.consultaPreco(ID);
	}
	public static Servico buscarServico(String ID) throws ServicoNaoEncontradoException{
		return servicos.buscar(ID);
	}
	public static boolean servicoExiste(String ID){
		return servicos.exist(ID);
	}


}
