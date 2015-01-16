package excecoes;

public class ContaJaCadastradaException extends Exception{
	
	public ContaJaCadastradaException(){
		super("Esse CPF ja esta cadastrado em outra conta");
	}
}
