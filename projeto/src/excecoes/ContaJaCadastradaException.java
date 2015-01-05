package excecoes;

public class ContaJaCadastradaException extends Exception{
	
	public ContaJaCadastradaException(){
		super("Essa CPF ja esta cadastrado em outra conta");
	}
}
