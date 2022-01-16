package modelo;

public class guerrero extends Personajes{
	
	private int poderAtaqueEspecial;

	public guerrero(String nombre, int salud, int defensa, int da�o, int poderAtaqueEspecial) {
		super(nombre, salud, defensa, da�o);
		this.poderAtaqueEspecial = poderAtaqueEspecial;
	}

	public int getPoderAtaqueEspecial() {
		return poderAtaqueEspecial;
	}

	public void setPoderAtaqueEspecial(int poderAtaqueEspecial) {
		this.poderAtaqueEspecial = poderAtaqueEspecial;
	}

	@Override
	public int atacar(int da�o) {
		int ataque1=(int) (Math.random() * getDa�o()) + 1;

		
		return ataque1+getPoderAtaqueEspecial();
	}
	
	
	@Override
	public String toString() {
		return super.toString()+"guerrero [poderAtaqueEspecial=" + poderAtaqueEspecial + "]";
	}




	

	
}
