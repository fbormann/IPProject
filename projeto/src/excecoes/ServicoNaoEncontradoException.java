package excecoes;

public class ServicoNaoEncontradoException extends Exception {

	public ServicoNaoEncontradoException(){
		super("Esse servico nao esta cadastrado");
	}

}
