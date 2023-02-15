package miPaquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Parseo pa = new Parseo();
		Scanner sc = new Scanner(System.in);
		PersonajesConID pci = new PersonajesConID();
		System.out.println("Nombre de invocador: ");
		String nombreInvocador = sc.nextLine();
		String contenidoaParsear = pa.pasarNombreInvocador(nombreInvocador);
		System.out.println(contenidoaParsear);
		String miID = pa.parsearParaID(contenidoaParsear);
		System.out.println(miID);
		String contenidoaParsearConMiID = pa.sacarContenidoID(miID);
		ArrayList<Campeon> campeones = pa.parseoFinalDatos(contenidoaParsearConMiID);
		
		//Ordenamos el array de campeones por la maestria, y ponemos reversed para que sea descendente
		Collections.sort(campeones, Comparator.comparing(Campeon::getMaestria).reversed());
		
		for (Campeon campeon : campeones) {
			String var = "";
			if (campeon.getCofre().equalsIgnoreCase("false")) {
				var = "NO";
			} else {
				var = "SI";
			}
			System.out.println(pci.personaje(Integer.parseInt(campeon.getNombre())) + ", Maestria: "
					+ campeon.getMaestria() + ", " + campeon.getPuntos() + " puntos, y cofre: " + var);
		}
	}
}
