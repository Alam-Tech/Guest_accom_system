package controller;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.DbBookings;
import model.DbClient;
import model.DbHouseRecord;
import model.DbPayment;
import views.OrderInfoWindow;

public class OrderInfoController {
    public void fill_details(OrderInfoWindow target,int bill_id){
        Object[] bill_details = DbBookings.get_details(bill_id);
        ArrayList<Object> house_details = DbHouseRecord.get_house((Integer)bill_details[0]);
        Object[] user_details = DbClient.get_user((Integer)bill_details[1]);
        Object[] payment_details = DbPayment.get_details(bill_id, (Integer)bill_details[1]);

        target.House_name.setText((String)house_details.get(0));
        target.User_name.setText((String)user_details[0]);
        target.Occupant_count.setText("No. of Occupants: "+bill_details[2]);
        target.date_range.setText("Period of stay: "+bill_details[3]+" to "+bill_details[4]);
        target.Day_count.setText("No.of days of stay: "+bill_details[5]);
        target.Amt_paid.setText("Amount Paid: "+payment_details[1]);
        target.CCnum.setText("Credit Card Number: "+payment_details[0]);
        target.Date_paid.setText("Paid on: "+payment_details[2]);
        try{
            BufferedImage house_pic = ImageIO.read(new File("src\\util\\images\\"+house_details.get(4)));
            target.house_image.setIcon(new ImageIcon(house_pic));
            target.house_image.setText("House pic");
        }catch(Exception e){
            target.house_image.setText("Image Unavailable");
        }

    }
}
