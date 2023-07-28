import java.util.Random;
import java.util.Scanner;

public class Practica {

	public static int opcionMenu;
	public static int dinero = 100;
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {
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
					break;
				case 1:
					// Juego 1
					break;
				case 2:
					// Basketball
					break;
				case 3:
					juegoCartas();
					break;
				default:
					System.out.println("Ingrese una opción válida\n");
					break;
			}
		} while (opcionMenu != 0);
	}

	public static void juegoCartas() {
		System.out.println("\nBienvenido al Juego de Cartas.");
		System.out.print("Ingresa la cantidad de dinero con la que cuentas: ");
		dinero = entrada.nextInt();

		while (dinero > 0) {
			int carta1 = generarCarta();
			int carta2 = generarCarta();

			System.out.println("Cartas presentadas: " + carta1 + " y " + carta2);

			System.out.print("¿Cuánto dinero deseas apostar?: ");
			int apuesta = entrada.nextInt();
			System.out.println();

			int siguienteCarta = generarCarta();
            System.out.println("La siguiente carta es: " + siguienteCarta);
            
			//if (apuesta != 0) { SI EL USUARIO INGRESA 0 ENTONCES TERMINA LA PARTIDA.

				if (apuesta > dinero) {
					System.out.println("No tienes suficiente dinero para hacer esa apuesta.");
					continue;
				}

				if (siguienteCarta > carta1 && siguienteCarta < carta2 || siguienteCarta < carta1 && siguienteCarta > carta2) {
					dinero += apuesta;
					System.out.println("\n¡Felicidades! Has ganado $" + apuesta);
				} else {
					dinero -= apuesta;
					System.out.println("\nLo siento, has perdido $" + apuesta);
				}
				

				System.out.println("\nDinero restante: " + dinero);
				System.out.println("----------------------------");
			/* } else {
				System.out.println("Volviendo al menú...\n");
				break;
			}*/
		}

		System.out.println("Te has quedado sin dinero. Fin del juego.\n");
	}

	public static int generarCarta() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
