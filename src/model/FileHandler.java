package model;

import java.io.*;

class FileHandler {
    private static String log_path = "src\\util\\log\\";
    protected static int init_from_file(String file_name){
        int saved_data = -1;
        try{
            FileInputStream in = new FileInputStream(log_path + file_name);
            ObjectInputStream reader = new ObjectInputStream(in);
            saved_data = reader.readInt();
            reader.close();
            in.close();
        }catch(Exception e){
            System.out.println("Exception occured when trying to read "+file_name+": "+e);
        }
        return saved_data;
    }

    protected static boolean save_data(int data,String file_name){
        try{
            FileOutputStream out = new FileOutputStream(log_path + file_name);
            ObjectOutputStream writer = new ObjectOutputStream(out);
            writer.writeInt(data);
            writer.close();
            out.close();
            return true;
        }catch(Exception e){
            System.out.println("Exception occured when trying to write to "+file_name+": "+e);
        }
        return false;
    }
}
