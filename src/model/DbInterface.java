package model;

import java.sql.*;

public class DbInterface {
    private static Connection con;

    private static void commit(){
        try{
            Statement smt = con.createStatement();
            smt.execute("Commit");
        }catch(SQLException e) {System.out.println("Exception: "+e);}
    }

    public static ResultSet fetch_table(String query){
        ResultSet rs = null;
        try{
            Statement smt = con.createStatement();
            rs = smt.executeQuery(query);
        }catch(Exception e){
            System.out.println("Exception in fetch_table(): "+e);
        }
        return rs;
    }

    public static boolean initialize(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            return true;
        }catch(Exception e){
            System.out.println("Exeption occured during db init: "+e);
        }
        return false;
    }   

    public static int update_row(String query){
        try{
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(query);
            commit();
            return result;
        }catch(Exception e){
            System.out.println("Exception occured in update_query: "+e);
        }
        return -1;
    }
    
    public static int insert_row(String query){
        try{
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(query);
            commit();
            return result;
        }catch(Exception e){
            System.out.println("Exception occured during insert operation: "+e);
        }
        return -1;
    }
}
