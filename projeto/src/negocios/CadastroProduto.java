package negocios;
import entidades.Servico;
import excecoes.ServicoJaCadastrado;
import excecoes.ServicoNaoEncontrado;
import dados.ServicoRepositorio;
public class CadastroProduto {
	
	private ServicoRepositorio produtos;
	
	public CadastroProduto(ServicoRepositorio produtos){
		this.produtos = produtos;
	}
	public void cadastrar(Servico servico) throws ServicoJaCadastrado{
		produtos.adicionar(servico);
	}
	public void remover(String ID) throws ServicoNaoEncontrado{
		produtos.remover(ID);
	}
	public double consultaPreco(String ID){
		return produtos.consultaPreco(ID);
	}
	public double consultaPrecoNome(String nome){
		return produtos.consultaPrecoNome(nome);
	}
	public Servico consulta(String ID){
		return produtos.consulta(ID);
	}

}
