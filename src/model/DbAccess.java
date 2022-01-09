package model;

import java.util.*;
import java.sql.*;

public class DbAccess {
    /**
     * This is function is to fetch the search results of the houses based on the preferences
     * @param num_rooms Number of rooms
     * @param is_elite If the house is elite/normal
     * @param acc_pref Order: Fridge,Washing machine,Oven,AC,Kitchen
     * @param att_bath If attached bathroom is preferred
     * @param loc_pref Order: Swimming pool,Gym,Main Gate
     * @return An arraylist having id,name,price_per_day and photo of houses. 
     * Empty arrayList is returned if no data.
     */
    public static ArrayList<Object[]> search_houses(
        int num_rooms,boolean is_elite,ArrayList<Boolean> acc_pref,
        boolean att_bath,ArrayList<Boolean> loc_pref
    ){
        String query = "select * from house_record where is_free = 1 ";
        query += "and num_rooms = "+num_rooms;
        query += " and elite = "+(is_elite?1:0);

        query += " and FR = " + (acc_pref.get(0)?1:0);
        query += " and WM = " + (acc_pref.get(1)?1:0);
        query += " and MO = " + (acc_pref.get(2)?1:0);
        query += " and AC = " + (acc_pref.get(3)?1:0);
        query += " and KT = " + (acc_pref.get(4)?1:0);

        query += " and ATB = "+ (att_bath?1:0);
        
        if(loc_pref.get(0)) query += " and dist_SP <= 100";
        if(loc_pref.get(1)) query += " and dist_G <= 100";
        if(loc_pref.get(2)) query += " and dist_MG <= 100";
        
        ArrayList<Object[]> result_data = new ArrayList<Object[]>();
        ResultSet query_result = DbInterface.fetch_table(query);
        if(query_result != null){
            try{
                while(query_result.next()){
                    Object[] temp = {
                        query_result.getInt("id"),
                        query_result.getString("name"),
                        query_result.getDouble("price_per_day"),
                        query_result.getString("photo")
                    };
                    result_data.add(temp);
                }
            }catch(Exception e){
                System.out.println("Exception occured while iterating through the house search result:\n"+e);
            }
        }
        return result_data;
    }

    /**
     * This function is to fetch data for the HouseInfoWindow
     * @param house_id Id of the target house
     * @return An array list with name,price_per_day,Accessories,Location details.
     * Location details order: Swimming pool, Gym, Main Gate. Empty list if no data.
     */
    public static ArrayList<Object> get_house(int house_id){
        String query = "select * from house_record where id = "+ house_id;
        ArrayList<Object> result_data = new ArrayList<Object>();
        ResultSet query_result = DbInterface.fetch_table(query);
        try{
            result_data.add(query_result.getString("name"));
            result_data.add(query_result.getDouble("price_per_day"));

            ArrayList<String> acc = new ArrayList<>();
            if(query_result.getInt("FR") == 1) acc.add("Fridge");
            if(query_result.getInt("WM") == 1) acc.add("Washing machine");
            if(query_result.getInt("MO") == 1) acc.add("Microwave Oven");
            if(query_result.getInt("AC") == 1) acc.add("Air Conditioner");
            if(query_result.getInt("KT") == 1) acc.add("Kitchen");
            result_data.add(acc);

            Double[] distances = {
                query_result.getDouble("dist_SP"),
                query_result.getDouble("dist_G"),
                query_result.getDouble("dist_MG")
            };
            result_data.add(distances);
        }catch(Exception e){
            System.out.println("Exceptio occured in get_house(): "+e);
        }
        return result_data;
    }

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
        String query = "select * from client_record where user_name = "+user_name;
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
    // public static void main(String args[]){
    //     DbInterface.initialize();
    //     String[] data = get_user(12);
    //     if(data == null){
    //         System.out.println("There is no data!");
    //     }else{
    //         System.out.println("The user name is "+data[0]);
    //     }
    // }
}
