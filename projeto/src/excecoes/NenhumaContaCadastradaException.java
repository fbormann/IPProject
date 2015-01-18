package excecoes;

public class NenhumaContaCadastradaException extends Exception {
	
	public NenhumaContaCadastradaException(){
		super("Nao existe nenhuma conta cadastrada.");
	}

}
