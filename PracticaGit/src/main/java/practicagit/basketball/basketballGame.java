package practicagit.basketball;

import java.util.Scanner;

public class basketballGame {

    Scanner read = new Scanner(System.in);
    gameStages stage = new gameStages();

    String namePlayerOne, namePlayerTwo;

    int amountPlays;

    public void initialazing() {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("BIENVENIDO AL JUEGO DE BALONCESTO\n");
        System.out.println("Introducir nombre del jugador 1:");
        namePlayerOne = read.nextLine();
        System.out.println("\nIntroducir nombre del jugador 2:");
        namePlayerTwo = read.nextLine();

        System.out.println("\nIntroduzca la cantidad de turnos que tendrá el juego");
        stage.gameLoop(read.nextInt(), namePlayerOne, namePlayerTwo); // acá se envían la cantidad de turnos y nombres
                                                                      // de jugadores a la clase gameStages
    }
}
