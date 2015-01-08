package excecoes;

public class CEPInvalidoException extends Exception {
	
	public CEPInvalidoException(){
		super("CEP esta no formato incorreto");
	}

}
