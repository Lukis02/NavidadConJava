import java.sql.SQLException;
import java.util.*;
import java.io.*;
public class tareasjava {
    static final String JDBC_DRIVER="org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/tareas";
    static final String User = "root";
    static final String Pass = "";
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿qué desea?");
        System.out.println("presiona intro para crear la tabla");
        System.out.println("1--Nueva tarea");
        System.out.println("2--ver tareas");
        System.out.println("3--completar tarea");
        System.out.println("4--eliminar tarea");
        int num = sc.nextInt();
        switch (num){
            default :
                System.out.println("Por favor, introduce un dato válido");
            break;
            case 1:
                opciones.insertardatos();
            break;
            case 2:
                opciones.obtener_result();
            break;


            }
        }
    }

