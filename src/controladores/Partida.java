package controladores;

import java.util.Arrays;
import java.util.Scanner;

import modelo.Personajes;
import modelo.guerrero;
import modelo.mago;

public class Partida {

	/**
	 * Este método es el que se ejecuta cuando se inicia la partida. Es el que llama a todos los métodos involucrados a
	 * la hora de jugar.
	 * @param ayuda: recibe la variable ayuda para saber como mostrar los personajes.
	 */
	public static void partida(boolean ayuda) {
		System.out.println("");
		System.out.println(
				"¡Bienvenido!\nEl juego consiste en escoger a un numero de personaje que tu quieras y ellos lucharán todos contra todos.\n!El ganador será el último personaje en pie!\nPara empezar, indica cuantos jugadores hay.\nNOTA: tiene que haber un mínimo de 2 y un máximo de 4.");
		Partida.iniciaPartida(utils.numJugadores(), Partida.creaPersonajes(ayuda));
	}

	/**
	 * Este método es el que crea el array de personajes, crea personajes con unas stats a fuego, los mete en el array
	 * de personajes a fuego y muestra a los personajes por pantalla.
	 * @param ayuda: Aqui esta la clave de porque se ha arrastrado tanto esta variable, y es simplemente para mostrar
	 * de una forma u otra (segun haya elegido el usuario) a los personajes.
	 * @return Devuelve el array de personajes ya rellenado por personajes
	 */
	public static Personajes[] creaPersonajes(boolean ayuda) {
		mago a1 = new mago("veigar", 50, 15, 20, 20); //String nombre, int salud, int defensa, int daño
		mago a2 = new mago("Ahri", 50, 25, 15, 20);
		guerrero a3 = new guerrero("Yasuo", 50, 10, 15, 20);
		guerrero a4 = new guerrero("Yone", 50, 15, 20, 20);

		Personajes campeones[] = { a1, a2, a3, a4 };

		for (int i = 0; i < campeones.length; i++) {
			if (ayuda) {
				// System.out.println(campeones[i]);
				System.out.println("\n +----------------------------+");
				System.out.println("|    Personaje:" + campeones[i].getNombre() + "|");
				System.out.println("+----------------------------+");
				System.out.println("| Vida: " + campeones[i].getSalud() + "                   |");
				System.out.println("| Ataque: " + campeones[i].getDaño() + "                 |");
				System.out.println("| Defensa: " + campeones[i].getDefensa() + "                |");
				System.out.println("+----------------------------+");
				System.out.println("");
			} else {
				System.out.println(campeones[i].getNombre());

			}
		}

		return campeones;

	}

	/**
	 * Este método crea un nuevo array de personajes y lo rellena de los personajes que ha elegido el usuario para jugar.
	 * @param jugadores: es la cantidad de personajes que se va a escoger
	 * @param campeones: es el array de donde se van a sacar los personajes disponibles para jugar.
	 * @return: Devuelve el array de personajes que van a jugar.
	 */
	public static Personajes[] iniciaPartida(int jugadores, Personajes campeones[]) {
		boolean valid = true;
		int contador = 0;
		Personajes juegan[] = new Personajes[jugadores];
		do {
			try {
				String elegido = utils.leeString("Escoge " + jugadores + " personajes.");
				for (int i = 0; i < campeones.length; i++) {
					for (int j = 0; j < juegan.length; j++) {
						if (campeones[i].getNombre().equals(elegido) && juegan[j] == null) {
							juegan[j] = campeones[i];
							System.out.println("se ha elegido el personaje " + juegan[j] + " con éxito.");
							valid = false;
							contador++;
							j = juegan.length;
						}
					}
				}

				for (int i = 0; i < juegan.length; i++) {
					if (valid == true && juegan[i].getNombre().equals(elegido)) {
						System.out.println("El personaje seleccionado ya ha sido elegido.");
					}
				}

				valid = true;
			} catch (Exception e) {
				System.out.println("Introduce el nombre del personaje correctamente.");
			}
			
		} while (contador != jugadores);
		System.out.println("");
		System.out.println("Todos los personajes se han añadido con éxito.");

		System.out.println("Pulsa intro para luchar...");
		Scanner s = new Scanner(System.in);
		s.nextLine();
		System.out.println("");
		System.out.println("Y el ganador es...");
		ordenaPersonaje(juegan);

		return juegan;
	}

