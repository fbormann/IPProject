package exceções;

public class ContaJaCadastrada extends Exception{
	
	public ContaJaCadastrada(){
		super("Essa CPF já está cadastrado em outra conta");
	}
}
