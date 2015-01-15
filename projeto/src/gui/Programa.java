package gui;

import java.util.Scanner;

import entidades.Conta;
import entidades.Endereco;
import entidades.Carro;
import entidades.Lavagem;
import entidades.Otimizacao;
import entidades.Produto;
import entidades.Servico;
import excecoes.CEPInvalidoException;
import excecoes.CPFInvalidoException;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.PlacaInvalidaException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
import comunicacao.OficinaFacade;
import dados.RepositorioServicoArray;

//classe que irá testar todos os métodos da fachada(OficinaFacade)
public class Programa {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		RepositorioServicoArray r = new RepositorioServicoArray();

		OficinaFacade.inicializar();

		System.out.println("Menu: 1) Conta; 2) Servico; 3) Venda.");
		int escolhaMenu = in.nextInt();
		if(escolhaMenu==1){
			//CONTA
			System.out.println("Menu: 1) Cadastrar; 2) Remover; 3) Update; 4) Buscar.");
			int escolhaConta = in.nextInt();
			if(escolhaConta==1){
				System.out.println("Cadastre a conta do cliente:");
				System.out.print("Nome: ");
				String nome = str.nextLine();
				System.out.print("CPF: ");
				String CPF = str.nextLine();
				try {
					OficinaFacade.validadeCPF(CPF);
				} catch (CPFInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}				
				//endereço
				System.out.print("Rua: ");
				String rua = str.nextLine();
				System.out.print("Numero: ");
				int numero = in.nextInt();
				System.out.print("Complemento: ");
				String complemento = str.nextLine();
				System.out.print("CEP: ");
				String CEP = str.nextLine();
				try {
					OficinaFacade.validadeCEP(CEP);
				} catch (CEPInvalidoException e){
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}
				System.out.print("Bairro: ");
				String bairro = str.nextLine();
				System.out.print("Cidade: ");
				String cidade = str.nextLine();
				System.out.print("Estado: ");
				String estado = str.nextLine();
				Endereco endereco = new Endereco(rua, numero, complemento, CEP, bairro, cidade, estado);
				//carro
				System.out.print("Modelo: ");
				String modelo = str.nextLine();
				System.out.print("Marca: ");
				String marca = str.nextLine();
				System.out.print("Cor: ");
				String cor = str.nextLine();
				System.out.print("Placa: ");
				String placa = str.nextLine();
				try {
					OficinaFacade.validadePlaca(placa);
				} catch (PlacaInvalidaException e){
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}

				Carro carro = new Carro(modelo, marca, cor, placa);
				Conta conta = new Conta(nome, CPF, endereco, carro);

				try {
					OficinaFacade.adicionarConta(conta);
				} catch (ContaJaCadastradaException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
					//os proximos erros nao irao acontecer pois ja foram checados
				} catch (CPFInvalidoException e) {
					e.printStackTrace();
				} catch (CEPInvalidoException e) {
					e.printStackTrace();
				} catch (PlacaInvalidaException e) {
					e.printStackTrace();
				}

			}else if(escolhaConta==2){
				System.out.print("CPF da conta que você quer remover: ");
				String CPF = str.nextLine();
				try {
					OficinaFacade.removerConta(CPF);
				} catch (ContaNaoExisteException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (CPFInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}
			}else if(escolhaConta==3){
				System.out.print("CPF da conta que você quer atualizar: ");
				String CPF = str.nextLine();

				System.out.print("Nome: ");
				String nome = str.nextLine();
				//endereco
				System.out.print("Rua: ");
				String rua = str.nextLine();
				System.out.print("Numero: ");
				int numero = in.nextInt();
				System.out.print("Complemento: ");
				String complemento = str.nextLine();
				System.out.print("CEP: ");
				String CEP = str.nextLine();
				System.out.print("Bairro: ");
				String bairro = str.nextLine();
				System.out.print("Cidade: ");
				String cidade = str.nextLine();
				System.out.print("Estado: ");
				String estado = str.nextLine();
				Endereco endereco = new Endereco(rua, numero, complemento, CEP, bairro, cidade, estado);
				//carro
				System.out.print("Modelo: ");
				String modelo = str.nextLine();
				System.out.print("Marca: ");
				String marca = str.nextLine();
				System.out.print("Cor: ");
				String cor = str.nextLine();
				System.out.print("Placa: ");
				String placa = str.nextLine();
				Carro carro = new Carro(modelo, marca, cor, placa);
				Conta novaConta = new Conta(nome, CPF, endereco, carro);
				try {
					OficinaFacade.updateConta(novaConta);
				} catch (CPFInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (ContaNaoExisteException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (CEPInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (PlacaInvalidaException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}

			}else if(escolhaConta==4){
				String CPF = str.nextLine();
				System.out.print("CPF da conta que voce quer buscar: ");
				try {
					OficinaFacade.buscarConta(CPF);
				} catch (ContaNaoExisteException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (CPFInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}else if(escolhaMenu == 2){
			//SERVICO
			System.out.println("Menu: 1) Adicionar; 2) Remover; 3) Update; 4) Consultar preco; 5) Buscar.");
			int escolhaServico = in.nextInt();
			if(escolhaServico==1){
				System.out.print("Qual tipo de servico voce quer adicionar? 1) Lavagem; 2) Otimizacao; 3) Produto.");
				int escolhaTipo = in.nextInt();
				//nao podemos instanciar Servico por ela ser uma classe abstrata
				if(escolhaTipo == 1){
					System.out.print("Nome: ");
					String nome = str.nextLine();
					System.out.print("Preco: ");
					double preco = in.nextDouble();
					System.out.print("ID: ");
					String ID = str.nextLine();
					Lavagem servicoLavagem = new Lavagem(nome, preco, ID);
					try {
						OficinaFacade.adicionarServico(servicoLavagem);
					} catch (ServicoJaCadastradoException e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}


				}else if(escolhaTipo==2){
					System.out.print("Nome: ");
					String nome = str.nextLine();
					System.out.print("Preco: ");
					double preco = in.nextDouble();
					System.out.print("ID: ");
					String ID = str.nextLine();
					Otimizacao servicoOtimizacao = new Otimizacao(nome, preco, ID);
					try {
						OficinaFacade.adicionarServico(servicoOtimizacao);
					} catch (ServicoJaCadastradoException e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}

				}else if(escolhaTipo == 3){
					System.out.print("Nome: ");
					String nome = str.nextLine();
					System.out.print("Preco: ");
					double preco = in.nextDouble();
					System.out.print("ID: ");
					String ID = str.nextLine();
					Produto servicoProduto = new Produto(nome, preco, ID);
					try {
						OficinaFacade.adicionarServico(servicoProduto);
					} catch (ServicoJaCadastradoException e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}

				}
			}else if(escolhaServico == 2){
				System.out.print("Digite o ID do servico que voce quer remover: ");
				String ID = str.nextLine();
				try {
					OficinaFacade.removerServico(ID);
				} catch (ServicoNaoEncontradoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}
			}else if(escolhaServico == 3){
				System.out.println("Que servico voce quer atualizar? 1) Lavagem; 2) Otimizacao; 3) Produto");
				int escolhaAtualizar = in.nextInt();
				if(escolhaAtualizar == 1){
					System.out.print("Nome: ");
					String nome = str.nextLine();
					System.out.print("Preco: ");
					double preco = in.nextDouble();
					System.out.print("ID: ");
					String ID = str.nextLine();
					Lavagem servicoLavagem = new Lavagem(nome, preco, ID);
					try {
						OficinaFacade.adicionarServico(servicoLavagem);
					} catch (ServicoJaCadastradoException e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}

				}else if(escolhaAtualizar == 2){
					System.out.print("Nome: ");
					String nome = str.nextLine();
					System.out.print("Preco: ");
					double preco = in.nextDouble();
					System.out.print("ID: ");
					String ID = str.nextLine();
					Otimizacao servicoOtimizacao = new Otimizacao(nome, preco, ID);
					try {
						OficinaFacade.adicionarServico(servicoOtimizacao);
					} catch (ServicoJaCadastradoException e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}
				}else if (escolhaAtualizar == 3){
					System.out.print("Nome: ");
					String nome = str.nextLine();
					System.out.print("Preco: ");
					double preco = in.nextDouble();
					System.out.print("ID: ");
					String ID = str.nextLine();
					Produto servicoProduto = new Produto(nome, preco, ID);
					try {
						OficinaFacade.adicionarServico(servicoProduto);
					} catch (ServicoJaCadastradoException e) {
						System.out.println("Erro: " + e.getMessage());
						e.printStackTrace();
					}
				}
			}else if(escolhaServico == 4){
				System.out.print("Digite o ID do servico: ");
				String ID = str.nextLine();
				try {
					OficinaFacade.consultaPreco(ID);
				} catch (ServicoNaoEncontradoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}
			}else if(escolhaServico == 5){
				System.out.print("Digite o ID do servico que voce quer buscar: ");
				String ID = str.nextLine();
				try {
					OficinaFacade.buscarServico(ID);
				} catch (ServicoNaoEncontradoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}
			}

		}else if(escolhaMenu == 3){
			System.out.print("CPF: ");
			String CPF = str.nextLine();
			try {
				OficinaFacade.contaExiste(CPF);
			} catch (ContaNaoExisteException e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			} catch (CPFInvalidoException e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}

			Servico[] aux = OficinaFacade.servicosArray.listar();
			for(int i = 0; i < aux.length; i++ ){
				System.out.println(i + " - " + aux[i].getNome());
			}
			
			RepositorioServicoArray comprados = new RepositorioServicoArray();

			System.out.println("Escolha o servico. (Digite 'exit' caso nao queira adicionar mais servicos): ");
			String escolhaServico = str.nextLine();
			int a = Integer.parseInt(escolhaServico);
			
			while(!escolhaServico.equals("exit")){
				try {
					comprados.adicionar(aux[a]);
				} catch (ServicoJaCadastradoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
}
