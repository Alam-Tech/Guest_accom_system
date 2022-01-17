package model;

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

        query += String.format("'%d','%d','%d','%d',to_date('%s','dd-mm-yyyy'),",
                 bill_id,house_id,booked_by,num_members,start_date);
        query += String.format("to_date('%s','dd-mm-yyyy'),%d,'%s',%d)",
                 end_date,num_stay_days,status,(paid?1:0));
        int result = -1;
        result = DbInterface.insert_row(query);
        return result != -1;
    }    
}
