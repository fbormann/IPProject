package excecoes;

public class ContaJaCadastrada extends Exception{
	
	public ContaJaCadastrada(){
		super("Essa CPF ja esta cadastrado em outra conta");
	}
}
