package negocios;
import entidades.Servico;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
import dados.ServicoRepositorio;
public class CadastroProduto {
	
	private ServicoRepositorio produtos;
	
	public CadastroProduto(ServicoRepositorio produtos){
		this.produtos = produtos;
	}
	public void cadastrar(Servico servico) throws ServicoJaCadastradoException{
		produtos.adicionar(servico);
	}
	public void remover(String ID) throws ServicoNaoEncontradoException{
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
