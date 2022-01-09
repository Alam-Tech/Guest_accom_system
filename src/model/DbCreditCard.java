package model;

import java.sql.*;

public class DbCreditCard {
    /**
     * This function is to fetch data to validate the credit card credentials.
     * @param card_type Company of credit card Ex: VISA, MasterCard
     * @param card_num 16- digit credit card number
     * @return An object array with cvv(String) and expiry(Date).
     * Null is returned if no data/ error.
     */
    public static Object[] get_credit_card_detail(String card_type,String card_num){
        String query = "select * from credit_card_record where type = "+card_type+" and number = "+card_num;
        ResultSet query_result = DbInterface.fetch_table(query);
        Object[] result_data = null;
        try{
            if(query_result.next()){
                result_data = new Object[]{
                    query_result.getString("cvv"),
                    query_result.getDate("expiry")
                };
            }
        }catch(Exception e){
            System.out.println("Exception occured in get_credit_card_detail(): "+e);
        }
        return result_data;
    }
}
