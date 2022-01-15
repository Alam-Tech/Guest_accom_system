package controller;

import java.util.*;

import model.DbCreditCard;
import model.DbHouseRecord;
import views.PaymentWindow;

public class PaymentController {

    public static void fill_details(PaymentWindow target,int house_id){
        ArrayList<Object> house_data = DbHouseRecord.get_house(house_id);
        if(house_data.isEmpty()) System.out.println("The house with house id: "+house_id+" does not exist!");
        else target.pay_button.setText(String.format("Pay Rs.%.2f",house_data.get(1)));
    }
    
    public static int handle_payment(PaymentWindow target){
        String cred_card_number = target.card_num_input.getText();
        String cvv = target.cvv_input.getText();
        String card_type = (String)target.credit_card_choose.getSelectedItem();
        
        Object[] details = DbCreditCard.get_credit_card_detail(card_type, cred_card_number);
        
        //Checking if the cvv is correct:
        if(!cvv.equals(details[0])) return 1;
        //Checking if the date is correct:

        return 200;
    }
}
