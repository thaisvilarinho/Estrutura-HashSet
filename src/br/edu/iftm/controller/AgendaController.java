package br.edu.iftm.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import br.edu.iftm.model.Pessoa;

public class AgendaController {

	static Scanner ler = new Scanner(System.in);
	static Set<Pessoa>agenda = new HashSet<Pessoa>();
	
	public static String adicionandoPessoa(Pessoa p1) {

		if (!agenda.contains(p1)) {
		
		agenda.add(p1);
		return p1.getNome() + " adicionado com sucesso";
		
		}else {
		return "Esse contato " + p1.getNome() + " já está em sua agenda";
		}
	}
	
	public static String listarPessoas() {
		if (agenda.isEmpty()) {
			System.out.println("Nao existe nenhum contato na sua agenda");
			return null;
		}
		return agenda.toString();	
	}
	
	public static Pessoa retornarPessoa(int id, String nome, String numero) {
		if(agenda.isEmpty()) {
			System.out.println("Não existe nenhum contato na sua agenda!");
		}else {
			if (id != 0) {
				for(Iterator<Pessoa> iter = agenda.iterator(); iter.hasNext();) {
					Pessoa pessoa2 = iter.next();
					if(id == pessoa2.getId()) {
						return pessoa2;
					}
				}
			}else if (nome != null) {
				for(Iterator<Pessoa> iter = agenda.iterator(); iter.hasNext();) {
					Pessoa pessoa2 = iter.next();
					if(nome.equals(pessoa2.getNome())) {
						return pessoa2;
					}
				}
			}else if (numero != null) {
				for(Iterator<Pessoa> iter = agenda.iterator(); iter.hasNext();) {
					Pessoa pessoa2 = iter.next();
					if(numero.equals(pessoa2.getNumero())) {
						return pessoa2;
					}
				}
			}
		}
		return null;
	}	
	
	public static String removePessoa(int id) {
		String nomeDaPessoaRemovida;
		Pessoa pessoa2 = retornarPessoa(id, null, null);
		nomeDaPessoaRemovida = pessoa2.getNome();
		agenda.remove(pessoa2);
		return nomeDaPessoaRemovida + " removida da agenda";
		}

	public static String alteraInformacao(int id) throws IOException {
		String nome;
		String numero;
		String endereco;
		String email;
		
		Pessoa pessoa2 = retornarPessoa(id, null, null);
		if (pessoa2 == null) {
			return "Não existe contato com esse id na sua agenda";
		}else {
			int opcaoMenuDeAlteracao = menuDeAlteraCao();
			
			if (opcaoMenuDeAlteracao == 0) {
				return "";
			}
    	 	if(opcaoMenuDeAlteracao == 1) {
    	 		System.out.println("Nome: ");
    	 		nome = ler.next();
    	 		pessoa2.setNome(nome);
    	 	}else if(opcaoMenuDeAlteracao == 2) {
    	 		System.out.println("Numero: ");
    	 		numero = ler.next();
    	 		pessoa2.setNumero(numero);
    	 	}else if(opcaoMenuDeAlteracao == 3) {
    	 		System.out.println("Endereço: ");
    	 		endereco = ler.next();
    	 		pessoa2.setEndereco(endereco);
    	 	}else if(opcaoMenuDeAlteracao == 4) {
    	 		System.out.println("E-mail: ");
    	 		email = ler.next();
    	 		pessoa2.setEmail(email);
    	 	}
		}
		return "Contato atualizado na sua agenda";
	}
	
	
	public static int menuDeAlteraCao() {
		int opcao = 0;
		do {
    		System.out
			.println("\n\n                        ### AGENDA  ###");
			System.out.println("\n    ===========================");
			System.out.println("    |     1 - Alterar nome     |");
			System.out.println("    |     2 - Alterar numero   |");
			System.out.println("    |     3 - Alterar endereço |");
			System.out.println("    |     4 - Alterar e-mail   |");
			System.out.println("    |     0 - Sair             |");
			System.out.println("    ===========================\n");
			System.out.print("\nOpção -> ");
			opcao = ler.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				return 1;
				
			case 2:
				return 2;
				
			case 3:
				return 3;
			
			case 4:
				return 4;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
		return opcao;
	}
	
	public static String pesquisaInformacao() {
		int id = 0;
		String nome = null;
		String numero = null;
		
		int opcaoMenuDePesquisa = menuDePesquisa();
		listarPessoas();
		
		if(opcaoMenuDePesquisa == 0) {
			return "";	
		}else if (opcaoMenuDePesquisa == 1) {
	 		System.out.println("Informe o Id do contato: ");
	 		id = ler.nextInt();
		}else if (opcaoMenuDePesquisa == 2) {
	 		System.out.println("Informe o nome do contato: ");
	 		nome = ler.next();
		}else if (opcaoMenuDePesquisa == 3) {
	 		System.out.println("Informe o número do contato: ");
	 		numero = ler.next();
		}
		
		Pessoa pessoa2 = retornarPessoa(id, nome, numero);
		if (pessoa2 == null && id != 0) {
			return "Não existe contato com esse id na sua agenda";
		}else if (pessoa2 == null && nome != null) {
			return "Não existe contato com esse nome na sua agenda";
		}
		return pessoa2.toString();
	}
	public static int menuDePesquisa() {
		int opcao = 0;
		do {
    		System.out
			.println("\n\n                        ### AGENDA  ###");
			System.out.println("\n    ===============================");
			System.out.println("    |     1 - Pesquisar com id       |");
			System.out.println("    |     2 - Pesquisar com nome     |");
			System.out.println("    |     3 - Pesquisar com número   |");
			System.out.println("    |     0 - Sair                   |");
			System.out.println("    ===============================\n");
			System.out.print("\nOpção -> ");
			opcao = ler.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				return 1;
				
			case 2:
				return 2;
			case 3:
				return 3;

			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
		return opcao;
	}
}
