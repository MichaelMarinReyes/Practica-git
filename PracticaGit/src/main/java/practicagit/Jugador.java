package practicagit;

import java.util.Random;
import practicagit.juegocartas.Carta;

/**
 *
 * @author michael
 */
public class Jugador {

    private int dinero;

    public Jugador(int dinero) {
        this.dinero = dinero;
    }

    public boolean tenerDinero() {
        return dinero > 0;
    }

    public int getDinero() {
        return dinero;
    }

    public boolean apostar(int apuesta, Carta primeraCarta, Carta segundaCarta) {
        Random random = new Random();
        int valorTercerCarta = random.nextInt(13) + 1;

        System.out.println("La siguiente carta es: " + valorTercerCarta);

        if ((valorTercerCarta > primeraCarta.getValorCarta() && valorTercerCarta < segundaCarta.getValorCarta()) || (valorTercerCarta < primeraCarta.getValorCarta() && valorTercerCarta > segundaCarta.getValorCarta())) {
            dinero += apuesta;
            return true;
        } else {
            dinero -= apuesta;
            return false;
        }
    }
}
