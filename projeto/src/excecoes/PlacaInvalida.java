package excecoes;

public class PlacaInvalida extends Exception {
	
	public PlacaInvalida(String placa){
		super("Placa em formato inv�lido. Digite AAA-0000");
	}

}
