package excecoes;

public class ServicoNaoEncontrado extends Exception {

	public ServicoNaoEncontrado(){
		super("Esse servico nao esta cadastrado");
	}

}
