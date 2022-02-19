/* Essa é a classe responsável pelo método que irá gerar o desenho da escada */

public class Escada {

    public Escada() {
    }

    public String geraEscada(int baseEscada){

        String degrauAtual = degrauAtual = String.format("%"+baseEscada+"s","");
        /* Aqui é inicializado uma String de espaços em branco com tamanho de acordo
        com o parâmetro recebido pelo método, que é o valor da base da escada.*/


        for (int i = 1; i <= baseEscada; i++) {

            String substring1 = degrauAtual.substring(0, degrauAtual.lastIndexOf(" "));
            String substring2 = degrauAtual.substring(degrauAtual.lastIndexOf(" ")).replace(" ", "*");
            degrauAtual = substring1 + substring2;

            System.out.println(degrauAtual);


             /* Dentro do for a string "degrauAtual" é dividida considerando o ultimo indice de um caractere que seja
            um espaço em branco. Na primeira iteração todos os carecteres ainda são espaços brancos, e assim o último carectere,
            que é igual um espaço em branco, é separado do resto da string e substituido por um "*", que
            é concatenado com o resto da string.

            O resto da string é separado apartir do índice 0 até um carectere antes do índice do último carectere de espaço branco,
            Assim, depois da primeira iteração, o último espaço em branco antes do asterisco é separado junto com ele e depois o mesmo é
            substituido por um "*". O processo se repete até i ser igual ao valor da base da escada.
            */

        }
        /* O método retorna a string final da base da escada para a verificação no teste unitário*/
        return degrauAtual;
    }

    }



