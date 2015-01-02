package dados;

import entidades.Servico;

public class ServicoRepositorioArray implements ServicoRepositorio{
	private Servico[] servicos;
	
	public ServicoRepositorioArray(){
		this.servicos = new Servico[0];
	}

	public void adicionar(Servico servico) {
		// TODO Auto-generated method stub
		
	}

	public void remover(String ID) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(String ID) {
		// TODO Auto-generated method stub
		
	}

	public double consultaPreco(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double consultaPrecoNome(String nome) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Servico[] listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Servico consulta(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
