package controller;

import java.text.SimpleDateFormat;
import java.util.*;

import model.DbBookings;
import model.DbCreditCard;
import model.DbInterface;
import model.DbPayment;
import views.popups.ConfirmCancel;

public class HouseTileController {
    /**
     * This function is to handle the cancel functionality 
     * @param popup
     * @param bill_id
     * @return Returns integer based on the result obtained:
     * 0 - User didn't choose to cancel the booking.
     * 1 - Booking record doesn't exist.
     * 2 - The booking period has already started
     * 3 - The user's payment record doesn't exist.
     * 4 - Amount not refunded properly.
     * 5 - Refund transaction not registered in the record!
     * 6 - The cancellation was succesful and the amount was refunded!
     */
    public int handle_cancel(ConfirmCancel popup,int bill_id){
        if(popup.Choice.equals("yes")){
            Object[] bill_details = DbBookings.get_details(bill_id);
            if(bill_details == null) return 1;
    
            String start_date = (String)bill_details[3];
            String current_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            if(DbInterface.compare_dates(start_date, current_date) == -1) return 2;

            boolean cancelled = DbBookings.cancel_booking(bill_id, false);
            if(cancelled){
                int target_user = (Integer)bill_details[1];
                Object[] payment_details = DbPayment.get_details(bill_id, target_user);
                if(payment_details == null) return 3;
                
                double paid_amount = (double)payment_details[1];
                String card_number = (String)payment_details[0];
                Object[] account_details = DbCreditCard.get_credit_card_detail(card_number);
                double current_balance = (double)account_details[2];
                
                int balance_updated = DbCreditCard.update_balance(card_number, current_balance + paid_amount);

                String current_timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
                boolean refund_register = DbPayment.register_payment(bill_id, 500, "123456789",
                paid_amount, current_timestamp);

                if(balance_updated != 1) return 4;
                if(!refund_register) return 5;
                return 6;
            }
        } 
        return 0;
    }    
}
