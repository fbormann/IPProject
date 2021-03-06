package gui;

import java.util.Iterator;
import java.util.Scanner;

import entidades.Compra;
import entidades.Conta;
import entidades.Endereco;
import entidades.Carro;
import entidades.Lavagem;
import entidades.Otimizacao;
import entidades.Produto;
import entidades.Servico;
import excecoes.CEPInvalidoException;
import excecoes.CPFInvalidoException;
import excecoes.CompraNaoExisteException;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.PlacaInvalidaException;
import excecoes.ServicoJaCadastradoException;
import excecoes.ServicoNaoEncontradoException;
import excecoes.TipoNaoSelecionadoException;
import comunicacao.OficinaFacade;
import dados.RepositorioServicoArray;


public class Programa {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);

		OficinaFacade.inicializar("lista");

		int escolhaMenu;
		int escolhaConta;
		int escolhaServico;
		int escolhaTipo;
		int escolhaCompra;

		System.out.println("Bem-vindo!");

		do{
			System.out.println("Menu: 1) Conta; 2) Servico; 3) Venda; 4) Sair");
			escolhaMenu = in.nextInt();

			if(escolhaMenu==1){
				//CONTA

				do{
					System.out.println("Menu Conta: 1) Cadastrar; 2) Remover; 3) Update; 4) Buscar; 5) Exit");
					escolhaConta = in.nextInt();
					if(escolhaConta==1){
						System.out.println("Cadastre a conta do cliente:");
						System.out.print("Nome: ");
						String nome = str.nextLine();
						System.out.print("CPF: ");
						String CPF = str.nextLine();				
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
						Conta conta = new Conta(nome, CPF, endereco, carro);

						try{
							OficinaFacade.adicionarConta(conta);
						}catch(ContaJaCadastradaException e){
							System.out.println("Erro: " + e.getMessage());
							e.printStackTrace();
						}catch(CEPInvalidoException e1){
							System.out.println("Erro: " + e1.getMessage());
							e1.printStackTrace();
						}catch(CPFInvalidoException e2){
							System.out.println("Erro: " + e2.getMessage());
							e2.printStackTrace();
						}catch(PlacaInvalidaException e3){
							System.out.println("Erro: " + e3.getMessage());
							e3.printStackTrace();
						}

					}else if(escolhaConta==2){
						System.out.print("CPF da conta que voce quer remover: ");
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
						System.out.print("CPF da conta que voce quer atualizar: ");
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
						System.out.print("CPF da conta que voce quer buscar: ");
						String CPF = str.nextLine();
						try {
							System.out.println(OficinaFacade.buscarConta(CPF));
						} catch (ContaNaoExisteException e) {
							System.out.println("Erro: " + e.getMessage());
							e.printStackTrace();
						} catch (CPFInvalidoException e) {
							System.out.println("Erro: " + e.getMessage());
							e.printStackTrace();
						}
					}
				}while(escolhaConta!=5);

				//SERVICO
			}else if(escolhaMenu == 2){
				do{
					System.out.println("Menu Servico: 1) Adicionar; 2) Remover; 3) Update; 4) Consultar preco; 5) Buscar; 6) Exit.");
					escolhaServico = in.nextInt();
					if(escolhaServico==1){
						System.out.println("Qual tipo de servico voce quer adicionar? 1) Lavagem; 2) Otimizacao; 3) Produto.");
						escolhaTipo = in.nextInt();
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
							} catch (TipoNaoSelecionadoException e) {
								//essa excecao nao vai ocorrer pois funcionara apenas na GUI
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
							} catch (TipoNaoSelecionadoException e) {
								//essa excecao nao vai ocorrer pois funcionara apenas na GUI
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
							} catch (TipoNaoSelecionadoException e) {
								//essa excecao nao vai ocorrer pois funcionara apenas na GUI
								e.printStackTrace();
							}

						}else if(escolhaTipo >= 4){
							System.out.println("Escolha uma das opcoes abaixo (1 a 3)");
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
							System.out.print("ID do servico que voce quer atualizar: ");
							String IDbuscar = str.nextLine();

							try {
								System.out.println(OficinaFacade.buscarServico(IDbuscar));
							} catch (ServicoNaoEncontradoException e1) {
								System.out.println("Erro: " + e1.getMessage());
								e1.printStackTrace();
							}

							System.out.print("Nome: ");
							String nome = str.nextLine();
							System.out.print("Preco: ");
							double preco = in.nextDouble();
							Lavagem servicoLavagem = new Lavagem(nome, preco, IDbuscar);

							try {
								OficinaFacade.updateServico(servicoLavagem);
							} catch (ServicoNaoEncontradoException e) {
								System.out.print("Erro: " + e.getMessage());
								e.printStackTrace();
							}

						}else if(escolhaAtualizar == 2){
							System.out.print("ID do servico que voce quer atualizar: ");
							String IDBuscar = str.nextLine();

							try {
								System.out.println(OficinaFacade.buscarServico(IDBuscar));
							} catch (ServicoNaoEncontradoException e1) {
								System.out.println("Erro: " + e1.getMessage());
								e1.printStackTrace();
							}

							System.out.print("Nome: ");
							String nome = str.nextLine();
							System.out.print("Preco: ");
							double preco = in.nextDouble();

							Otimizacao servicoOtimizacao = new Otimizacao(nome, preco, IDBuscar);
							try {
								OficinaFacade.updateServico(servicoOtimizacao);
							} catch (ServicoNaoEncontradoException e) {
								System.out.print("Erro: " + e.getMessage());
								e.printStackTrace();
							}

						}else if (escolhaAtualizar == 3){
							System.out.print("ID do servico que voce quer atualizar: ");
							String IDBuscar = str.nextLine();

							try {
								System.out.println(OficinaFacade.buscarServico(IDBuscar));
							} catch (ServicoNaoEncontradoException e1) {
								System.out.println("Erro: " + e1.getMessage());
								e1.printStackTrace();
							}

							System.out.print("Nome: ");
							String nome = str.nextLine();
							System.out.print("Preco: ");
							double preco = in.nextDouble();

							Produto servicoProduto = new Produto(nome, preco, IDBuscar);

							try {
								OficinaFacade.updateServico(servicoProduto);
							} catch (ServicoNaoEncontradoException e) {
								System.out.print("Erro: " + e.getMessage());
								e.printStackTrace();
							}
						}else if(escolhaAtualizar >= 4){
							System.out.println("Escolha uma das opcoes abaixo");
						}
					}else if(escolhaServico == 4){
						System.out.print("Digite o ID do servico: ");
						String ID = str.nextLine();
						try {
							System.out.println(OficinaFacade.consultaPreco(ID));
						} catch (ServicoNaoEncontradoException e) {
							System.out.println("Erro: " + e.getMessage());
							e.printStackTrace();
						}
					}else if(escolhaServico == 5){
						System.out.print("Digite o ID do servico que voce quer buscar: ");
						String ID = str.nextLine();
						try {
							System.out.println(OficinaFacade.buscarServico(ID));
						} catch (ServicoNaoEncontradoException e) {
							System.out.println("Erro: " + e.getMessage());
							e.printStackTrace();
						}
					}
				}while(escolhaServico!=6);		

				//COMPRA
				//TODO: falta testar o buscar compra (pra isso, falta colocar o ID da compra)
			}else if(escolhaMenu == 3){
				do{
					System.out.println("Menu Compra: 1) Adicionar; 2) Remover; 3) Update; 4) Buscar; 5) Exit.");
					escolhaCompra = in.nextInt();

					if(escolhaCompra==1){
						System.out.print("CPF: ");
						String CPF = str.nextLine();

						try {
							OficinaFacade.contaExiste(CPF);
						} catch (CPFInvalidoException e1) {
							System.out.println("Erro: " + e1.getMessage());
							e1.printStackTrace();
						}

						Servico[] aux = new Servico[0];
						for(Iterator<Servico> itr = OficinaFacade.servicoIterator(); itr.hasNext();){
							Servico[] aux2 = new Servico[aux.length+1];
							for(int i = 0; i < aux.length;i++){
								aux2[i] = aux[i]; 
							}

							aux2[aux2.length-1] = itr.next();
							aux = aux2;
						}
						for(int i = 0; i < aux.length; i++ ){
							System.out.println(i + " - " + aux[i].getNome());
						}

						RepositorioServicoArray comprados = new RepositorioServicoArray();

						System.out.println("Escolha o servico. (Digite 'exit' caso nao queira adicionar mais servicos): ");
						String eServico;
						do{
							eServico = str.nextLine();
							if(!eServico.equalsIgnoreCase("exit")){ //para ter certeza que o programa nao vai querer passar 'exit' pra inteiro
								int b = Integer.parseInt(eServico);
								comprados.adicionar(aux[b]);	
							}
						}while(!eServico.equalsIgnoreCase("exit"));

					}else if(escolhaCompra==2){
						System.out.print("Digite o ID da compra que voce quer remover: ");
						String idRemover = str.nextLine();

						try {
							OficinaFacade.removerCompra(idRemover);
						} catch (CompraNaoExisteException e) {
							System.out.println("Erro: " + e.getMessage());
							e.printStackTrace();
						}

					}else if(escolhaCompra==3){
						System.out.print("Digite o ID da compra que voce quer atualizar: ");
						String idAtualizar = str.nextLine();
						if(OficinaFacade.compraExiste(idAtualizar)){
							System.out.print("Digite o novo valor da compra: ");
							double novoValor = in.nextDouble();
							Compra novaCompra = new Compra(novoValor);
							try {
								OficinaFacade.updateCompra(novaCompra);
							} catch (CompraNaoExisteException e) {
								System.out.println("Erro: " + e.getMessage());
								e.printStackTrace();
							}
						}else{
							System.out.println("Essa compra nao existe!");
						}

					}else if(escolhaCompra==4){
						System.out.print("Digite o ID da compra que voce quer buscar: ");
						String idBuscar = str.nextLine();
						try {
							OficinaFacade.buscarCompra(idBuscar);
						} catch (CompraNaoExisteException e) {
							System.out.println("Erro: " + e.getMessage());
							e.printStackTrace();
						}
					}
				}while(escolhaCompra!=5);
			}
		}while(escolhaMenu!=4);
		
		in.close();
		str.close();
	}
}



