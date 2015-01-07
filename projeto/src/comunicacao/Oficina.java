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
import excecoes.PlacaInvalida;
import excecoes.ServicoNaoEncontradoException;
import negocios.*;

public class Oficina {
	private ManagerCompras compras;
	private ManagerConta contas;
	private ManagerServico servicos;
	private RepositorioComprasArray comprasArray;
	private RepositorioServicoArray servicoArray;
	private RepositorioContasArray contasArray;
	
	
	public Oficina(){
		comprasArray = new RepositorioComprasArray();
		this.compras = new ManagerCompras(comprasArray);
		this.servicoArray = new RepositorioServicoArray();
		this.contasArray = new RepositorioContasArray();
		this.servicos = new ManagerServico(servicoArray);
		this.contas = new ManagerConta(contasArray);
		
	
	}
	
	//VENDA
	public void adicionarCompra(Compra compra) {

		if(!this.compras.exist(compra.getId())){
			compras.cadastrarCompra(compra);
		}else{
			
		}
		
		this.compras.cadastrarCompra(compra);
	}
	public boolean compraExiste(String ID) throws CompraNaoExisteException{
		CompraNaoExisteException e = new CompraNaoExisteException();
		if(this.compras.exist(ID)){
			return true;
		}else{
			throw e;
		}
	}

	//CLIENTE
	public void adicionarConta(Conta conta) throws ContaJaCadastradaException{
		if(!this.contas.exist(conta.getCPF())){
				this.contas.cadastrar(conta);
		}else{
		
		}
	}
	public boolean validadeCPF(String CPF) throws CPFInvalidoException{
		CPFInvalidoException e = new CPFInvalidoException(CPF);
		//checar tamanho
		if(CPF.length()!=14){
			throw e;
		}else{
			//checar se há somente números
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
	public boolean validadeCEP(String CEP) throws CEPInvalidoException{
		CEPInvalidoException e = new CEPInvalidoException(CEP);
		//checar tamanho
		if(CEP.length()!=9){
			throw e;
			//checando se há somente números
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
	public boolean validadePlaca(String placa) throws PlacaInvalida{
		PlacaInvalida a = new PlacaInvalida(placa);
		//checar tamanho
		if(placa.length()!=8){
			throw a;
			//checando se há numeros onde deve haver números
		}else{
			for(int i = 0; i <placa.length(); i++){
				if(i>=4){
					if(placa.charAt(i)>=48 && placa.charAt(i)<=57){
						return true;
					}else{
						throw a;
					}
				}
				//checando se há letras onde deve haver letras
				if(i<=2){
					if(placa.charAt(i)>=65 && placa.charAt(i)<=90){
						return true;
					}else{
						throw a;
					}
				}
			}
			//checando se o hifen está na posicao correta
			String exemploPlaca = "AAA-0000";
			int c = exemploPlaca.charAt(3);
			if(c == 45){
				return true;
			}else{
				throw a;
			}

		}
	}
	public Conta buscarCliente(String CPF) throws ContaNaoExisteException{
		ContaNaoExisteException s = new ContaNaoExisteException();
		if(this.contas.exist(CPF)){
			return this.contas.buscar(CPF);
		}else{
			throw s;
		}
	}
	//TODO: validadeCPF/validadeCEP/validadePlaca para adicionarConta && removerCliente(CPF existe?)
	
	//SERVICO
	//TODO: adicionarServico && removerServico(ID existe?)
	public double consultaPreco(String ID) throws ServicoNaoEncontradoException{
		ServicoNaoEncontradoException s = new ServicoNaoEncontradoException();
		if(this.servicos.exist(ID)){
			return this.servicos.consultaPreco(ID);
		}else{
			throw s;
		}
	}
	public double consultaPrecoNome(String nome) throws ServicoNaoEncontradoException{
		ServicoNaoEncontradoException s = new ServicoNaoEncontradoException();
		if(this.servicos.exist(nome)){
			return this.servicos.consultaPrecoNome(nome);
		}else{
			throw s;
		}
	}
	public Servico consulta(String ID) throws ServicoNaoEncontradoException{
		ServicoNaoEncontradoException s = new ServicoNaoEncontradoException();
		if(this.servicos.exist(ID)){
			return this.servicos.consulta(ID);
		}else{
			throw s;
		}
	}
	public boolean existServico(String ID) throws ServicoNaoEncontradoException{
		ServicoNaoEncontradoException e = new ServicoNaoEncontradoException();
		if(this.servicos.exist(ID)){
			return true;
		}else{
			throw e;
		}
	}
	
	
	
	
}
