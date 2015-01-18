package excecoes;

public class NenhumaCompraCadastradaException extends Exception{
	
	public NenhumaCompraCadastradaException(){
		super("Nao existe nenhuma compra cadastrada.");
	}

}
