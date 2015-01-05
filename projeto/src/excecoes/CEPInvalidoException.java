package excecoes;

public class CEPInvalidoException extends Exception {
	
	public CEPInvalidoException(String CEP){
		super("CEP esta no formato incorreto");
	}

}
