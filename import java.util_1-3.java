import java.util.Scanner;

public class Main {
       
    
       public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Escreva o código do seu comboio: ");
        String nome = scanner.nextLine();
        
        string[] informacoes = nome.split("-");

        if (informacoes.length == 4) {
            System.out.println("\nCódigo válido! ");
            
            String tipoComboio = informacoes[0];
            String origem = informacoes[1];
            String destino = informacoes[2];
            String numeroComboio = informacoes[3];
        }
   }
   public static boolean contemApenasLetras(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true; 
    }
}
