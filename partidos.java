import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class partidos {
    static final String JDBC_DRIVER="org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/dam";
    static final String User = "root";
    static final String Pass = "";

   public static void main(String[] args) throws SQLException {
        Scanner sc= new Scanner(System.in);

        System.out.println("que deseas hacer");
        System.out.println("1--crear tabla");
        System.out.println("2--insertar datos");
        System.out.println("3--ver datos");
       System.out.println("4--borrar datos");
        int aux=sc.nextInt();
        switch (aux){

            case 1:
                sql_paridos.creartabla();
                break;
            case 2:
                sql_paridos.insertardatos();
                break;
            case 3:
                sql_paridos.obtener_result();
                break;
            case 4:sql_paridos.borrar_datps();
                break;
        }
    }





}
