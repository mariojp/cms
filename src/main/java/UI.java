import java.util.Scanner;



/**
 * A classe UI lida exclusivamente com a interação com o usuário. 
 * Ela exibe os menus, coleta as entradas do usuário e chama os métodos apropriados 
 * para realizar ações como login, listagem e gerenciamento de conteúdos.
 */
public class UI {

    Scanner scanner = new Scanner(System.in);

	
    public Usuario mostrarMenuLogin() {
        while (true) {
            System.out.println("1. Entrar");
            System.out.println("2. Listar Conteudo");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o username: ");
                    String username = scanner.nextLine();
                    System.out.print("Digite o password: ");
                    String password = scanner.nextLine();
                    Usuario usuario = new Usuario(username, password);
                    if (usuario.validarLogin()) {
                    	return usuario;
                    }
                    return null;
                case 2:
                	listarConteudo();
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    
    private void listarConteudo() {
        for (Conteudo conteudo : Conteudo.listarConteudos()) {
            System.out.println(conteudo);
        }         
	}
    
    private String lerInfo(String label) {
        System.out.print(label=" : ");
        return scanner.nextLine().trim();
    }
    
    public void mostrarMenuConteudo(Usuario currentUser) {
        System.out.println("1. Criar Conteudo");
        System.out.println("2. Listar Conteudo");
        System.out.println("3. Atualizar Conteudo");
        System.out.println("4. Excluir Conteudo");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 
        if (opcao == 1) {
            String titulo = lerInfo("Digite o Titulo");
            String texto = lerInfo("Digite o Texto");
            Conteudo conteudo = new Conteudo(titulo,texto,currentUser);
            System.out.println("Conteudo criado ID: " + conteudo.getId());
        } else if (opcao == 2) {
        	listarConteudo();
        } else if (opcao == 3) {
            String ids = lerInfo("Digite o ID do conteudo para atualizar");
            int id =  Integer.parseInt(ids);
            String titulo = lerInfo("Digite o Titulo");
            String texto = lerInfo("Digite o Texto");
            for (Conteudo conteudo : Conteudo.listarConteudos()) {
                if (conteudo.getId() == id) {
                	conteudo.atualizar(titulo, texto);
                    System.out.println("Conteudo Atualizado.");
                }
            }
        } else if (opcao == 4) {
            String ids = lerInfo("Digite o ID do conteudo para excluir");
            int id =  Integer.parseInt(ids);
            scanner.nextLine();
            boolean removido = Conteudo.remover(id);
            if (removido) {
                System.out.println("Conteudo excluido.");
            } 
        } else if (opcao == 5) {
            currentUser = null;
        }
    	
    	
    	
    }

    
    

}
