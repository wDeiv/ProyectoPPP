
package proyecto.com.modelo.config;

/**
 *
 * @author angel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    
    private static Connection cx;
    
    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            if(cx==null){
                cx=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.16:1521:XE","C##PPP","123");
            }
        } catch (Exception e) {
            System.out.println("Conexion: "+e);
        }
        return cx;
    }
}

