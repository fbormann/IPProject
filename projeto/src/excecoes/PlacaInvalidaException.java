package excecoes;

public class PlacaInvalidaException extends Exception {
	
	public PlacaInvalidaException(){
		super("Placa em formato inv�lido. Digite AAA-0000");
	}

}
