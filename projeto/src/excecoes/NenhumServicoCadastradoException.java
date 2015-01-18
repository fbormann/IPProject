package excecoes;

public class NenhumServicoCadastradoException extends Exception {

	public NenhumServicoCadastradoException(){
		super("Nao existe nenhum servico cadastrado.");
	}
}
