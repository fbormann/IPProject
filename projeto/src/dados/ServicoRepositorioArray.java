package dados;

import entidades.Servico;

public class ServicoRepositorioArray implements ServicoRepositorio{
	private Servico[] servicos;
	
	public ServicoRepositorioArray(){
		this.servicos = new Servico[0];
	}

	public void adicionar(Servico servico) {
		Servico[] aux = new Servico[this.servicos.length+1];
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
