import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TesteValidador {

    @Test
    public void testarValidador(){
        Validador validador = new Validador();
        String stringTeste = "Senh4%s";

        Assertions.assertTrue(validador.fazerValidacoes(stringTeste));
    }
}
