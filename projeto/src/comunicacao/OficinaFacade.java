package comunicacao;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import dados.RepositorioComprasArray;
import dados.RepositorioServicoArray;
import dados.RepositorioContasArray;
import entidades.Compra;
import entidades.Conta;
import entidades.Servico;
import excecoes.CEPInvalidoException;
import excecoes.CPFInvalidoException;
import excecoes.CompraNaoExisteException;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumServicoCadastradoException;
import excecoes.NenhumaCompraCadastradaException;
import excecoes.NenhumaContaCadastradaException;
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
	static HSSFWorkbook wb;

	public static void inicializar(String repositoryType){
		switch(repositoryType){
		case "array":
			compras = new ManagerCompras(comprasArray);
			contas = new ManagerConta(contasArray);
			servicos = new ManagerServico(servicosArray);
			break;
		case "arquivo":
			wb = new HSSFWorkbook();
			
			break;
		}
	
		
	}

	//VENDA
		public static Iterator comprasIterator(){
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
		public static Iterator contaIterator(){
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
		public static Iterator servicoIterator(){
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
