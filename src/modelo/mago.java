package modelo;

public class mago extends Personajes{
	
	private int poderDefensaEspecial;

	public mago(String nombre, int salud, int defensa, int daño, int poderDefensaEspecial) {
		super(nombre, salud, defensa, daño);
		this.poderDefensaEspecial = poderDefensaEspecial;
	}

	public int getPoderDefensaEspecial() {
		return poderDefensaEspecial;
	}

	public void setPoderDefensaEspecial(int poderDefensaEspecial) {
		this.poderDefensaEspecial = poderDefensaEspecial;
	}
	
	@Override
	public int defender(int defensa) {
		int defensa1=(int) (Math.random() * getDefensa()) + 1;

		return defensa1+getPoderDefensaEspecial();
	}
	
	@Override
	public String toString() {
		return super.toString()+"mago [poderDefensaEspecial=" + poderDefensaEspecial + "]";
	}

	


	

	
	
}
