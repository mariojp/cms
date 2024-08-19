public class Main {
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
