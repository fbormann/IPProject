package excecoes;

public class CompraNaoExiste extends Exception{
	public CompraNaoExiste(){
		super("Essa compra nao existe");
	}
}
