/* Nessa classe se inicializa um objeto da classe Escada para chamar o seu método
 responsável por desenhar uma escada no terminal */

import java.util.Scanner;

public class Sistema {


    public static void main(String[] args) {


        Scanner sc1 = new Scanner(System.in);
        System.out.println("Por favor insira o número para o desenho da escada.");
        int num = sc1.nextInt();
        Escada escada = new Escada();

        escada.geraEscada(num);




    }


}
