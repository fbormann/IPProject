package excecoes;

public class ServicoJaCadastradoException extends Exception{
	public ServicoJaCadastradoException(){
		super("Esse servico ja esta cadastrado");
	}
}
