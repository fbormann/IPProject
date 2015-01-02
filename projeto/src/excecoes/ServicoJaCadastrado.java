package excecoes;

public class ServicoJaCadastrado extends Exception{
	public ServicoJaCadastrado(){
		super("Esse servico ja esta cadastrado");
	}
}
