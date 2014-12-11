package entidades;

public class Conta {
	private String nome;
	private String CPF;
	private Endereco endereco;
	private Carro carro;
	
	public Conta(String nome, String CPF, Endereco endereco, Carro carro){
		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
		this.carro = carro;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCPF() {
		return this.CPF;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public String toString(){
		String r = "Nome: " + this.nome + "\nCPF: " + this.CPF + "\nEndereco: " + "\nRua: " + this.endereco.getRua() + "\nNumero: " +
				this.endereco.getNumero() + "\t" + this.endereco.getComplemento() + "\nCEP: " + this.endereco.getCEP() + "\nBairro: " +
				this.endereco.getBairro() + "\nCidade: " + this.endereco.getCidade() + "\nEstado: " + this.endereco.getEstado();
		return r;
	}
}
