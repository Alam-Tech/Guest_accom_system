package controller;

import views.Bookaroom;
import model.DbHouseRecord;
import model.OrderInfo;

import java.util.*;

public class BookaroomController {
    
    public static ArrayList<Object[]> search(Bookaroom target){
        int num_people = Integer.parseInt((String)target.num_people.getSelectedItem());
        int num_rooms;
        num_rooms = num_people / 2;
        if(num_people % 2 != 0) num_rooms += 1;

        boolean is_elite = target.house_type.getSelection()
                       .getActionCommand().equals("elite");
        
        ArrayList<Boolean> acc_pref = new ArrayList<Boolean>();
        acc_pref.add(target.fridge.isSelected());
        acc_pref.add(target.washing_machine.isSelected());
        acc_pref.add(target.oven.isSelected());
        acc_pref.add(target.ac.isSelected());
        acc_pref.add(target.kitchen.isSelected());

        boolean att_bath = target.attach_bath.getSelection()
                           .getActionCommand().equals("yes");
        
        ArrayList<Boolean> loc_pref = new ArrayList<Boolean>();
        loc_pref.add(target.swimming_pool.isSelected());
        loc_pref.add(target.gym.isSelected());
        loc_pref.add(target.main_gate.isSelected());

        ArrayList<Object[]> search_results;
        search_results = DbHouseRecord.search_houses(num_rooms, is_elite, acc_pref, att_bath, loc_pref);
        return search_results;
    }

    public static OrderInfo get_order_info(Bookaroom target){
        OrderInfo info = new OrderInfo();
        info.num_days_of_stay = Integer.parseInt((String)target.days.getSelectedItem());
        info.num_people = Integer.parseInt((String)target.num_people.getSelectedItem());
        info.date_of_accomodation =(Date)target.datePicker.getModel().getValue();
        return info;
    }    
}
