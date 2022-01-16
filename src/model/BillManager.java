package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BillManager {
    private static int bill_num = -1;

    public static boolean initialize(){
        if(bill_num != -1) return false;
        try{
            FileInputStream in = new FileInputStream("bill_log.txt");
            ObjectInputStream reader = new ObjectInputStream(in);
            bill_num = reader.readInt();
            reader.close();
            in.close();
            return true;
        }catch(Exception e){
            System.out.println("Exception in initialize(): "+e);
        }
        return false;
    }

    public static int get_bill_number(){
        return ++bill_num;
    }

    public static boolean save_state(){
        if(bill_num == -1){
            System.out.println("The bill number has not been initialised");
            return false;
        }
        try{
            FileOutputStream out = new FileOutputStream("bill_log.txt");
            ObjectOutputStream writer = new ObjectOutputStream(out);
            writer.writeInt(bill_num);
            writer.close();
            out.close();
            return true;
        }catch(Exception e){
            System.out.println("Exception occured in save_state(): "+e);
        }
        return false;
    }

    /**
     * This function is to initialise the billManager.
     * @param args
     */
    public static void main(String args[]){
        try{
            FileOutputStream out = new FileOutputStream("bill_log.txt");
            ObjectOutputStream writer = new ObjectOutputStream(out);
            writer.writeInt(123);
            writer.close();
            out.close();
        }catch(Exception e){ 
            System.out.println("Exception occured while writing to log file: "+e);
        }
    }
}