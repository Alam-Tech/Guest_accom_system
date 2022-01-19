package controller;

import model.DbBookings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class AfterLoginController {
    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * To get the list of active bookings made by the user.
     * @param user_id target user_id
     * @return arraylist with the details in the order:bill_id,house_name,num_members,house_photo,start_date,end_date,status.
     * Empty list if there is no data.
     */
    public ArrayList<Object[]> get_active_bookings(int user_id){
        ArrayList<Object[]> result;
        result = DbBookings.get_bookings(user_id);
        ArrayList<Object[]> refined_result = new ArrayList<>();
        
        // String today = formatter.format(new Date());
        for(Object[] element:result){
            if(element[6].equals("confirmed")) refined_result.add(element);
            // if(compare_dates(today, (String)element[5]) < 1) refined_result.add(element);
        }
        return refined_result;
    } 

    /**
     * To get the list of the previous bookings of the user
     * @param user_id user_id of the target user
     * @return An ArrayList of Object[] with data order: bill_id,house_name,num_members,house_photo,start_date,end_date,status.
     * Empty arrayList returned if there are no items
     */
    public ArrayList<Object[]> get_previous_bookings(int user_id){
        ArrayList<Object[]> result;
        result = DbBookings.get_bookings(user_id);
        ArrayList<Object[]> refined_result = new ArrayList<>();
        
        // String today = formatter.format(new Date());
        for(Object[] element:result){
            if(element[6].equals("expired") || element[6].equals("cancelled")) refined_result.add(element);
            // if(compare_dates(today, (String)element[5]) == 1) refined_result.add(element);
        }
        return refined_result;
    }
}
