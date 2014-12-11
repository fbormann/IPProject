package entidades;

public class Endereco {
	private String rua;
	private int numero;
	private int complemento;
	private String CEP;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco(String rua, int numero, int complemento, String CEP, String bairro, String cidade, String estado){
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.CEP = CEP;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return this.rua;
	}

	public int getNumero() {
		return this.numero;
	}

	public int getComplemento() {
		return this.complemento;
	}

	public String getCEP() {
		return this.CEP;
	}

	public String getBairro() {
		return this.bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setComplemento(int complemento) {
		this.complemento = complemento;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString(){
		String r = "Endereço: " + this.rua + ", " + this.numero + ", " + this.CEP + ", " + this.bairro + ", " + this.cidade + ", " +
				this.cidade + ", " + this.estado;
		return r;
	}
}
