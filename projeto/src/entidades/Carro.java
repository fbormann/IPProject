package entidades;

public class Carro {
	private String modelo;
	private String marca;
	private String cor;
	private String placa;
	
	public Carro(String modelo, String marca, String cor, String placa){
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.placa = placa;
	}
	
	public Carro(){
		
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getCor() {
		return this.cor;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String toString(){
		String r = "Carro: " + "\nModelo: " + this.modelo + "\nMarca: " + this.marca + "\nCor: " + this.cor + "\nPlaca: " + this.placa;
		return r;
	}	
}
