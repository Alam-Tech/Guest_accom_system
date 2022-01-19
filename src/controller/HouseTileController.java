package controller;

import model.DbBookings;
import views.popups.ConfirmCancel;

public class HouseTileController {
    public int handle_cancel(ConfirmCancel popup,int bill_id){
        if(popup.Choice.equals("yes")){
            boolean cancelled = DbBookings.cancel_booking(bill_id, false);
            return cancelled?1:-1;
        }else return 0;
    }    
}
