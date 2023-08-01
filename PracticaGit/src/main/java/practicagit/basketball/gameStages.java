package practicagit.basketball;

import java.util.Scanner;

public class gameStages {

    private int pointsPlayerOne;
    private int pointsPlayerTwo;
    private String shotKind;
    private String choosenMove;
    private boolean specialShotAvailable; // variable para verificar si está disponible un tiro libre

    Scanner read = new Scanner(System.in);

    public void gameLoop(int amountPlays, String playerOne, String playerTwo) {

        pointsPlayerOne = 0;
        pointsPlayerTwo = 0;

        int randomNumber;

        boolean playerOneStart;

        randomNumber = (int) (Math.random() * 2);

        if (randomNumber == 0) {
            System.out.println("\nEl primer turno es para " + playerOne + "\n");
            playerOneStart = true;
        } else {
            System.out.println("\nEl primer turno es para " + playerTwo + "\n");
            playerOneStart = false;
        }

        for (int i = 1; i <= amountPlays; i++) {

            if (playerOneStart == true) {
                playerOneStart(playerOne, playerTwo);
                playerTwoStart(playerTwo, playerOne);
            } else {
                playerTwoStart(playerTwo, playerOne);
                playerOneStart(playerOne, playerTwo);
            }
        }

        if (pointsPlayerOne == pointsPlayerTwo) {
            System.out.println("\nEMPATE\n");
        } else {
            if (pointsPlayerOne < pointsPlayerTwo) {
                System.out.println("\nGANO " + playerTwo + "\n");
            } else {
                System.out.println("\nGANO " + playerOne + "\n");
            }
        }

    }

