package excecoes;
//excecao que vai ser jogada quando o usuario escolher mais de um tipo pra o mesmo servico
public class TiposSelecionadosException extends Exception{
	
	public TiposSelecionadosException(){
		super("Selecione apenas um tipo para o servico");
	}

}
