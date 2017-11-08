package TiposDeDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestionFicheros {

	public GestionFicheros() {
		// TODO Auto-generated constructor stub
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
