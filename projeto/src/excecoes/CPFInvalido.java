package excecoes;

public class CPFInvalido extends Exception{
	
	public CPFInvalido(String CPF){
		super("Formato do CPF errado. Digite com os devidos . e -");
	}

}
