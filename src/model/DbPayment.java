package model;

import java.sql.*;

public class DbPayment {
    /**
     * This function is to enter a payment record in the database.
     * @param bill_id The bill id.
     * @param user_id The user id of the user who payed the bill. 
     * @param card_number The credit card number of the user.
     * @param amount The amount involved in the transaction.
     * @param datetime The date and time in the format: "dd-MM-yyyy HH:mm:ss"
     * @return True if succesfully entered in the DB, otherwise false
     */
    public static boolean register_payment(int bill_id,int user_id,String card_number,
                                        double amount,String datetime){
        String query = String.format("insert into payment_record values(%d,%d,'%s',%f,'%s')",
                                     bill_id,user_id,card_number,amount,datetime); 

        int result = DbInterface.insert_row(query);
        return result == 1; 
    }

    /**
     * This function is to get the details of a payment made during the booking process
     * @param bill_id The target bill id.
     * @param user_id The id of the user who made the payment
     * @return Object[] with data in order: credit_card_number,amount,date_of_payment(String)
     * Null is returned if error/(no data)
     */
    public static Object[] get_details(int bill_id,int user_id){
        Object[] result = null;
        String query = String.format("select * from payment_record where bill_id = '%s' and user_id = '%s'",bill_id,user_id);
        ResultSet query_result = DbInterface.fetch_table(query);
        try{
            if(query_result.next()){
                result = new Object[]{
                    query_result.getString("payed_with"),
                    query_result.getDouble("amount"),
                    query_result.getString("payed_on")
                };
            }
        }catch(Exception e){
            System.out.println("Exception occured in DbPayment -> get_details(): "+e);
        }
        return result;
    }
}
