package Vista;

import controladores.Partida;
import controladores.utils;


public class GUI {
	public static void iniciar() {
		// MENÚ
		
		boolean ayuda = true, valid = false;

		/**
		 * Según la opción escogida, pasará una de las 3 opciones.
		 */
		do {
			utils.muestraMenu();// lo muestra
			int opc = utils.opcMenu(); // Elegimos la opción del menú.
			valid = false;
			switch (opc) {
			// Se cierra el juego.
			case 0:
				System.out.println("Juego cerrado.");
				break;
				
			// El juego comienza
			case 1:
				Partida.partida(ayuda);
				valid=true;
				break;
				
			// Se abre el menú de opciones.
			case 2:
				utils.menuOpciones(ayuda);
				ayuda = utils.opcMenuOpciones(ayuda);
				valid = true;
				break;
			}
		} while (valid);
		
		
		
		
		
		
		
	}
}
