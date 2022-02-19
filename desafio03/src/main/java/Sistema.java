import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        VerificadorAnagrama verificador = new VerificadorAnagrama();

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Insira a palavra para realizar o cálculo");
        String str = sc1.nextLine();

        verificador.verificaAnagramasPares(str);

    }
}
