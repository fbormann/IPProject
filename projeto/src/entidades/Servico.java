package entidades;

public abstract class Servico {
	private String nome;
	private double preco;
	private String ID;
	private String codigo;
	
	public Servico(double preco, String ID, String codigo){
		this.preco = preco;
		this.ID = ID;
		this.codigo = codigo;
	}

	public abstract double comissao(double compra);
	
	public String getCodigo(){
		return this.codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getNome(){
		return this.nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public String getID() {
		return this.ID;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String toString(){
		String r = "Serviço: " + "\nNome: " + this.nome + "\nPreco: " + this.preco + "\nID: " + this.ID; 
		return r;
	}
	

}
