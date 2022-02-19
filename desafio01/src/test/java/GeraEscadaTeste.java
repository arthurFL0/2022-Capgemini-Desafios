
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GeraEscadaTeste {
    public int valorTeste;
    public Escada escada;
    public String stringBaseEscada;


    @Test
    public void verificarBaseRetornada(){
        valorTeste = 6;
        escada = new Escada();
        stringBaseEscada = "******";
        Assertions.assertEquals(stringBaseEscada, escada.geraEscada(valorTeste));
    }
}
