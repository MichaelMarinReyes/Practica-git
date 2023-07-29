package practicagit.juegocartas;

import java.util.Random;

/**
 *
 * @author michael
 */
public class Casino {

    public Carta sacarCarta () {
        Random random = new Random();
        int valorCarta = random.nextInt(13) + 1;
        return new Carta(valorCarta);
    }
}
