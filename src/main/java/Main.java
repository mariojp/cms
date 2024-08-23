public class Main {
    public static void main(String[] args) {
        Usuario currentUser = null;
        
        TUI ui = new TUI();
        
        while (true) {
            if (currentUser == null) {
                currentUser = ui.mostrarMenuLogin();
            } else {
            	currentUser = ui.mostrarMenuConteudo(currentUser);
            }
        }
    }
}
