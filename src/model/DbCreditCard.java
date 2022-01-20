package model;

import java.sql.*;

public class DbCreditCard {
    /**
     * This function is to fetch data to validate the credit card credentials.
     * @param card_num 16- digit credit card number
     * @return An object array with cvv(String),expiry(Date),balance(double).
     * Null is returned if no data/ error.
     */
    public static Object[] get_credit_card_detail(String card_num){
        String query = "select * from credit_card_record where card_number = '"+card_num+"'";
        ResultSet query_result = DbInterface.fetch_table(query);
        Object[] result_data = null;
        try{
            if(query_result.next()){
                result_data = new Object[]{
                    query_result.getString("cvv"),
                    query_result.getDate("expiry"),
                    query_result.getDouble("balance")
                };
            }
        }catch(Exception e){
            System.out.println("Exception occured in get_credit_card_detail(): "+e);
        }
        return result_data;
    }

    /**
     * This funciton is to update the credit card balance of a given card number
     * @param card_number The credit card number of the target card.
     * @param new_amount The new amount to be set.
     * @return if 1 (no.of rows updated) recieved, success, else failure.
     */
    public static int update_balance(String card_number,double new_amount){
        String query = "update credit_card_record set balance = "+new_amount;
        query += " where card_number = '"+card_number+"'";
        return DbInterface.update_row(query);
    }
}
