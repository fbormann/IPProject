package exceções;

public class ServicoNaoEncontrado extends Exception {

	public ServicoNaoEncontrado(){
		super("Esse serviço não está cadastrado");
	}

}
