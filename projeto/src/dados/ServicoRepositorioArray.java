package dados;

import entidades.Servico;
import excecoes.ServicoJaCadastrado;

public class ServicoRepositorioArray implements ServicoRepositorio{
	private Servico[] servicos;
	
	public ServicoRepositorioArray(){
		this.servicos = new Servico[0];
	}

	public void adicionar(Servico servico) throws ServicoJaCadastrado {
		Servico[] aux = new Servico[this.servicos.length+1];
		for(int i = 0; i < this.servicos.length;i++){
			if(this.servicos[i].getID().equals(servico.getID())){
				throw new ServicoJaCadastrado();
			}else{
				aux[i] = this.servicos[i];
			}
		}
		
		aux[aux.length-1] = servico;
		
	}

	public void remover(String ID) {
		
	}

	public void atualizar(String ID) {
		
	}

	public double consultaPreco(String ID) {
		return 0;
	}

	public double consultaPrecoNome(String nome) {
		return 0;
	}

	public Servico[] listar() {
		return null;
	}

	public Servico consulta(String ID) {
		return null;
	}
	
	

}
