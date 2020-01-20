package miPaquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Parseo {
	String api_key = "?api_key=RGAPI-e7f7d4b9-35ff-42f1-a49e-8107fb66be53";

	public String pasarNombreInvocador(String nombreInvocador) {
		String urlInicial = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + nombreInvocador
				+ api_key;
		String todo = "";
		try {
			URL url = new URL(urlInicial);
			URLConnection conexion = url.openConnection();
			BufferedReader bf = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String texto = bf.readLine();
			while (texto != null) {
				todo += texto;
				texto = bf.readLine();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todo;

	}

	public String parsearParaID(String todo) {
		JSONObject json;
		json = new JSONObject(todo);
		String miID = json.getString("id");
		return miID;
	}

	public String sacarContenidoID(String id) {
		String urlConID = "https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/" + id
				+ api_key;
		String todo = "";
		try {
			URL url = new URL(urlConID);
			URLConnection conexion = url.openConnection();
			BufferedReader bf = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String texto = bf.readLine();
			while (texto != null) {
				todo += texto;
				texto = bf.readLine();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todo;
	}

	public ArrayList<Campeon> parseoFinalDatos(String contenidoaParsearConMiID) {
		ArrayList<Campeon> campeones = new ArrayList<Campeon>();
		JSONArray json;
		json = new JSONArray(contenidoaParsearConMiID);
		for (int i = 0; i < json.length(); i++) {
			JSONObject camp = json.getJSONObject(i);
			String nombre = String.valueOf(camp.getInt("championId"));
			String maestria = String.valueOf(camp.getInt("championLevel"));
			String puntos = String.valueOf(camp.getInt("championPoints"));
			String cofre = String.valueOf(camp.getBoolean("chestGranted"));
			campeones.add(new Campeon(nombre, maestria, puntos, cofre));
		}

		return campeones;
	}

}
