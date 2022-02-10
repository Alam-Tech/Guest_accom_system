package controller;

import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;

import model.DbHouseRecord;
import views.HouseInfoWindow;

public class HouseInfoController {
    public static void fill_details(HouseInfoWindow target,int house_id){
        ArrayList<Object> details = DbHouseRecord.get_house(house_id);
        
        try{
            target.myPicture = ImageIO.read(new File("src\\util\\images\\"+details.get(4)));
            target.house_image.setIcon(new javax.swing.ImageIcon(target.myPicture)); // NOI18N
            target.house_image.setText("House pic");
        }catch(Exception e) {target.house_image.setText("Image Unavailable");}
        
        target.house_name.setText((String)details.get(0));
        target.house_rate.setText("Rs." + details.get(1) + " per day");
        for(String acc : (ArrayList<String>)details.get(2)){
            target.AccessoryList.append(" "+acc+"\n\n");
        }
        target.Distances_list.append(" Distance from Swimming pool: "+((Integer[])details.get(3))[0]+"m\n");
        target.Distances_list.append(" Distance from Gym: "+((Integer[])details.get(3))[1]+"m\n");
        target.Distances_list.append(" Distance from Main Gate: "+((Integer[])details.get(3))[2]+"m\n");
    }
}
