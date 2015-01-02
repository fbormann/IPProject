package excecoes;

public class ContaNaoExiste extends Exception {
	public ContaNaoExiste(){
		super("Essa conta nao existe.");
	}
}