    public void playerOneStart(String namePlayerOne, String namePlayerTwo) { // acciones por si empieza el jugador 1

        boolean error = false;
        int probabilitySucces;
        boolean errorFormat = false;

        //while (!errorFormat) {
            try {
                System.out.println("Turno de " + namePlayerOne);

                do {
                    System.out.println("------------------------------------------------");
                    System.out.println("Desea realizar un tiro o una defensa?");
                    System.out.println("Escriba TIRO o DEFENSA");
                    choosenMove = read.nextLine();

                    // acciones por si el jugador quiere hacer un tiro, defensa o se equivoca
                    if (choosenMove.equals("TIRO")) {
                        error = false;
                        System.out.println("\nIndique el tipo de tiro que desea realizar");
                        System.out.println("1. SALTO LARGO \n2. SALTO CORTO");
                        shotKind = read.nextLine();

                        if (shotKind.equals("SALTO LARGO")) {
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces <= 65) {
                                System.out.println("\nTIRO ENCESTADO\n");
                                pointsPlayerOne = pointsPlayerOne + 3;
                            } else {
                                System.out.println("\nTIRO FALLADO\n");
                            }
                        } else if (shotKind.equals("SALTO CORTO")) {
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces <= 80) {
                                System.out.println("\nTIRO ENCESTADO\n");
                                pointsPlayerOne = pointsPlayerOne + 2;
                            } else {
                                System.out.println("\nTIRO FALLADO\n");
                            }
                        } else {
                            if (shotKind.equals("TIRO LIBRE") && specialShotAvailable == true) { // espacio para realizar las condiciones con el salto libre
                                realizarTiroLibre(namePlayerOne, namePlayerTwo);
                            } else {
                                System.out.println("\nERROR\n");
                                error = true;
                            }
                        }
                    } else if (choosenMove.equals("DEFENSA")) { // espacio para realizar acciones si escoge defensa
                        error = false;
                        System.out.println("Indique el tipo de defensa que desea realizar colocando 1 o 2");
                        System.out.println("1. DEFENSA CUERPO A CUERPO \n2. DEFENSA FUERTE");
                        int defenseKind = Integer.parseInt(read.nextLine());

                        if (defenseKind == 1) {
                            // Defensa cuerpo a cuerpo
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces > 15) {
                                System.out.println("\nDEFENSA EFECTIVA\n");
                            } else {
                                System.out.println("\nDEFENSA FALLIDA\n");
                                // Probabilidad de hacer falta
                                probabilitySucces = (int) (Math.random() * 101);
                                if (probabilitySucces <= 35) {
                                    // Se hace falta
                                    realizarTiroLibre(namePlayerTwo, namePlayerOne);
                                }
                            }
                        } else if (defenseKind == 2) {
                            // Defensa fuerte
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces > 30) {
                                System.out.println("\nDEFENSA FUERTE EFECTIVA\n");
                            } else {
                                System.out.println("\nDEFENSA FUERTE FALLIDA\n");
                                // Probabilidad de hacer falta
                                probabilitySucces = (int) (Math.random() * 101);
                                if (probabilitySucces <= 65) {
                                    // Se hace falta
                                    realizarTiroLibre(namePlayerTwo, namePlayerOne);
                                }
                            }
                        } else {
                            System.out.println("\nERROR\n");
                            error = true;
                        }
                    } else {
                        System.out.println("\nERROR\n");
                        error = true;
                    }
                } while (error == true);
            } catch (NumberFormatException e) {
                String limiarBuffer = read.nextLine();
                System.out.println("\nERROR\n");
            }
        //}
    }

    public void playerTwoStart(String namePlayerTwo, String namePlayerOne) { // acciones por si empieza el jugador 2

        boolean error = false;
        boolean errorFormat = false;
        int probabilitySucces;

       // while (!errorFormat) {
            try {
                System.out.println("Turno de " + namePlayerTwo);

                do {
                    System.out.println("------------------------------------------------");
                    System.out.println("Desea realizar un tiro o una defensa?\n");
                    System.out.println("Escriba TIRO o DEFENSA");
                    choosenMove = read.nextLine();

                    // acciones por si el jugador quiere hacer un tiro, defensa o se equivoca
                    if (choosenMove.equals("TIRO")) {
                        error = false;
                        System.out.println("Indique el tipo de tiro que desea realizar");
                        System.out.println("1. SALTO LARGO \n2. SALTO CORTO");
                        shotKind = read.nextLine();

                        if (shotKind.equals("SALTO LARGO")) {
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces <= 65) {
                                System.out.println("\nTIRO ENCESTADO\n");
                                pointsPlayerTwo = pointsPlayerTwo + 3;
                            } else {
                                System.out.println("\nTIRO FALLADO\n");
                            }
                        } else if (shotKind.equals("SALTO CORTO")) {
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces <= 80) {
                                System.out.println("\nTIRO ENCESTADO\n");
                                pointsPlayerTwo = pointsPlayerTwo + 2;
                            } else {
                                System.out.println("\nTIRO FALLADO\n");
                            }
                        } else {
                            if (shotKind.equals("TIRO LIBRE") && specialShotAvailable == true) { // espacio para realizar las condiciones con el salto libre
                                realizarTiroLibre(namePlayerTwo, namePlayerOne);
                            } else {
                                System.out.println("\nERROR\n");
                                error = true;
                            }
                        }
                    } else if (choosenMove.equals("DEFENSA")) { // espacio para realizar acciones si escoge defensa
                        error = false;
                        System.out.println("Indique el tipo de defensa que desea realizar colocando 1 o 2");
                        System.out.println("1. DEFENSA CUERPO A CUERPO \n2. DEFENSA FUERTE");
                        int defenseKind = Integer.parseInt(read.nextLine());
                        if (defenseKind == 1) {
                            // Defensa cuerpo a cuerpo
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces > 15) {
                                System.out.println("\nDEFENSA EFECTIVA\n");
                            } else {
                                System.out.println("\nDEFENSA FALLIDA\n");
                                // Probabilidad de hacer falta
                                probabilitySucces = (int) (Math.random() * 101);
                                if (probabilitySucces <= 35) {
                                    // Se hace falta
                                    realizarTiroLibre(namePlayerOne, namePlayerTwo);
                                }
                            }
                        } else if (defenseKind == 2) {
                            // Defensa fuerte
                            probabilitySucces = (int) (Math.random() * 101);
                            if (probabilitySucces > 30) {
                                System.out.println("\nDEFENSA FUERTE EFECTIVA\n");
                            } else {
                                System.out.println("\nDEFENSA FUERTE FALLIDA\n");
                                // Probabilidad de hacer falta
                                probabilitySucces = (int) (Math.random() * 101);
                                if (probabilitySucces <= 65) {
                                    // Se hace falta
                                    realizarTiroLibre(namePlayerOne, namePlayerTwo);
                                }
                            }
                        } else {
                            System.out.println("\nERROR\n");
                            error = true;
                        }
                    } else {
                        System.out.println("\nERROR\n");
                        error = true;
                    }
                } while (error == true);

            } catch (NumberFormatException e) {
                String limiarBuffer = read.nextLine();
                System.out.println("\nERROR\n");
            }
        //}
    }

    public void realizarTiroLibre(String playerName, String playerNameOpponent) {
        int probabilitySuccess = (int) (Math.random() * 101);
        if (probabilitySuccess <= 90) {
            System.out.println("\nTIRO LIBRE ENCESTADO\n");
            if (playerName.equals(playerNameOpponent)) {
                pointsPlayerOne += 2;
            } else {
                pointsPlayerTwo += 2;
            }
        } else {
            System.out.println("\nTIRO LIBRE FALLADO\n");
        }
    }
}