	/**
	 * Este método me ha sido muy clave porque me permite ordenar a los personajes y asignarle a cada personaje una
	 * variable para poder llamarlos mas facilmente a la hora de luchar.
	 * @param juegan: recibe el array de personajes que van a luchar
	 */
	public static void ordenaPersonaje(Personajes juegan[]) {
		Personajes p1 = new Personajes();
		Personajes p2 = new Personajes();
		Personajes p3 = new Personajes();
		Personajes p4 = new Personajes();

		for (int i = 0; i < juegan.length; i++) {
			if (juegan.length == 2) {
				p1 = juegan[0];
				p2 = juegan[1];
				lucha(p1,p2);
				i=juegan.length;
			} else if (juegan.length == 3) {
				p1 = juegan[0];
				p2 = juegan[1];
				p3 = juegan[2];
				lucha(p1,p2,p3);
				i=juegan.length;
			} else if (juegan.length == 4) {
				p1 = juegan[0];
				p2 = juegan[1];
				p3 = juegan[2];
				p4 = juegan[3];
				lucha(p1,p2,p3,p4);
				i=juegan.length;
			}
		}
		// lucha(juegan);
	}

	/**
	 * Esta función es la que permite a los personajes luchar por turnos segun las stats de cada uno. En este caso va a
	 * recibir dos personajes porque la lucha va a ser entre dos.
	 * @param p1
	 * @param p2
	 */
	public static void lucha(Personajes p1, Personajes p2) {

		do {
			
			
			//Ataca p1:
			int result1=(p2.getSalud()+p2.defender(p2.getDefensa()))-p1.atacar(p1.getDaño());
			p2.setSalud(result1);
			
			//Ataca p2:
			int result2=(p1.getSalud()+p1.defender(p1.getDefensa()))-p2.atacar(p2.getDaño());
			p1.setSalud(result2);
			
			if(p1.getSalud()<1) {
				p1=null;
			}else if(p2.getSalud()<1) {
				p2=null;
			}
		}while(p1!=null && p2!=null);
		
		if(p1==null) {
			System.out.println(p2.getNombre()+" Es el ganador.");
		}else if(p2==null) {
			System.out.println(p1.getNombre()+" Es el ganador.");
		}
	}

