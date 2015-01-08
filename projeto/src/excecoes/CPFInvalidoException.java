package excecoes;

public class CPFInvalidoException extends Exception{
	
	public CPFInvalidoException(){
		super("Formato do CPF errado. Digite com os devidos . e -");
	}

}
