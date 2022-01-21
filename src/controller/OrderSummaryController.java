package controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;

import model.DbClient;
import model.DbHouseRecord;
import model.OrderInfo;
import views.OrderSummaryWindow;

public class OrderSummaryController {
    public static void fill_details(
        OrderSummaryWindow target,int user_id,
        int house_id,OrderInfo order_info
    ){
        ArrayList<Object> house_details = DbHouseRecord.get_house(house_id);
        String[] user_details = DbClient.get_user(user_id);
        
        try{
            target.myPicture = ImageIO.read(new File("src\\util\\images\\"+house_details.get(4)));
            target.house_image.setIcon(new javax.swing.ImageIcon(target.myPicture)); // NOI18N
            target.house_image.setText("House pic");
        }catch(Exception e) {
            System.out.println("Image not available");
            target.house_image.setText("Image Unavailable");
        }
        //house_image.setText("jLabel1");
        //target.myPicture.se

        target.house_name.setText((String)house_details.get(0));
        target.Price.setText("Cost per day: Rs."+house_details.get(1));
        
        DateFormat date_formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = date_formatter.format(order_info.date_of_accomodation);
        target.accom_date.setText("Date of accomodation: "+date);

        target.days_of_stay.setText("No.of Days of Stay: "+Integer.toString(order_info.num_days_of_stay));
        target.ppl_count.setText("Number of people: "+Integer.toString(order_info.num_people));

        date_formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        String current_datetime = date_formatter.format(new Date());
        target.booking_date.setText("Date of booking: "+current_datetime);

        target.booked_by_label.setText("Booked by: "+user_details[0]);
    }
}
