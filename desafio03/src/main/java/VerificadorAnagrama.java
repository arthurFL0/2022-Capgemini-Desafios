import java.util.ArrayList;
import java.util.Arrays;

public class VerificadorAnagrama {


    public int verificaAnagramasPares(String palavra) {

        char[] array = palavra.toCharArray();
        ArrayList<Integer> contagemLetrasRepetidas = new ArrayList<>();
        ArrayList<String> letrasJaVerificadas = new ArrayList<>();

        
        /* Primeiro vai ser realizado o cálculo de quantas letras iguais existem na palavra, e a quantidade
        de cada uma delas. Para então calcular os pares de anagramas que são letras iguais, por exemplo: [o,o] da string "ovo"*/
        for (int i = 0; i < array.length; i++) {
            int contador = 0;
            String strChar = Character.toString(array[i]);

            if (!letrasJaVerificadas.contains(strChar) && !Character.isWhitespace(array[i])) {
                letrasJaVerificadas.add(strChar);

                for (char c : array) {
                    if (array[i] == c) {
                        contador++;
                    }
                }
            }
            if (contador > 1)
                contagemLetrasRepetidas.add(contador);

        }


        /* Depois que o total de pares forem calculados em CalcularRepeticoesLetrasIguais,
        será aplicado a função reduce para somar todos eles*/
        Integer totalParesLetras = contagemLetrasRepetidas.stream().map(integer ->
                CalcularRepeticoesLetrasIguais(integer)).reduce(0, (subtotal, atual) -> subtotal + atual);


        /* Aqui a palavra inteira é divida em substrings de pelo menos 2 careceteres e depois armazenadas em uma lista.
        Essas listas também serão armazenadas em uma lista.*/

        String palavraModificada = palavra;
        ArrayList<ArrayList<String>> listaDeListasSubstrings = new ArrayList<>();

        if (palavra.length() > 2) {

            for (int i = 0; i < palavra.length() - 1; i++) {
                ArrayList<String> arraySubs = new ArrayList<>();
                String letraAtual = Character.toString(palavraModificada.charAt(0));

                if (letraAtual != " ") {
                    if (palavraModificada.length() == 2) {
                        char[] charArray = palavraModificada.toCharArray();
                        Arrays.sort(charArray);
                        String substringOrdenada = String.valueOf(charArray);
                        arraySubs.add(substringOrdenada);
                        listaDeListasSubstrings.add(arraySubs);
                        break;
                    }
                    for (int j = 2; j <= palavraModificada.length() - 1; j++) {
                        String substringAtual = palavraModificada.substring(0, j);
                        char[] charArray = substringAtual.toCharArray();
                        Arrays.sort(charArray);
                        String substringOrdenada = String.valueOf(charArray);
                        arraySubs.add(substringOrdenada);
                    }

                    palavraModificada = palavraModificada.substring(1);
                    listaDeListasSubstrings.add(arraySubs);

                }
            }
        }

        /* Aqui, cada string em cada array de substrings vai ser percorrida e comparada com as outras substrings formadas nos outros
        pontos da palavra para descobrir quantas repetições de substrings existem. Depois com o CalcularRepeticoesLetrasIguais
        será realizado o cálculo para saber quantos pares de anagramas serão capazes de formar com cada repetição.
         */

        ArrayList<Integer> contagemSubstringsRepetidas = new ArrayList<>();
        ArrayList<String> substringsJaVerificadas = new ArrayList<>();

        for (int i = 0; i < listaDeListasSubstrings.size(); i++) {
            ArrayList<String> arraySubstringAtual = listaDeListasSubstrings.get(i);

            for (int j = 0; j < arraySubstringAtual.size(); j++) {
                String substringAtual = arraySubstringAtual.get(j);
                Integer contadorRepeticoes = 0;
                if (!substringsJaVerificadas.contains(substringAtual)) {
                    // .contains() irá comparar o valor de cada objeto String com .equals()
                    substringsJaVerificadas.add(substringAtual);
                    for (int y = 0; y < listaDeListasSubstrings.size(); y++) {
                        if (i != y) {
                            ArrayList<String> arraySubstringComparacao = listaDeListasSubstrings.get(y);
                            if (arraySubstringComparacao.contains(substringAtual)) {
                                contadorRepeticoes++;
                            }
                            ;
                        }
                    }
                }

                if (contadorRepeticoes > 0)
                    contagemSubstringsRepetidas.add(contadorRepeticoes + 1);
                //O + 1 é necessário aqui pois o contador não conta com a substring que está verificando
            }
        }

         /* Depois que o total de pares de substrings forem calculados em CalcularRepeticoesLetrasIguais,
        será aplicado a função reduce para somar todos eles*/
        Integer totalSubstringsPares = contagemSubstringsRepetidas.stream().map(integer ->
                CalcularRepeticoesLetrasIguais(integer)).reduce(0, (subtotal, atual) -> subtotal + atual);

        int TotalFinal = totalParesLetras + totalSubstringsPares;

        System.out.println("O total de pares de anagramas que podem ser formados são: " + TotalFinal);
        return TotalFinal;
    }






    /* O método CalcularRepeticoesLetrasIguais é responsável por calcular o número de pares de letras ou substrings
    iguais usando o número de repetições de cada uma delas na palavra sendo verificada.

    A string "aaaa" possuí quatro letras que formam ao total 6 pares de anagramas diferentes:
    As três substrings est,tse,ets formam ao total 3 pares de anagramas diferentes:

     aaaa = a(1)a(2)a(3)a(4)      ou      est,tse,ets

     a(1) a(2) | a(2) a(3) | a(3) a(4)    [est,tse] | [ets,tse]
     a(1) a(3) | a(2) a(4) |              [est,ets] |
     a(1) a(4) |
     */

    private int CalcularRepeticoesLetrasIguais(int num) {
        ArrayList<Integer> array = new ArrayList<>();


        for (int i = 1; i < num; i++) {
            array.add(num - i);

        }
        int resultado = array.stream().reduce(0, (subtotal, atual) -> subtotal + atual);


        return resultado;
    }


}
