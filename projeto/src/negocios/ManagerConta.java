package negocios;
import java.util.Iterator;

import dados.RepositorioContas;
import entidades.Conta;
import excecoes.CEPInvalidoException;
import excecoes.CPFInvalidoException;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.NenhumaContaCadastradaException;
import excecoes.PlacaInvalidaException;

public class ManagerConta {
	private RepositorioContas contas;

	public ManagerConta(RepositorioContas contas){
		this.contas = contas;
	}

	public void cadastrar(Conta conta) throws ContaJaCadastradaException{
		if(this.contas.exist(conta.getCPF())){
			throw new ContaJaCadastradaException();
		}else{
			this.contas.adicionar(conta);
		}
	}

	public void remover(String CPF) throws ContaNaoExisteException{
		if(this.contas.exist(CPF)){
			this.contas.remover(CPF);
		}else{
			throw new ContaNaoExisteException();
		}
	}

	public Conta buscar(String CPF) throws ContaNaoExisteException{
		Conta c = new Conta();
		if(this.contas.exist(CPF)){
			c = this.contas.buscar(CPF);
		}else{
			throw new ContaNaoExisteException();
		}
		return c;
	}

	public boolean exist(String CPF) {
		return this.contas.exist(CPF);
	}

	public void update(Conta conta) throws ContaNaoExisteException{
		if(this.contas.exist(conta.getCPF())){
			this.contas.update(conta);
		}else{
			throw new ContaNaoExisteException();
		}
	}
	
	public Iterator<Conta> iterator(){
		return this.contas.iterator();
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
					if(CPF.charAt(i)<48 && CPF.charAt(i)>57){
						throw e;
					}
				}
			}

			int a = CPF.charAt(3);
			int b = CPF.charAt(7);
			int c = CPF.charAt(11);
			if(a == 46 && b == 46 && c == 45){
				return true;
			}else{
				throw e;
			}

		}
	}
	public static boolean validadeCEP(String CEP) throws CEPInvalidoException{
		CEPInvalidoException e = new CEPInvalidoException();
		boolean resultado = true;
		//checar tamanho
		if(CEP.length() != 9){
			throw e;
			//checando se h� somente n�meros
		}else{
			for(int i = 0; i<CEP.length(); i++){
				if(i!=5){
					if(CEP.charAt(i)<48 && CEP.charAt(i)>57){
						throw e;
					}
				}
			}
			int a = CEP.charAt(5);
			if(a != 45){
				throw e;
			}
		}

		return resultado;
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
	
	
}
