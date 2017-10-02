package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TiposDeDatos.Usuario;

public class BD {
	
	private Connection con;
	private static Statement stmt;
	
	/**Metodo que crea una sentencia para acceder a la base de datos*/
	public void crearSentencia()
	{
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**Metodo que permite conectarse a la base de datos*/

	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			con= DriverManager.getConnection("jdbc:sqlite:Pacman.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos.");
			e.printStackTrace();
		}
	}
	
	/**Metodo que cierra una sentencia*/
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**Metodo que permite desconectarse de la base de datos*/
	public void desconectar()
	{
		try {
			cerrarSentencia();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**Metodo que conecta con la base de datos*/
	public BD(){
		conectar();
	}
	
	public ArrayList<String> obtenerFotos(){
		ArrayList<String> aFotos = new ArrayList<String>();
		
		String query="SELECT RutaFoto FROM componentes";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				aFotos.add(rs.getString("RutaFoto"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aFotos;
	}
	
	public Usuario obtenerUsuario(String nombre){
		String query;
		Usuario u = null;
		
		query = "SELECT * FROM registrousuarios WHERE nombreUsuario='"+ nombre +"'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
				u = new Usuario(rs.getString("nombreUsuario"), rs.getString("contrasenia"));
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;		
	}
	
	public void insertarNuevoUsuario (Usuario u){
		String query = "INSERT INTO registrousuarios (nombreUsuario,contrasenia) VALUES ('"+u.getNombreUsuario()+"','"+u.getContrasenia()+")";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