	/**
	 * Esta función es la que permite a los personajes luchar por turnos segun las stats de cada uno. En este caso va a
	 * recibir tres personajes porque la lucha va a ser entre tres.
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public static void lucha(Personajes p1, Personajes p2,Personajes p3) {
do {
			
			
			//Ataca p1:
			int result1=(p2.getSalud()+p2.defender(p2.getDefensa()))-p1.atacar(p1.getDaño());
			p2.setSalud(result1);
			
			//Ataca p2:
			int result2=(p3.getSalud()+p3.defender(p3.getDefensa()))-p2.atacar(p2.getDaño());
			p3.setSalud(result2);
			
			//Ataca p3:
			int result3=(p1.getSalud()+p1.defender(p1.getDefensa()))-p3.atacar(p3.getDaño());
			p1.setSalud(result3);
			
			if(p1.getSalud()<1) {  //p1 muerto
				p1=null;
				do {
					//Ataca p2:
					int result4=(p3.getSalud()+p3.defender(p3.getDefensa()))-p2.atacar(p2.getDaño());
					p3.setSalud(result4);
					
					//Ataca p3:
					int result5=(p2.getSalud()+p2.defender(p2.getDefensa()))-p3.atacar(p3.getDaño());
					p2.setSalud(result5);
					
					if(p2.getSalud()<1) {
						p2=null;
					}else if(p3.getSalud()<1) {
						p3=null;
					}
				}while(p2!=null && p3!=null);
				
				
			}else if(p2.getSalud()<1) {  //p2 muerto
				p2=null;
				do {
					//Ataca p1:
					int result4=(p3.getSalud()+p3.defender(p3.getDefensa()))-p1.atacar(p1.getDaño());
					p3.setSalud(result4);
					
					//Ataca p3:
					int result5=(p1.getSalud()+p1.defender(p1.getDefensa()))-p3.atacar(p3.getDaño());
					p1.setSalud(result5);
					
					
					if(p1.getSalud()<1) {
						p1=null;
					}else if(p3.getSalud()<1) {
						p3=null;
					}
				}while(p1!=null && p3!=null);
				
				
			}else if(p3.getSalud()<1) {  //p3 muerto
				p3=null;
				do {
					//Ataca p1:
					int result4=(p2.getSalud()+p2.defender(p2.getDefensa()))-p1.atacar(p1.getDaño());
					p2.setSalud(result4);
					
					//Ataca p2:
					int result5=(p1.getSalud()+p1.defender(p1.getDefensa()))-p2.atacar(p2.getDaño());
					p1.setSalud(result5);
					
					if(p1.getSalud()<1) {
						p1=null;
					}else if(p2.getSalud()<1) {
						p2=null;
					}
				}while(p1!=null && p2!=null);
			}
			
			
		}while((p1!=null && p2!=null) || (p1!=null && p3!=null) || (p3!=null && p2!=null));
		
		if(p1==null && p3==null) {
			System.out.println(p2.getNombre()+" Es el ganador.");
		}else if(p2==null && p3==null) {
			System.out.println(p1.getNombre()+" Es el ganador.");
		}else if(p1==null && p2==null) {
			System.out.println(p3.getNombre()+" Es el ganador.");
		}
	}

	/**
	 * Esta función es la que permite a los personajes luchar por turnos segun las stats de cada uno. En este caso va a
	 * recibir cuatro personajes porque la lucha va a ser entre cuatro.
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 */
	public static void lucha(Personajes p1, Personajes p2,Personajes p3,Personajes p4) {
do {
			
			
			//Ataca p1:
			int result1=(p2.getSalud()+p2.defender(p2.getDefensa()))-p1.atacar(p1.getDaño());
			p2.setSalud(result1);
			
			//Ataca p2:
			int result2=(p3.getSalud()+p3.defender(p3.getDefensa()))-p2.atacar(p2.getDaño());
			p3.setSalud(result2);
			
			//Ataca p3:
			int result3=(p4.getSalud()+p4.defender(p4.getDefensa()))-p3.atacar(p3.getDaño());
			p4.setSalud(result3);
			
			//Ataca p4:
			int result4=(p1.getSalud()+p1.defender(p1.getDefensa()))-p3.atacar(p3.getDaño());
			p1.setSalud(result4);
			
			
			if(p1.getSalud()<1) {  //p1 muerto
				p1=null;
				do {
					//Ataca p2:
					int result6=(p3.getSalud()+p3.defender(p3.getDefensa()))-p2.atacar(p2.getDaño());
					p3.setSalud(result6);
					
					//Ataca p3:
					int result5=(p4.getSalud()+p4.defender(p4.getDefensa()))-p3.atacar(p3.getDaño());
					p4.setSalud(result5);
					
					//Ataca p4:
					int result7=(p2.getSalud()+p2.defender(p2.getDefensa()))-p3.atacar(p3.getDaño());
					p2.setSalud(result7);
					
					if(p2.getSalud()<1) {  //p2 ha muerto: (quedan p3 y p4).
						p2=null;
						
						do {
							//Ataca p3:
							int result8=(p4.getSalud()+p4.defender(p4.getDefensa()))-p3.atacar(p3.getDaño());
							p4.setSalud(result8);
							
							//Ataca p4:
							int result9=(p3.getSalud()+p3.defender(p3.getDefensa()))-p4.atacar(p4.getDaño());
							p3.setSalud(result9);
							
							if(p3.getSalud()<1) {
								p3=null;
							}else if(p4.getSalud()<1) {
								p4=null;
							}
						}while(p3!=null && p4!=null);
						
						
					}else if(p3.getSalud()<1) {  //p3 ha muerto: quedan p2 y p4
						p3=null;
						
						do {
							//Ataca p2:
							int result8=(p4.getSalud()+p4.defender(p4.getDefensa()))-p2.atacar(p2.getDaño());
							p4.setSalud(result8);
							
							//Ataca p4:
							int result9=(p2.getSalud()+p2.defender(p2.getDefensa()))-p4.atacar(p4.getDaño());
							p2.setSalud(result9);
							
							if(p2.getSalud()<1) {
								p2=null;
							}else if(p4.getSalud()<1) {
								p4=null;
							}
						}while(p2!=null && p4!=null);
						
					}else if(p4.getSalud()<1) {  //p4 ha muerto: quedan p2 y p3
						p4=null;
						
						do {
							//Ataca p2:
							int result8=(p3.getSalud()+p3.defender(p3.getDefensa()))-p2.atacar(p2.getDaño());
							p3.setSalud(result8);
							
							//Ataca p3:
							int result9=(p2.getSalud()+p2.defender(p2.getDefensa()))-p3.atacar(p3.getDaño());
							p2.setSalud(result9);
							
							if(p2.getSalud()<1) {
								p2=null;
							}else if(p3.getSalud()<1) {
								p3=null;
							}
						}while(p3!=null && p4!=null);
						
					}
				}while(p2!=null && p3!=null);
				
				
				
			}else if(p2.getSalud()<1) {  //p2 muerto
				p2=null;
				do {
					//Ataca p1:
					int result6=(p3.getSalud()+p3.defender(p3.getDefensa()))-p1.atacar(p1.getDaño());
					p3.setSalud(result6);
					
					//Ataca p3:
					int result5=(p4.getSalud()+p4.defender(p4.getDefensa()))-p3.atacar(p3.getDaño());
					p1.setSalud(result5);
					
					//Ataca p4:
					int result7=(p1.getSalud()+p1.defender(p1.getDefensa()))-p4.atacar(p4.getDaño());
					p1.setSalud(result7);
					
					
					if(p1.getSalud()<1) { //p1 muerto: quedan p3 y p4
						p1=null;
						
						do {
							//Ataca p4:
							int result8=(p3.getSalud()+p3.defender(p3.getDefensa()))-p4.atacar(p4.getDaño());
							p3.setSalud(result8);
							
							//Ataca p3:
							int result9=(p4.getSalud()+p4.defender(p4.getDefensa()))-p3.atacar(p3.getDaño());
							p4.setSalud(result9);
							
							if(p4.getSalud()<1) {
								p4=null;
							}else if(p3.getSalud()<1) {
								p3=null;
							}
						}while(p3!=null && p4!=null);
						
						
					}else if(p3.getSalud()<1) { //p3 ha muerto: quedan p1 y p4
						p3=null;
						
						do {
							//Ataca p4:
							int result8=(p1.getSalud()+p1.defender(p1.getDefensa()))-p4.atacar(p4.getDaño());
							p1.setSalud(result8);
							
							//Ataca p1:
							int result9=(p4.getSalud()+p4.defender(p4.getDefensa()))-p1.atacar(p1.getDaño());
							p4.setSalud(result9);
							
							if(p4.getSalud()<1) {
								p4=null;
							}else if(p1.getSalud()<1) {
								p1=null;
							}
						}while(p1!=null && p4!=null);
						
					
					}else if(p4.getSalud()<1) {  //p4 ha muerto: quedan p1 y p3
						
						do {
							//Ataca p3:
							int result9=(p1.getSalud()+p1.defender(p1.getDefensa()))-p3.atacar(p3.getDaño());
							p1.setSalud(result9);
							
							//Ataca p1:
							int result10=(p3.getSalud()+p3.defender(p3.getDefensa()))-p1.atacar(p1.getDaño());
							p3.setSalud(result10);
							
							if(p3.getSalud()<1) {
								p3=null;
							}else if(p1.getSalud()<1) {
								p1=null;
							}
						}while(p1!=null && p3!=null);
						
					}
					
					
				}while(p1!=null && p3!=null);
				
				
			}else if(p3.getSalud()<1) {  //p3 muerto
				p3=null;
				do {
					//Ataca p1:
					int result6=(p2.getSalud()+p2.defender(p2.getDefensa()))-p1.atacar(p1.getDaño());
					p2.setSalud(result6);
					
					//Ataca p2:
					int result5=(p4.getSalud()+p4.defender(p4.getDefensa()))-p2.atacar(p2.getDaño());
					p4.setSalud(result5);
					
					//Ataca p4:
					int result8=(p1.getSalud()+p1.defender(p1.getDefensa()))-p4.atacar(p4.getDaño());
					p1.setSalud(result8);
					
					if(p1.getSalud()<1) { //p1 ha muerto: quedan p2 y p4
						p1=null;
						
						do {
							//Ataca p2:
							int result10=(p4.getSalud()+p4.defender(p4.getDefensa()))-p2.atacar(p2.getDaño());
							p4.setSalud(result10);
							
							//Ataca p4:
							int result9=(p2.getSalud()+p2.defender(p2.getDefensa()))-p4.atacar(p4.getDaño());
							p2.setSalud(result9);
							
							if(p2.getSalud()<1) {
								p2=null;
							}else if(p4.getSalud()<1) {
								p4=null;
							}
						}while(p2!=null && p4!=null);
						
					}else if(p2.getSalud()<1) {  //p2 ha muerto: quedan p1 y p4
						p2=null;
						
						do {
							//Ataca p1:
							int result10=(p4.getSalud()+p4.defender(p4.getDefensa()))-p1.atacar(p1.getDaño());
							p4.setSalud(result10);
							
							//Ataca p4:
							int result9=(p1.getSalud()+p1.defender(p1.getDefensa()))-p4.atacar(p4.getDaño());
							p1.setSalud(result9);
							
							if(p1.getSalud()<1) {
								p1=null;
							}else if(p4.getSalud()<1) {
								p4=null;
							}
						}while(p1!=null && p4!=null);
						
					}else if(p4.getSalud()<1){  //p4 ha muerto: quedan p1 y p2
						p4=null;
						
						do {
							//Ataca p1:
							int result10=(p2.getSalud()+p2.defender(p2.getDefensa()))-p1.atacar(p1.getDaño());
							p2.setSalud(result10);
							
							//Ataca p2:
							int result9=(p1.getSalud()+p1.defender(p1.getDefensa()))-p2.atacar(p2.getDaño());
							p1.setSalud(result9);
							
							if(p1.getSalud()<1) {
								p1=null;
							}else if(p2.getSalud()<1) {
								p4=null;
							}
						}while(p1!=null && p2!=null);
						
					}
				}while(p1!=null && p2!=null);
			}
			
			else if(p4.getSalud()<1) {  //p4 muerto
				p4=null;
				lucha(p1, p2, p3);
			}
			
			
		}while(p1!=null && p2!=null && p3!=null && p4!=null);
		
		if(p1==null && p3==null && p4==null) {
			System.out.println(p2.getNombre()+" Es el ganador.");
		}else if(p2==null && p3==null && p4==null) {
			System.out.println(p1.getNombre()+" Es el ganador.");
		}else if(p1==null && p2==null && p4==null) {
			System.out.println(p3.getNombre()+" Es el ganador.");
		}else if(p1==null && p2==null && p3==null) {
			System.out.println(p4.getNombre()+" Es el ganador.");
		}
	}

	/**
	 * Este método en principio no lo he usado, lo iba a meter como opcion en el menu de opciones para que el usuario
	 * pueda eliminar personajes, y tambien queria crear otro que haga lo contrario, crear personajes, pero me ha 
	 * faltado tiempo. No me ha hecho falta en la lucha porque cuando un personaje moría lo igualaba a null directamente.
	 * @param name: nombre del personaje que se va a eliminar.
	 * @param array: array al que pertenece el personaje que se va a borrar y del array del que se va a borrar.
	 */
	public static void eliminaPersonaje(String name, Personajes array[]) {
		for (int i = 0; i < array.length; i++) {
			if (name.equals(array[i])) {
				System.out.println("El personaje " + array[i] + " Ha sido eliminado.");
				array[i] = null;
				System.out.println(array[i]);
			}
		}
	}

}
