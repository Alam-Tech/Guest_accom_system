package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

import controller.AfterLoginController;

public class DbInterface {
    private static Connection con;
    private static DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    private static int compare_dates(String former,String latter){
        try{
            Date former_date = formatter.parse(former);
            Date latter_date = formatter.parse(latter);
            if(former_date.before(latter_date)) return -1;
            else if(latter_date.before(former_date)) return 1;
            else return 0;
        }catch(Exception e){
            System.out.println("Exception occured in compare_dates(): "+e);
            return -2;
        }
    }

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

    public static void update_tables(int user_id){
        ArrayList<Object[]> active_bookings = new AfterLoginController().get_active_bookings(user_id);
        String today = formatter.format(new Date()); 

        for(Object[] element:active_bookings){
            if(element[6].equals("confirmed") && compare_dates(today, (String)element[5]) == 1){
                boolean updated = DbBookings.cancel_booking((Integer)element[0], true);
                if(!updated) System.out.println("Couldn't update bill no: "+element[0]);
            }
        }
        System.out.println("Booking tables updated for user id: "+user_id);
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
