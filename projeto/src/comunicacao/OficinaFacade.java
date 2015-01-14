package comunicacao;

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
import excecoes.PlacaInvalidaException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
import negocios.*;


public class OficinaFacade {
	public static ManagerCompras compras;
	public static ManagerConta contas;
	public static ManagerServico servicos;
	public static RepositorioComprasArray comprasArray;
	public static RepositorioContasArray contasArray;
	public static RepositorioServicoArray servicosArray;

	public static void inicializar(){
		OficinaFacade.comprasArray = new RepositorioComprasArray();
		OficinaFacade.compras = new ManagerCompras(comprasArray);
		OficinaFacade.contasArray = new RepositorioContasArray();
		OficinaFacade.contas = new ManagerConta(contasArray);
		OficinaFacade.servicosArray = new RepositorioServicoArray();
		OficinaFacade.servicos = new ManagerServico(servicosArray);
	}


	//VENDA
	public static void adicionarCompra(Compra compra) throws ContaNaoExisteException{
		if(compras.exist(compra.getId())){
			compras.cadastrarCompra(compra);
		}else{
			throw new ContaNaoExisteException();
		}
	}
	public boolean compraExiste(String ID) throws CompraNaoExisteException{
		CompraNaoExisteException e = new CompraNaoExisteException();
		if(compras.exist(ID)){
			return true;
		}else{
			throw e;
		}
	}

	public static void removerCompra(String ID) throws CompraNaoExisteException {
		if(compras.exist(ID)){
			compras.removerCompra(ID);
		}else{
			throw new CompraNaoExisteException();
		}
	}
	public static Compra buscarCompra(String ID) throws CompraNaoExisteException{
		if(compras.exist(ID)){
			return compras.buscarCompra(ID);
		}else{
			throw new CompraNaoExisteException();
		}
	}

