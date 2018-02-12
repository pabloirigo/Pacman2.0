package Ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Clases.Usuario;

public class GestionFicheros {

	/** Metodo que vuelca el fichero al array de usuarios */
	public static ArrayList<Usuario> volcarFicheroArrayUsuarios(String nomfich) {
		ArrayList<Usuario> aUsuarios = new ArrayList<Usuario>();
		try {
			FileInputStream fis = new FileInputStream(nomfich);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Usuario u = (Usuario) ois.readObject();
			while (u != null) {
				aUsuarios.add(u);
				u = (Usuario) ois.readObject();
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aUsuarios;
	}

	/** Metodo que vuelca el array de usuarios al fichero */
	public static void volcarArrayUsuariosFichero(String nomfich, ArrayList<Usuario> aUsuarios) {
		try {
			FileOutputStream fos = new FileOutputStream(nomfich);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < aUsuarios.size(); i++) {
				Usuario u = aUsuarios.get(i);
				oos.writeObject(u);
			}
			oos.writeObject(null);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object[][] volcarFicheroArray(File f){
		Object [][] aBi = new Object[25][25];
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			for(int i=0;i<aBi.length;i++) {
				for(int j=0;j<aBi[i].length;j++) {
					aBi[i][j] = ois.readObject();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aBi;
	}
	
	


}

