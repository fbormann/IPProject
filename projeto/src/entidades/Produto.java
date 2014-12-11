package entidades;

public class Produto {
	private String nome;
	private String codigo;
	private double preco;
	
	public Produto(String nome, String codigo, double preco){
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String toString(){
		String r = "Produto: " + "\nNome: " + this.nome + "\nCodigo: " + this.codigo + "\nPreço: " + this.preco;
		return r;
	}

}
