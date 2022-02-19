import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TesteVerificadorAnagrama {

    @Test
    public void testarVerificador(){
        String stringTeste = "ifailuhkqq";
        VerificadorAnagrama verificador = new VerificadorAnagrama();

        int resultado = verificador.verificaAnagramasPares(stringTeste);

        Assertions.assertEquals(resultado,3);
    }
}
