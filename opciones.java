import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class opciones {
    static ArrayList<resultado>result= new ArrayList<>();
    static final String JDBC_DRIVER="org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/tareas";
    static final String User = "root";
    static final String Pass = "";
    static Scanner sc= new Scanner(System.in);


    public static void creartabla(){
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("connecting to a selected database....");
            conn= DriverManager.getConnection(DB_URL,User,Pass);
            System.out.println("Connected database successfully....");

            System.out.println("creating table in given database....");
            stmt=conn.createStatement();
            String sql="CREATE TABLE tarea "
                    +"(descripcion VARCHAR(255), "
                    +", (FechayHora DATETIME)";
            stmt.executeUpdate(sql);
            System.out.println("created table in given database...");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null){
                    conn.close();
                }
            } catch (SQLException se) {
            }try {
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException se) {
            }
        }
        System.out.println("goodbye");
    }
    public static void insertardatos(){

        SimpleDateFormat plantilla= new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("Introduce la tarea");
        String descripcion=sc.nextLine();





        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("connecting to a selected database....");
            conn= DriverManager.getConnection(DB_URL,User,Pass);
            System.out.println("Connected database successfully....");

            System.out.println("creating table in given database....");
            stmt=conn.createStatement();

            String consulta="INSERT INTO tarea VALUES(?, ?)";

            PreparedStatement prpStateent= conn.prepareStatement(consulta);
            prpStateent.setString(1,descripcion);
            prpStateent.setString(2,);



            ResultSet rs= prpStateent.executeQuery();





            /*String  sql = "INSERT INTO tarea "
                    + "VALUES('"+descripcion+"')";

            stmt.executeUpdate(sql);*/
            System.out.println("adding dates into tarea...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (stmt!=null){
                    conn.close();
                }
            } catch (SQLException se) {
            }try {
                if (conn!=null){
                    conn.close();
                }
            }catch (SQLException se) {
            }
        }
        System.out.println("goodbye");
    }

    public static void obtener_result() throws SQLException {

        Connection conn= DriverManager.getConnection(DB_URL,User,Pass);
        Statement  stmt= conn.createStatement();
        String sql="select * from tarea";
        PreparedStatement prpStatement= conn.prepareStatement(sql);
        ResultSet rs= prpStatement.executeQuery();
        while (rs.next()){
            result.add(new resultado(rs.getString(1),rs.getBoolean(2)));

        }
        System.out.println(result.toString());


    }

    public static void borrar_datos() throws SQLException {

    }
}


