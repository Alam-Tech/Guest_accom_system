package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import model.BillManager;
import model.DbBookings;
import model.DbCreditCard;
import model.DbHouseRecord;
import model.OrderInfo;
import views.PaymentWindow;

public class PaymentController {
    private static double amount;
    public static void fill_details(PaymentWindow target,int house_id){
        ArrayList<Object> house_data = DbHouseRecord.get_house(house_id);
        if(house_data.isEmpty()) System.out.println("The house with house id: "+house_id+" does not exist!");
        else {
            target.pay_button.setText(String.format("Pay Rs.%.2f",house_data.get(1)));
            amount = (Double)house_data.get(1);
        }
    }
    
    /**
     * This function is to process the payment and update the db.
     * @param target
     * @return 200 - success and the db is updated, romm is booked
     * 1 - credit card doesn't exist
     * 2 - cvv is invalid
     * 3 - expiry date doesn't match
     * 4 - Bank balance not sufficient
     * 5 - Some error occured while updating the DB
     */
    public static int handle_payment(PaymentWindow target,int house_id,int user_id,OrderInfo order_info){
        String cred_card_number = target.card_num_input.getText();
        String cvv = target.cvv_input.getText();
        String card_type = (String)target.credit_card_choose.getSelectedItem();
        Date expiry_date = (Date)target.datePicker.getModel().getValue();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        Object[] details = DbCreditCard.get_credit_card_detail(card_type, cred_card_number);
        
        //If such a credit card doesn't exist:
        if(details == null) return 1;
        //Checking if the cvv is correct:
        if(!cvv.equals(details[0])) return 2;
        //Checking if the date is correct:
        String str_expiry_date = formatter.format(expiry_date);
        System.out.println("The str version of expiry date: "+str_expiry_date);
        System.out.println("The str version of date obtained from db: "+formatter.format(details[1]));
        if(!str_expiry_date.equals(formatter.format(details[1]))) return 3;
        //If not enough balance:
        if((double)details[2] < amount) return 4;

        int result = DbCreditCard.update_balance(cred_card_number, (double)details[2]-amount);
        int bill_num = BillManager.get_bill_number();
        if(result == 1){
            //Transaction succesful
            String start_date = formatter.format(order_info.date_of_accomodation);
            Calendar cal = Calendar.getInstance();
            cal.setTime(order_info.date_of_accomodation);
            cal.add(Calendar.DATE,order_info.num_days_of_stay);
            String end_date = formatter.format(cal.getTime());
            System.out.println("The start date: "+start_date);
            System.out.println("The end date: "+end_date);

            boolean booked = DbBookings.make_booking(bill_num, house_id, order_info.num_people,
             start_date, end_date, order_info.num_days_of_stay, 
             "confirmed", true, user_id);
            if(!booked) return 5;
        }else return 5; 
        BillManager.save_state();
        return bill_num;
    }
}
