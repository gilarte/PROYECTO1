package Vista;

import controladores.Partida;
import controladores.utils;


public class GUI {
	public static void iniciar() {
		// MEN�
		
		boolean ayuda = true, valid = false;

		/**
		 * Seg�n la opci�n escogida, pasar� una de las 3 opciones.
		 */
		do {
			utils.muestraMenu();// lo muestra
			int opc = utils.opcMenu(); // Elegimos la opci�n del men�.
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
				
			// Se abre el men� de opciones.
			case 2:
				utils.menuOpciones(ayuda);
				ayuda = utils.opcMenuOpciones(ayuda);
				valid = true;
				break;
			}
		} while (valid);
		
		
		
		
		
		
		
	}
}
