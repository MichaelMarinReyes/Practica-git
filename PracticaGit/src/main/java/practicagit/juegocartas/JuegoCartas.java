package practicagit.juegocartas;

import java.util.Scanner;
import practicagit.Jugador;

/**
 *
 * @author michael
 */
public class JuegoCartas {

    Scanner entrada = new Scanner(System.in);

    public void jugarCartas() {
        System.out.println("\n ---Bienvenido al juego de cartas---");
        System.out.print("Ingrese la cantidad de dinero con la que cuenta: ");
        int dineroApostado = entrada.nextInt();
        
        Jugador jugador = new Jugador(dineroApostado);
        Casino casino = new Casino();
        
        while (jugador.tenerDinero()) {
            Carta carta1 = casino.sacarCarta();
            Carta carta2 = casino.sacarCarta();
            
            System.out.println("Cartas presentadas: " + carta1.getValorCarta() + " y " + carta2.getValorCarta());
            System.out.print("Ingrese la cantidad de dinero que desea apostar: ");
            int apuesta = entrada.nextInt();
            
            boolean resultado = jugador.apostar(apuesta, carta1, carta2);
            if (resultado) {
                System.out.println("\n---Felicidades has ganado!!!. Tu saldo es: " + jugador.getDinero());
            } else {
                System.out.println("\n---Has perdido. Tu saldo es: " + jugador.getDinero());
            }
        }
        System.out.println("Ya no tienes dinero, el juego ha terminado\n");
    }
}
