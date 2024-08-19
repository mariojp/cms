public class Main {
	
	

	/**
	 * A classe Main tem a responsabilidade de iniciar a aplicação e gerenciar o fluxo principal entre os 
	 * menus de login e de conteúdo. Isso segue o SRP porque a Main se preocupa apenas com o controle de 
	 * fluxo da aplicação.
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
        Usuario currentUser = null;
        UI ui = new UI();
        
        while (true) {
            if (currentUser == null) {
            	currentUser = ui.mostrarMenuLogin();
            } else {
            	ui.mostrarMenuConteudo(currentUser);
            }
        }
    }
    
    

}
