import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validador validador = new Validador();

        boolean naoFoiAvaliada = true;
        do{
             String senha = scanner.nextLine();
             if(validador.fazerValidacoes(senha)){
                 naoFoiAvaliada = false;
             }
        }while (naoFoiAvaliada);

    }
}
