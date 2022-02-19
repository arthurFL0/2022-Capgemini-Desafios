import java.util.HashMap;
import java.util.Map;


public class Validador {

    private boolean temWhiteSpace = false;

    public boolean fazerValidacoes(String senha) {
        char[] arrayCarecteres = senha.toCharArray();
        HashMap<String, Boolean> listaValidacoes = new HashMap<String, Boolean>();
        int contadorValidacoes = 0;
        boolean senhaValidada = false;

        //Cada tipo de validação é a "chave" dentro do hashmap, e o booleano retornado pelos métodos de cada validação
        //será o valor.
        listaValidacoes.put("t", validarTamanho(arrayCarecteres));
        listaValidacoes.put("d", validarDigito(arrayCarecteres));
        listaValidacoes.put("min", validarMinusculo(arrayCarecteres));
        listaValidacoes.put("mai", validarMaiusculo(arrayCarecteres));
        listaValidacoes.put("e", validarEspeciais(arrayCarecteres));

        //Esse for percorrer o hashmap e verificar o valor de cada uma das validações, se todas tiverem o valor true
        //a senha é considerada válida.

        for (Map.Entry<String, Boolean> entry : listaValidacoes.entrySet()) {
            String chave = entry.getKey();
            boolean valor = entry.getValue().booleanValue();

            if (!valor) {
                switch (chave) {
                    case "t":
                        if (temWhiteSpace) {
                            System.out.println("Não use espaços em branco na sua senha.");
                        } else {
                            System.out.println("O tamanho da sua senha é menor do que o mínimo requerido." +
                                    "Adicione mais " + (6 - arrayCarecteres.length) + " caractere(s).");
                        }
                        break;
                    case "d":
                        System.out.println("Sua senha precisa de pelo menos um número");
                        break;
                    case "min":
                        System.out.println("Sua senha precisa de pelo menos uma letra em minusculo");
                        break;
                    case "mai":
                        System.out.println("Sua senha precisa de pelo menos uma letra em maiusculo");
                        break;
                    case "e":
                        System.out.println("Sua senha precisa de pelo menos um caractere especial");
                }
            } else
                contadorValidacoes++;
        }
        if (contadorValidacoes == 5) {
            System.out.println("Sua senha foi cadastrada com sucesso");
            senhaValidada = true;
        }


        return senhaValidada;
    }

    //Cada método abaixo será responsável por realizar cada uma das validações necessárias.

    private Boolean validarTamanho(char[] arrayChar) {
        Boolean validacao = Boolean.valueOf(false);

        if (arrayChar.length >= 6) {
            for (int i = 0; i < arrayChar.length; i++) {
                if (arrayChar[i] == ' ') {
                    validacao = Boolean.valueOf(false);
                    temWhiteSpace = true;
                    break;
                } else {
                    validacao = Boolean.valueOf(true);
                }
            }
        }
        return validacao;
    }

    private Boolean validarDigito(char[] arrayChar) {
        Boolean validacao = Boolean.valueOf(false);

        for (int i = 0; i < arrayChar.length; i++) {
            if (Character.isDigit(arrayChar[i])) {
                validacao = Boolean.valueOf(true);
                break;
            }
        }
        return validacao;
    }

    private Boolean validarMinusculo(char[] arrayChar) {
        Boolean validacao = Boolean.valueOf(false);

        for (int i = 0; i < arrayChar.length; i++) {
            if (Character.isAlphabetic(arrayChar[i]) && Character.isLowerCase(arrayChar[i])) {
                validacao = Boolean.valueOf(true);
                break;
            }
        }
        return validacao;
    }

    private Boolean validarMaiusculo(char[] arrayChar) {
        Boolean validacao = Boolean.valueOf(false);


        for (int i = 0; i < arrayChar.length; i++) {
            if (Character.isAlphabetic(arrayChar[i]) && Character.isUpperCase(arrayChar[i])) {
                validacao = Boolean.valueOf(true);
                break;
            }
        }
        return validacao;
    }

    private Boolean validarEspeciais(char[] arrayChar) {
        Boolean validacao = Boolean.valueOf(false);


        for (int i = 0; i < arrayChar.length; i++) {
            if (!Character.isLetter(arrayChar[i]) && !Character.isDigit(arrayChar[i]) && arrayChar[i] != ' ') {
                validacao = Boolean.valueOf(true);
                break;
            }
        }
        return validacao;

    }
}
