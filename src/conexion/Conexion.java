
package conexion;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
   
    private static java.sql.Connection conn;
    private final String driver;
    private final String user;
    private final String password;
    private final String url;

    public Conexion() {
        conn = null;
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "GMQCitpx1900$"; 
        url = "jdbc:mysql://192.168.2.250:3306/Parqueadero?autoReconnect=true&useSSL=false";
    }

    public java.sql.Connection getConexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Eroor en la conexion" +e.getMessage());
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("Conexion terminada");
        }
    }

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.getConexion();
    }
}
