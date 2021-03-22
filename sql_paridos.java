import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class sql_paridos {
   static ArrayList<Resultado>result= new ArrayList<>();
    static final String JDBC_DRIVER="org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/dam";
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
            String sql="CREATE TABLE Equipo "
                    +"(local VARCHAR(255), "
                    +"visitante VARCHAR(255), "
                    +"resultado VARCHAR(50), "
                    +"arbrito VARCHAR(50), "
                    +"fecha DATE)";
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
        Date date= new Date();

       SimpleDateFormat plantilla= new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("dame el nombre del equipo local");
        String local=sc.nextLine();
        System.out.println("dame el nombre dle equipo visitante");
        String visitante=sc.nextLine();
        System.out.println("dame el resultado");
        String resultado=sc.nextLine();
        System.out.println("nombre del arbrito");
        String arbrito=sc.nextLine();
        System.out.println("dame la Fecha de cuando se jugo(yyyy-mm-dd)");
        String fecha=sc.nextLine();
        try {
            date=plantilla.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date d_sql= new java.sql.Date(date.getTime());

        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("connecting to a selected database....");
            conn= DriverManager.getConnection(DB_URL,User,Pass);
            System.out.println("Connected database successfully....");

            System.out.println("creating table in given database....");
            stmt=conn.createStatement();

            String consulta="INSERT INTO Equipo VALUES(?, ?, ?, ?, ?)";

            PreparedStatement prpStateent= conn.prepareStatement(consulta);
            prpStateent.setString(1,local);

            prpStateent.setString(2,visitante);

            prpStateent.setString(3,resultado);

            prpStateent.setString(4,arbrito);

            prpStateent.setDate(5,d_sql);


            ResultSet rs= prpStateent.executeQuery();





            /*String  sql = "INSERT INTO Equipo "
                    + "VALUES('"+local+"','"+visitante+"','"+resultado+"','"+arbrito+"','"+d_sql+"')";

            stmt.executeUpdate(sql);*/
            System.out.println("adding dates into Equipo...");
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
         String sql="select * from equipo";
            PreparedStatement prpStatement= conn.prepareStatement(sql);
            ResultSet rs= prpStatement.executeQuery();
            while (rs.next()){
                result.add(new Resultado(rs.getString("local"),rs.getString("visitante"),rs.getString("resultado"),rs.getString("arbrito"),rs.getDate("fecha") ));
            }
        System.out.println(result.toString());


    }

    public static void borrar_datps() throws SQLException {
        Connection conn= DriverManager.getConnection(DB_URL,User,Pass);
        Statement  stmt= conn.createStatement();
        String sql="delete from equipo where local LIKE ?";


        PreparedStatement prpStatement= conn.prepareStatement(sql);
        prpStatement.setString(1,"madrid");
        ResultSet rs= prpStatement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("local")+" "+ rs.getString("visitante"));
        }
        System.out.println("Mostrado");
    }
}
