package excecoes;

public class PlacaInvalidaException extends Exception {
	
	public PlacaInvalidaException(){
		super("Placa em formato inválido. Digite AAA-0000");
	}

}
