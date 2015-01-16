package excecoes;

public class TipoNaoSelecionadoException extends Exception{
	
	public TipoNaoSelecionadoException(){
		super("Selecione o tipo do serviço");
	}

}
