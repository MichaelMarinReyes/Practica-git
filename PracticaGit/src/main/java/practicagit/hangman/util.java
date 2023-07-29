package practicagit.hangman;

import java.io.IOException;
import java.util.Scanner;

public class util {

    String misteryWord;
    String wordGuessed;

    char[] formedWord;

    Scanner read = new Scanner(System.in);

    int numbLetter;
    int correctLetters = 0;
    int numbMistakes = 0;
    int criticNumbMistakes = 0;
    int numbHits = 0;

    boolean spaceError = false;
    boolean gameState = false;

    public void gameStarted() throws IOException, InterruptedException {
        System.out.println("Por favor introduzca la palabra a adivinar");
        misteryWord = read.nextLine();
        formedWord = new char[misteryWord.length()];
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public String returnWord() {
        return misteryWord;
    }

    public int letterCounter() {
        numbLetter = 0;

        for (int i = 0; i < misteryWord.length(); i++) {
            if (misteryWord.charAt(i) != ' ') {
                numbLetter++;
            } else {
                System.out.println("ERROR.\nDebe introducir una palabra que no contenga espacios.");
                System.out.println("Solamente se aceptan palabras, frases no");
                spaceError = true;
            }
        }

        return numbLetter;
    }

    public boolean returnErrorValue() {
        return spaceError;
    }

    public void setFormedWord() {
        for (int i = 0; i < misteryWord.length(); i++) {
            formedWord[i] = '*';
        }
    }

    public boolean gameLoop() {

        numbMistakes = 0;
        numbHits = 0;

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Por favor introduce una letra");
        wordGuessed = read.nextLine();

        if (wordGuessed.equals(misteryWord)) {

            System.out.println("¡Felicidades!\nHaz adivinado la palabra\n");
            gameState = true;

        } else {

            if (wordGuessed.length() == 1) {

                char[] letterWordGuessed = wordGuessed.toCharArray();
                char[] letterMisteryWord = misteryWord.toCharArray();

                for (int i = 0; i < misteryWord.length(); i++) {

                    if (letterWordGuessed[0] == formedWord[i]) {

                        System.out.println("\nYa haz usado esta letra");
                        numbMistakes++;

                    } else {

                        if (letterWordGuessed[0] == misteryWord.charAt(i)) {

                            formedWord[i] = letterMisteryWord[i];
                            correctLetters++;
                            numbHits++;

                        } else {

                            if (formedWord[i] == '*') {
                                numbMistakes++;
                            }

                        }

                    }

                }

                if (numbMistakes > 0 && numbHits == 0) {
                    criticNumbMistakes++;
                }

                System.out.print("\nLa palabra es:");

                for (int i = 0; i < misteryWord.length(); i++) {
                    System.out.print(formedWord[i]);
                }

                System.out.println("");

                switch (criticNumbMistakes) {
                    case 1:
                        System.out.println("");
                        System.out.println("    |");
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("    |");
                        System.out.println("    O");
                        break;
                    case 3:
                        System.out.println("");
                        System.out.println("    |");
                        System.out.println("    O");
                        System.out.println("   /");
                        break;
                    case 4:
                        System.out.println("");
                        System.out.println("    |");
                        System.out.println("    O");
                        System.out.println("   /|");
                        break;
                    case 5:
                        System.out.println("");
                        System.out.println("    |");
                        System.out.println("    O");
                        System.out.println("   /|/ ");
                        break;
                    case 6:
                        System.out.println("");
                        System.out.println("    |");
                        System.out.println("    O");
                        System.out.println("   /|/ ");
                        System.out.println("   /");
                        break;
                    case 7:
                        System.out.println("");
                        System.out.println("    |");
                        System.out.println("    O");
                        System.out.println("   /|/ ");
                        System.out.println("   / /");
                        gameState = true;

                        System.out.println("\nHaz perdido");
                        break;
                    default:
                        break;
                }

                if (numbLetter == correctLetters) {
                    System.out.println("\n¡Felicidades!\nHaz adivinado la palabra\n");
                    gameState = true;
                }

            } else {

                System.out.println("Hay más de una letra");
            }

        }

        return gameState;
    }
}
