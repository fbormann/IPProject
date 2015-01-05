package excecoes;

public class CompraNaoExisteException extends Exception{
	public CompraNaoExisteException(){
		super("Essa compra nao existe");
	}
}
