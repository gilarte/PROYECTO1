
package controladores;

import java.util.Scanner;

import modelo.Personajes;

public class utils {

	/**
	 * Función que muestra el menú del programa en 3 opciones.
	 */
	public static void muestraMenu() {
		System.out.println("");
		//System.out.println("--------------------------");
		System.out.println("  ___   _                       _      __   _          _      _               \r\n"
				+ " / __| | |_   _ _   ___   ___  | |_   / _| (_)  __ _  | |_   | |_   ___   _ _ \r\n"
				+ " \\__ \\ |  _| | '_| / -_) / -_) |  _| |  _| | | / _` | | ' \\  |  _| / -_) | '_|\r\n"
				+ " |___/  \\__| |_|   \\___| \\___|  \\__| |_|   |_| \\__, | |_||_|  \\__| \\___| |_|  \r\n"
				+ "                                               |___/                          ");
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                         1. Jugar                                         |");
		System.out.println("|                         2. Opciones                                      |");
		System.out.println("|                         0. Salir                                         |");
		System.out.println("+--------------------------------------------------------------------------+");
	}
	
	/**
	 * Este método muestra un submenú llamado "opciones".
	 */
	public static void menuOpciones(boolean ayuda) {
		System.out.println("");
		System.out.println("_______                 _____                              \r\n"
				+ "__  __ \\________ __________(_)______ _______ _____ ________\r\n"
				+ "_  / / /___  __ \\_  ___/__  / _  __ \\__  __ \\_  _ \\__  ___/\r\n"
				+ "/ /_/ / __  /_/ // /__  _  /  / /_/ /_  / / //  __/_(__  ) \r\n"
				+ "\\____/  _  .___/ \\___/  /_/   \\____/ /_/ /_/ \\___/ /____/  \r\n"
				+ "        /_/                                                ");
		System.out.println("");
		System.out.println("1. Activar o desactivar ayuda: Por defecto, viene activada.\nCon la ayuda activa, tendrás una breve descripción de las stats de cada personaje.");
		if(ayuda) {
			System.out.println("Estado: Activada");
		}else {
			System.out.println("Estado: Desactivada");
		}
		System.out.println("");
		System.out.println("2. Créditos.");
		System.out.println("");
		System.out.println("0. Volver al menú principal.");
		System.out.println("----------------------------------------------------------");
	}

	/**
	 * Función que permite al usuario elegir una de las opciones del menú al usuario, siendo tolerante a fallos.
	 * @return x: devuelve la opción del menú elegida por el usuario
	 */
	public static int opcMenu() {
		Scanner s = new Scanner(System.in);
		int x = -1;
		boolean valid = false;
		do {
			try {
					x = s.nextInt();

					if (x > -1 && x < 3) {

						switch (x) {
						case 1:
							System.out.println("Creando partida...");
							valid = true;
							break;
						case 2:
							System.out.println("Abriendo menú de opciones...");
							valid = true;
							break;
						case 0:
							System.out.println("Saliendo...");
							valid = true;
							break;
						}
					} else {
						System.out.println("Introduce una opcion del menú correcta.");
					}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Introduce una opcion del menú correcta.");
				s.next();
			}
		} while (!valid);

		return x;
	}
	
	/**
	 * Este método hace que el usuario pueda elegir una de las opciones del menu de opciones con tolerancia a fallos.
	 * @param ayuda: Para activar o desactivar la ayuda.
	 * @return Devuelve la variable boolean para guardar los cambios recibidos en la ayuda y más adelante poder ser útil.
	 */
	public static boolean opcMenuOpciones(boolean ayuda) {
		Scanner s = new Scanner(System.in);
		int x=-1;
		boolean valid= false;
		
		do {
			try {
				x = s.nextInt();

				if (x > -1 && x < 3) {

					switch (x) {
					case 1: if(ayuda) {
						System.out.println("La ayuda ha sido DESACTIVADA.");
						ayuda=false;
					}else if(!ayuda){
						System.out.println("La ayuda ha sido ACTIVADA.");
						ayuda=true;
					}
					menuOpciones(ayuda);
						//valid = true;
						break;
					case 2:
						System.out.println("*´¨) \r\n"
								+ "¸.•´¸.•*´¨) ¸.•*¨) \r\n"
								+ "(¸.•´ (¸.•` ¤ Rafael Ángel Gilarte Núñez ");
						menuOpciones(ayuda);
						//valid = true;
						break;

					case 0:
						System.out.println("Saliendo...");
						valid = true;
						break;
					}
				} else {
					System.out.println("Introduce una opcion del menú correcta.");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Introduce una opcion del menú correcta.");
				s.next();
			}
		}while(!valid);
		return ayuda;
	}
	
	
	
	
	/**
	 * Esta función da a elegir al usuario el número de jugadores con el que quiere jugar. El número deberá estar comprendido entre
	 * 2 y 4, ambos incluídos.
	 * @return jugadores: devolverá el número de jugadores que van a jugar.
	 */
	public static int numJugadores() {
		int jugadores=-1;
		boolean valid=false;
		Scanner s=new Scanner(System.in);
		do {
			try {
				jugadores=s.nextInt();
				if(jugadores>1 && jugadores<5) {
					valid=true;
				}else {
					System.out.println("Introduce un número de jugadores válido.");
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Introduce un número de jugadores válido.");
				s.next();

			}
		}while(!valid);
		
		return jugadores;
	}
	
	/**
	 * Es un simple método que permite introducir un String y ser validado con tolerancia a fallos
	 * @param f: una frase que indique al usuario que tiene que escribir.
	 * @return devuelve el String del usuario ya validado.
	 */
	public static String leeString(String f) {
		Scanner s=new Scanner(System.in);
		String x="";
		try {
			
			x=s.next();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Debes introducir un nombre");
		}
		return x;
	}
	
	
	/**
	 
	public static void preLucha(String p1, int vida, int ataque, int defensa, String p2) {
		System.out.println("\n+----------------------------+" );    
        System.out.println("|    Personaje:"+p1+ "          |"  );
        System.out.println("+----------------------------+" );
        System.out.println("| Vida: "+personaje.getVida()+"                    |");
        System.out.println("| Ataque: "+personaje.getAtaque()+"                  |");
        System.out.println("| Defensa: "+personaje.getDefensa()+"                 |");          
        System.out.println("+----------------------------+"  );
         System.out.println("");
         System.out.println("_    __ ");   
         System.out.println("| |  / /____");
         System.out.println("| | / / ___/");
         System.out.println("| |/ (__  )"); 
         System.out.println("|___/____/");
        System.out.println("");    
        System.out.println("\n+----------------------------+" );    
        System.out.println("|    Personaje:"+enemigo.getNombre()+ "          |"  );
        System.out.println("+----------------------------+" );
        System.out.println("| Vida: "+enemigo.getVida()+"                    |");
        System.out.println("| Ataque: "+enemigo.getAtaque()+"                  |");
        System.out.println("| Defensa: "+enemigo.getDefensa()+"                 |");          
        System.out.println("+----------------------------+"  );

        pulsarEnter();
            System.out.println("");
	}
	*/
}