	//CLIENTE
	public static void adicionarConta(Conta conta) throws ContaJaCadastradaException, CPFInvalidoException, CEPInvalidoException, PlacaInvalidaException {
		if(!contas.exist(conta.getCPF())){
			if(validadeCPF(conta.getCPF())){
				if(validadeCEP(conta.getEndereco().getCEP())){
					if(validadePlaca(conta.getCarro().getPlaca())){
						contas.cadastrar(conta);
					}else{
						PlacaInvalidaException a = new PlacaInvalidaException();
						throw a;
					}
				}else{
					CEPInvalidoException b = new CEPInvalidoException();
					throw b;
				}
			}else{
				CPFInvalidoException c = new CPFInvalidoException();
				throw c;
			}
		}else{
			ContaJaCadastradaException d = new ContaJaCadastradaException();
			throw d;
		}
	}
	public static void removerConta(String CPF) throws ContaNaoExisteException, CPFInvalidoException{
		if(!contas.exist(CPF)){
			ContaNaoExisteException e = new ContaNaoExisteException();
			throw e;
		}else{
			contas.remover(CPF);
		}
	}
	public static void updateConta(Conta conta) throws CPFInvalidoException, ContaNaoExisteException, CEPInvalidoException, PlacaInvalidaException{
		if(contas.exist(conta.getCPF())){
			if(validadeCPF(conta.getCPF())){
				if(validadeCEP(conta.getEndereco().getCEP())){
					if(validadePlaca(conta.getCarro().getPlaca())){
						contas.update(conta);
					}else{
						throw new PlacaInvalidaException();
					}
				}else{
					throw new CEPInvalidoException();
				}
			}else{
				throw new CPFInvalidoException();
			}
		}else{
			throw new ContaNaoExisteException();
		}
	}
	public static boolean validadeCPF(String CPF) throws CPFInvalidoException{
		CPFInvalidoException e = new CPFInvalidoException();
		//checar tamanho
		if(CPF.length()!=14){
			throw e;
		}else{
			//checar se h� somente n�meros
			for(int i = 0; i<CPF.length(); i++){
				if(i!=3 && i!=7 && i!=11){
					if(CPF.charAt(i)>=48 && CPF.charAt(i)<=57){
						return true;
					}else{
						throw e;
					}
				}
			}
			//checando hifen e ponto
			String exemplo = "000.000.000-00";
			int a = exemplo.charAt(3);
			int b = exemplo.charAt(7);
			int c = exemplo.charAt(11);
			if(a == 46 && b == 46 && c == 45){
				return true;
			}else{
				throw e;
			}

		}
	}
	public static boolean validadeCEP(String CEP) throws CEPInvalidoException{
		CEPInvalidoException e = new CEPInvalidoException();
		//checar tamanho
		if(CEP.length()!=9){
			throw e;
			//checando se h� somente n�meros
		}else{
			for(int i = 0; i<CEP.length(); i++){
				if(i!=5){
					if(CEP.charAt(i)>=48 && CEP.charAt(i)<=57){
						return true;
					}else{
						throw e;
					}
				}
			}
			//checando ap
			String exemploCEP = "00000-000";
			int a = exemploCEP.charAt(5);
			if(a == 45){
				return true;
			}else{
				throw e;
			}
		}
	}
	public static boolean validadePlaca(String placa) throws PlacaInvalidaException{
		PlacaInvalidaException a = new PlacaInvalidaException();
		//checar tamanho
		if(placa.length()!=8){
			throw a;
			//checando se h� numeros onde deve haver n�meros
		}else{
			for(int i = 0; i <placa.length(); i++){
				if(i>=4){
					if(placa.charAt(i)>=48 && placa.charAt(i)<=57){
						return true;
					}else{
						throw a;
					}
				}
				//checando se h� letras onde deve haver letras
				if(i<=2){
					if(placa.charAt(i)>=65 && placa.charAt(i)<=90){
						return true;
					}else{
						throw a;
					}
				}
			}
			//checando se o hifen est� na posicao correta
			String exemploPlaca = "AAA-0000";
			int c = exemploPlaca.charAt(3);
			if(c == 45){
				return true;
			}else{
				throw a;
			}

		}
	}
	public static Conta buscarConta(String CPF) throws ContaNaoExisteException, CPFInvalidoException{
		if(validadeCPF(CPF)){
			if(contas.exist(CPF)){
				return contas.buscar(CPF);
			}else{
				throw new ContaNaoExisteException();
			}
		}else{
			throw new CPFInvalidoException();
		}
	}
	public static boolean contaExiste(String CPF) throws ContaNaoExisteException, CPFInvalidoException{
		if(validadeCPF(CPF)){
			if(contas.exist(CPF)){
				return true;
			}else{
				throw new ContaNaoExisteException();
			}
		}else{
			throw new CPFInvalidoException();
		}
	}

	//SERVICO
	public static void adicionarServico(Servico servico) throws ServicoJaCadastradoException{
		if(!servicos.exist(servico.getID())){
			servicos.cadastrar(servico);
		}else{
			ServicoJaCadastradoException e = new ServicoJaCadastradoException();
			throw e;
		}
	}
	public static void removerServico(String ID) throws ServicoNaoEncontradoException{
		if(!servicos.exist(ID)){
			ServicoNaoEncontradoException e = new ServicoNaoEncontradoException();
			throw e;
		}else{
			servicos.remover(ID);
		}
	}
	public static void updateServico(Servico servico) throws ServicoNaoEncontradoException{
		if(servicoExiste(servico.getID())){
			servicos.update(servico);
		}else{
			throw new ServicoNaoEncontradoException();
		}
	}
	public static double consultaPreco(String ID) throws ServicoNaoEncontradoException{
		ServicoNaoEncontradoException s = new ServicoNaoEncontradoException();
		if(servicos.exist(ID)){
			return servicos.consultaPreco(ID);
		}else{
			throw s;
		}
	}
	public static Servico buscarServico(String ID) throws ServicoNaoEncontradoException{
		ServicoNaoEncontradoException s = new ServicoNaoEncontradoException();
		if(servicos.exist(ID)){
			return servicos.buscar(ID);
		}else{
			throw s;
		}
	}
	public static boolean servicoExiste(String ID) throws ServicoNaoEncontradoException{
		ServicoNaoEncontradoException e = new ServicoNaoEncontradoException();
		if(servicos.exist(ID)){
			return true;
		}else{
			throw e;
		}
	}

}
