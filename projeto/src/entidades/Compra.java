package entidades;

public class Compra {
	private String contaCPF;
	private double valor;
	private String id;
	private Servico[] servicos;
	
	public Compra(){

		this.servicos = new Servico[0];
		this.valor = 0;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Servico[] getServicos() {
		return servicos;
	}

	public void setServicos(Servico[] servicos) {
		this.servicos = servicos;
	}

	public String getContaCPF() {
		return contaCPF;
	}

	public void setContaCPF(String contaCPF) {
		this.contaCPF = contaCPF;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
