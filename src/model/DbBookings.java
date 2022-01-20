package model;

import java.sql.ResultSet;
import java.util.*;

public class DbBookings {
    // private static int bill_no = 1234;

    /**
     * This function is to register a succesful booking in DB
     * @param house_id id of the house
     * @param num_members Number of members staing in the house
     * @param start_date String format of the date of accomodation.(dd-mm-yyyy)
     * @param end_date String formate of the date of vacation.(dd-mm-yyyy)
     * @param num_stay_days number of days of stay.
     * @param status 'confirmed' or 'cancelled'
     * @param paid Is all the money paid?
     * @param booked_by User name of te user who booked the house
     * @return True if the record was succesfully inserted in the Db, else false.
     */
    public static boolean make_booking(
        int bill_id,int house_id,int num_members,String start_date,
        String end_date,int num_stay_days,String status,
        boolean paid,int booked_by
    ){
        String query = "insert into bookings values(";

        query += String.format("'%d','%d','%d','%d','%s',",
                 bill_id,house_id,booked_by,num_members,start_date);
        query += String.format("'%s',%d,'%s',%d)",
                 end_date,num_stay_days,status,(paid?1:0));
        int result = -1;
        result = DbInterface.insert_row(query);
        return result != -1;
    }

    /**
     * This function is to get all the bookings done by a user
     * @param user_id id of the target of user.
     * @return An arraylist, with Object[] items: bill_id,house_name,num_members,house_photo,start_date,end_date,status
     * Empty arrayList is returned if there are no bookings.
     */
    public static ArrayList<Object[]> get_bookings(int user_id){
        String query = "select * from bookings where booked_by = "+user_id;
        ResultSet bill_query_result = DbInterface.fetch_table(query);
        ArrayList<Object[]> result = new ArrayList<>();
        try{
            // ArrayList<Object> house_query_result = DbHouseRecord.get_house(bill_query_result.getInt("house_id"));
            while(bill_query_result.next()){
                query = "select name,photo from house_record where id = "+bill_query_result.getInt("house_id");
                ResultSet house_query_result = DbInterface.fetch_table(query);

                if(house_query_result.next()){
                    result.add(new Object[]{
                        bill_query_result.getInt("id"),
                        // bill_query_result.getInt("house_id"),
                        house_query_result.getString("name"),
                        bill_query_result.getInt("num_members"),
                        house_query_result.getString("photo"),
                        bill_query_result.getString("start_date"),
                        bill_query_result.getString("end_date"),
                        bill_query_result.getString("status")
                    });
                }
            }
        }catch(Exception e){
            System.out.println("Exception occured in get_bookings(): "+e);
        }
        return result;
    }

    public static boolean cancel_booking(int bill_id,boolean is_expired){
        String query = "select * from bookings where id = "+bill_id;
        ResultSet result_data = DbInterface.fetch_table(query);
        try{
            if(result_data.next()){
                int target_house_id = result_data.getInt("house_id");
                boolean is_freed = DbHouseRecord.free_house(target_house_id);

                if(is_expired) query = "update bookings set status = 'expired' where id = "+bill_id;
                else query = "update bookings set status = 'cancelled' where id = "+bill_id;
                int changed = DbInterface.update_row(query);
                return (is_freed && changed == 1);
            }
        }catch(Exception e){
            System.out.println("Exception occured in cancel_booking(): "+e);
        }
        return false;
    }

    /**
     * To get the details of the booking:
     * @param bill_id Target bill id.
     * @return The Object[] with elements in order: house_id,booked_by,num_members,
     * start_date,end_date,num_days,status,paid.
     */
    public static Object[] get_details(int bill_id){
        Object[] result = null;
        String query = "select * from bookings where id = "+bill_id;
        ResultSet query_result = DbInterface.fetch_table(query);
        try{
            if(query_result.next()){
                result = new Object[]{
                    query_result.getString("house_id"),
                    query_result.getInt("booked_by"),
                    query_result.getInt("num_members"),
                    query_result.getString("start_date"),
                    query_result.getString("end_date"),
                    query_result.getInt("num_days"),
                    query_result.getString("status"),
                    query_result.getInt("paid")
                };
            }
        }catch(Exception e){
            System.out.println("Exception in DbBookings -> get_details(): "+e);
        }
        return result;
    }
}
