package miPaquete;

public class Campeon {
	String nombre, maestria, puntos, cofre;

	public Campeon(String nombre, String maestria, String puntos, String cofre) {
		super();
		this.nombre = nombre;
		this.maestria = maestria;
		this.puntos = puntos;
		this.cofre = cofre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMaestria() {
		return maestria;
	}

	public String getPuntos() {
		return puntos;
	}

	public String getCofre() {
		return cofre;
	}
	
}
