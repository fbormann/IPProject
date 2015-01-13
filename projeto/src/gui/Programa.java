package gui;

import java.util.Scanner;

import entidades.Conta;
import entidades.Endereco;
import entidades.Carro;
import entidades.Servico;
import excecoes.CEPInvalidoException;
import excecoes.CPFInvalidoException;
import excecoes.ContaJaCadastradaException;
import excecoes.ContaNaoExisteException;
import excecoes.PlacaInvalidaException;
import comunicacao.OficinaFacade;

//classe que irá testar todos os métodos da fachada(OficinaFacade)
public class Programa {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);

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
				//endereço
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

				try {
					OficinaFacade.adicionarConta(conta);
				} catch (ContaJaCadastradaException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (CPFInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (CEPInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
					e.printStackTrace();
				} catch (PlacaInvalidaException e) {
					System.out.println("Erro: " + e.getMessage());
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
				System.out.print("Qual tipo de servico voce quer adicionar? 1) Lavagem; 2) Otimizacao; 3) Produto");
			}

		}
	}
}
