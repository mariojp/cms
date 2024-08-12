
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	
	
    public static void main(String[] args) {
        List<Conteudo> conteudos = new ArrayList<Conteudo>();
        Scanner scanner = new Scanner(System.in);
        Usuario currentUser = null;
        int count = 1;

        while (true) {
            if (currentUser == null) {
                System.out.println("1. Entrar");
                System.out.println("2. Listar Conteudo");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    System.out.print("Digite o username: ");
                    String username = scanner.nextLine();
                    System.out.print("Digite o password: ");
                    String password = scanner.nextLine();
                    if (username.equals(password)) {
                    	currentUser =  new Usuario();
                    	currentUser.username = username;
                    	currentUser.password= password;
                    }
                    if (currentUser == null) {
                        System.out.println("Usuario ou senha Invalidos.\n Tente Novamente!.");
                    }
                } else if (opcao == 2) {
                    for (Conteudo conteudo : conteudos) {
                        System.out.println("ID: " + conteudo.id + ". " + conteudo.id + "\n Autor: " + conteudo.autor.username);
                    }                                 
            	} else if (opcao == 3) {
                    scanner.close();
            		System.exit(0);
            	}
            } else {
                System.out.println("1. Criar Conteudo");
                System.out.println("2. Listar Conteudo");
                System.out.println("3. Atualizar Conteudo");
                System.out.println("4. Excluir Conteudo");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                if (opcao == 1) {
                    System.out.print("Digite o Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o Texto: ");
                    String texto = scanner.nextLine();
                    Conteudo conteudo = new Conteudo();
                    conteudo.id = count++;
                    conteudo.titulo = titulo;
                    conteudo.texto = texto;
                    conteudo.autor = currentUser;
                    
                    conteudos.add(conteudo);
                    System.out.println("Conteudo criado ID: " + conteudo.id);
                } else if (opcao == 2) {
                    for (Conteudo conteudo : conteudos) {
                        System.out.println("ID: " + conteudo.id + ", Titulo: " + conteudo.titulo + "\n Autor: " + conteudo.autor.username);
                    }                
                } else if (opcao == 3) {
                    System.out.print("Digite o ID do conteudo para atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o novo Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o Texto: ");
                    String texto = scanner.nextLine();
                    for (Conteudo conteudo : conteudos) {
                        if (conteudo.id == id) {
                            conteudo.titulo = titulo;
                            conteudo.texto = texto;
                            System.out.println("Conteudo Atualizado.");
                        }
                    }
                } else if (opcao == 4) {
                    System.out.print("Digite o ID do conteudo para excluir: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  
                    boolean removido = conteudos.removeIf(conteudo -> conteudo.id == id);
                    if (removido) {
                        System.out.println("Conteudo excluido.");
                    } 
                } else if (opcao == 5) {
                    currentUser = null;
                }
            }
        }
    }
    
    static class Conteudo {
        int id;
        String titulo;
        String texto;
        Usuario autor;
    }
    
    static class Usuario {
        String username;
        String password;
    }

}
