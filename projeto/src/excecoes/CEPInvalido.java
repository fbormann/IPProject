package excecoes;

public class CEPInvalido extends Exception {
	
	public CEPInvalido(String CEP){
		super("CEP esta no formato incorreto");
	}

}
