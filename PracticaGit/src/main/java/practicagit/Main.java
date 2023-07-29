package practicagit;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import practicagit.hangman.hangmanGame;
import practicagit.juegocartas.JuegoCartas;

/**
 *
 * @author michael
 */
public class Main {

    public static void main(String[] args) {
        menuPrincipal();
    }

    @SuppressWarnings("empty-statement")
    public static void menuPrincipal() {
        int opcionMenu;
        boolean error = false;

        Scanner entrada = new Scanner(System.in);

        while (!error) {
            try {
                do {
                    System.out.println("---MULTIJUEGOS---");
                    System.out.println("1. Ahorcado");
                    System.out.println("2. Basketball");
                    System.out.println("3. Juego de cartas");
                    System.out.println("0. Salir");
                    opcionMenu = entrada.nextInt();

                    switch (opcionMenu) {
                        case 0:
                            System.out.println("Saliendo del juego");
                            error = true;
                            break;
                        case 1:
                            hangmanGame gameOne = new hangmanGame();
                            try {
                                gameOne.initialazing();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            gameOne.gameStarted();
                            break;
                        case 2:
                            // Basketball
                            break;
                        case 3:
                            JuegoCartas jugar = new JuegoCartas();
                            jugar.jugarCartas();
                            break;
                        default:
                            System.out.println("Ingrese una opción válida\n");
                            break;
                    }
                } while (opcionMenu != 0);

            } catch (InputMismatchException e) {
                String limiarBuffer = entrada.nextLine();
                System.out.println("Caracter inválido: \"" + limiarBuffer + "\"\nIntentelo de nuevo\n");
            }
        }
    }
}
