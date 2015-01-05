package comunicacao;

import dados.RepositorioComprasArray;
import entidades.Compra;
import entidades.Conta;
import excecoes.CEPInvalidoException;
import excecoes.ContaJaCadastradaException;
import excecoes.PlacaInvalida;
import negocios.*;

public class Oficina {
	private CadastroCompras compras;
	private CadastroConta contas;
	private CadastroServico servicos;
	private RepositorioComprasArray comprasArray;
	
	
	public Oficina(){
		comprasArray = new RepositorioComprasArray();
		this.compras = new CadastroCompras(comprasArray);
	}
	
	public void adicionarCompra(Compra compra){
		if(!this.compras.exist(compra.getId())){
			compras.cadastrarCompra(compra);
		}else{
			//TODO: implementar a logica por 
		}
		
		this.compras.cadastrarCompra(compra);
	}
	
	public void adicionarConta(Conta conta){
		if(!this.contas.exist(conta.getCPF())){
			try {
				this.contas.cadastrar(conta);
			} catch (ContaJaCadastradaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //TODO devo usar try catch aqui na camada de fachada ou na propria GUI?
		}else{
			//TODO: Implementar acoes contra.
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
}
