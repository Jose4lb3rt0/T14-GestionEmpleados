package config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    static String bd = "bdalumno";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+ bd;
    
    public static Connection conec = null;
    public static ResultSet rs = null;
    public static Statement st = null;

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conec = java.sql.DriverManager.getConnection(url, login, password);
            System.out.println("Conexión exitosa a la base de datos: " + bd);
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return conec;
    }
    
    public static void cerrarConexion(){
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conec != null) conec.close();
            System.out.println("Conexión cerrada.");
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
