package model;

import java.sql.*;

public class DbClient {
        /**
     * This function is to get the details of the user using user id.
     * @param user_id The user id of the target user.
     * @return A String array with user_name,password. Null is returned if there is no data/error.
     */
    public static String[] get_user(int user_id){
        String query = "select * from client_record where id = "+user_id;
        ResultSet rs = DbInterface.fetch_table(query);
        String[] result_data = null;
        try{
            if(rs.next()){
                result_data = new String[] {
                    rs.getString("user_name"),
                    rs.getString("password")
                };
            }
        }catch(Exception e){
            System.out.println("Exception occured in get_user(): "+e);
        }
        return result_data;
    }

    /**
     * This function is to fetch user_details using the username(for login)
     * @param user_name The user name of the target user
     * @return An Object array with user id and password.
     * Null is returned if there is no data/error.
     */
    public static Object[] get_user(String user_name){
        String query = "select * from client_record where user_name = '"+user_name+"'";
        ResultSet rs = DbInterface.fetch_table(query);
        Object[] result_data = null;
        try{
            if(rs.next()){
                result_data = new Object[] {
                    rs.getInt("id"),
                    rs.getString("password")
                };
            }
        }catch(Exception e){
            System.out.println("Exception occured in get_user(): "+e);
        }
        return result_data;
    }
    
    public static boolean add_user(int user_id,String user_name,String password){
        String query = String.format("insert into client_record values(%d,'%s','%s')",user_id,user_name,password);
        int inserted = DbInterface.insert_row(query);
        return inserted == 1;
    }
}
