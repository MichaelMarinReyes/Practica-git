package practicagit.basketball;

import java.util.Scanner;

public class gameStages {

    int pointsPlayerOne, pointsPlayerTwo;

    Scanner read = new Scanner(System.in);

    boolean specialShotAvailable; // variable para verificar si está disponible un tiro libre

    String shotKind, choosenMove;

    public void gameLoop(int amountPlays, String playerOne, String playerTwo) {

        pointsPlayerOne = 0;
        pointsPlayerTwo = 0;

        int randomNumber;

        boolean playerOneStart;

        randomNumber = (int) (Math.random() * 2);

        if (randomNumber == 0) {
            System.out.println("\nEl primer turno es para " + playerOne+"\n");
            playerOneStart = true;
        } else {
            System.out.println("\nEl primer turno es para " + playerTwo+"\n");
            playerOneStart = false;
        }

        for (int i = 1; i <= amountPlays; i++) {

            if (playerOneStart == true) {
                playerOneStart(playerOne);
                playerTwoStart(playerTwo);
            } else {
                playerTwoStart(playerTwo);
                playerOneStart(playerOne);
            }

        }

        if (pointsPlayerOne == pointsPlayerTwo) {
            System.out.println("\nEMPATE\n");
        } else {
            if (pointsPlayerOne < pointsPlayerTwo) {
                System.out.println("\nGANO "+playerTwo+"\n");
            } else {
                System.out.println("\nGANO "+playerOne+"\n");
            }
        }

    }

    public void playerOneStart(String namePlayerOne) { // acciones por si empieza el jugador 1

        boolean error = false;
        int probabilitySucces;

        System.out.println("Turno de "+namePlayerOne);

        do {
            System.out.println("------------------------------------------------");
            System.out.println("Desea realizar un tiro o una defensa?");
            choosenMove = read.nextLine();

            // acciones por si el jugador quiere hacer un tiro, defensa o se equivoca
            if (choosenMove.equals("TIRO")) {
                error = false;
                System.out.println("\nIndique el tipo de tiro que desea realizar");
                shotKind = read.nextLine();

                if (shotKind.equals("SALTO LARGO")) {
                    probabilitySucces = (int) (Math.random() * 101);
                    if (probabilitySucces <= 65) {
                        System.out.println("\nTIRO ENCESTADO\n");
                        pointsPlayerOne = pointsPlayerOne + 3;
                    } else {
                        System.out.println("\nTIRO FALLADO\n");
                    }
                } else {
                    if (shotKind.equals("SALTO CORTO")) {
                        probabilitySucces = (int) (Math.random() * 101);
                        if (probabilitySucces <= 80) {
                            System.out.println("\nTIRO ENCESTADO\n");
                            pointsPlayerOne = pointsPlayerOne + 2;
                        } else {
                            System.out.println("\nTIRO FALLADO\n");
                        }
                    } else {
                        if (shotKind.equals("TIRO LIBRE") && specialShotAvailable == true) { // espacio para realizar las condiciones con el salto libre

                        } else {
                            System.out.println("\nERROR\n");
                            error = true;
                        }
                    }
                }
            } else {
                if (choosenMove.equals("DEFENSA")) { // espacio para realizar acciones si escoge defensa
                    error = false;
                } else {
                    System.out.println("\nERROR\n");
                    error = true;
                }
            }
        } while (error == true);

    }

    public void playerTwoStart(String namePlayerTwo) { // acciones por si empieza el jugador 2

        boolean error = false;
        int probabilitySucces;

        System.out.println("Turno de "+namePlayerTwo);

        do {
            System.out.println("------------------------------------------------");
            System.out.println("Desea realizar un tiro o una defensa?\n");
            choosenMove = read.nextLine();

            // acciones por si el jugador quiere hacer un tiro, defensa o se equivoca
            if (choosenMove.equals("TIRO")) {
                error = false;
                System.out.println("Indique el tipo de tiro que desea realizar");
                shotKind = read.nextLine();

                if (shotKind.equals("SALTO LARGO")) {
                    probabilitySucces = (int) (Math.random() * 101);
                    if (probabilitySucces <= 65) {
                        System.out.println("\nTIRO ENCESTADO\n");
                        pointsPlayerTwo = pointsPlayerTwo + 3;
                    } else {
                        System.out.println("\nTIRO FALLADO\n");
                    }
                } else {
                    if (shotKind.equals("SALTO CORTO")) {
                        probabilitySucces = (int) (Math.random() * 101);
                        if (probabilitySucces <= 80) {
                            System.out.println("\nTIRO ENCESTADO\n");
                            pointsPlayerTwo = pointsPlayerTwo + 2;
                        } else {
                            System.out.println("\nTIRO FALLADO\n");
                        }
                    } else {
                        if (shotKind.equals("TIRO LIBRE") && specialShotAvailable == true) { // espacio para realizar las condiciones con el salto libre

                        } else {
                            System.out.println("\nERROR\n");
                            error = true;
                        }
                    }
                }
            } else {
                if (choosenMove.equals("DEFENSA")) { // espacio para realizar acciones si escoge defensa
                    error = false;
                } else {
                    System.out.println("\nERROR\n");
                    error = true;
                }
            }
        } while (error == true);

    }
}
