package excecoes;

public class ServicoJaCadastrado extends Exception{
	public ServicoJaCadastrado(){
		super("Esse serviço já está cadastrado");
	}
}
