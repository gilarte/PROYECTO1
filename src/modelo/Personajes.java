package modelo;

import java.util.Objects;

public class Personajes {

	private String nombre;
	private int salud;
	private int defensa;
	private int daño;
	
	/**
	 * Constructor complejo de personajes, el cual necesita las siguientes variables para crear un personaje.
	 * @param nombre
	 * @param salud
	 * @param defensa
	 * @param daño
	 */
	public Personajes(String nombre, int salud, int defensa, int daño) {
		super();
		this.nombre = nombre;
		this.salud = salud;
		this.defensa = defensa;
		this.daño = daño;
	}

	/**
	 * constructor de personaje que únicamente necesita el nombre para crear un personaje y las demas stats se generan
	 * por defecto.
	 * @param name nombre del personaje que se va a crear
	 */
	public Personajes(String name) {
		super();
		this.nombre = name;
		this.salud = 100;
		this.defensa = 0;
		this.daño = 0;
	}

	/**
	 * constructor de personajes por defecto.
	 */
	public Personajes() {
		super();
		this.nombre = "";
		this.salud = 100;
		this.defensa = 0;
		this.daño = 0;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	/**
	 * Método muy importante a la hora de la lucha, ya que es el que permite atacar a un personaje
	 * @param daño: es el número que tiene en la stat de daño el personaje que va a atacar.
	 * @return el daño que va a hacer atacando, será un número aleatorio entre 1 y el daño que tiene ese personaje
	 */
	public int atacar(int daño) {
		int ataque1=(int) (Math.random() * getDaño()) + 1;
		
		
		return ataque1;
	}
	
	/**
	 * Método muy importante a la hora de la lucha, ya que es el que permite defender a un personaje
	 * @param defensa: es el número que tiene en la stat de defensa el personaje que va a atacar.
	 * @return la defensa que va a tener un personaje a la hora de ser atacado.
	 */
	public int defender(int defensa) {
		int defensa1=(int) (Math.random() * getDefensa()) + 1;

		return defensa1;
	}
	
	
	@Override
	public String toString() {
		return "Personajes [nombre=" + nombre + ", salud=" + salud + ", defensa=" + defensa + ", daño=" + daño + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null) {
			if (this == obj) {
				result = true;
			} else {
				if (this.getClass() == obj.getClass()) {
					Personajes tmp = (Personajes) obj;
					if (tmp != null && this.nombre != null && this.nombre == tmp.nombre) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	
	
}
