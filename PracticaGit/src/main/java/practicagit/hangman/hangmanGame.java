package practicagit.hangman;

import java.util.Scanner;
import java.io.IOException;

public class hangmanGame {

    String wordSaved;

    Scanner read = new Scanner(System.in);
    util keyWord = new util();

    int amountWordLetters;

    boolean errorValue;
    boolean gameEnded;

    public void initialazing() throws IOException, InterruptedException {
        System.out.println("BIENVENIDO AL JUEGO DEL AHORCADO\n");
        keyWord.gameStarted();
        wordSaved = keyWord.returnWord();

    }

    public void gameStarted(){
        System.out.println("\nINICIA EL JUEGO\n");

        amountWordLetters = keyWord.letterCounter();
        errorValue = keyWord.returnErrorValue();

        if (errorValue != true) {
            System.out.println("\nLa palabra que debes adivinar tiene "+amountWordLetters+" letras\n");

            keyWord.setFormedWord();

            do {
                gameEnded = keyWord.gameLoop();
            } while (gameEnded == false);
        }
    }

}
