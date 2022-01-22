package model;

public class BillManager extends FileHandler {
    private static int bill_num = -1;
    private static String file_name = "bill_log.txt";

    public static boolean initialize(){
        if(bill_num != -1) return true;
        bill_num = init_from_file(file_name);
        return bill_num != -1;
    }

    public static int get_bill_number(){
        return ++bill_num;
    }

    public static boolean save_state(){
        if(bill_num == -1){
            System.out.println("The bill number has not been initialised");
            return false;
        }
        return save_data(bill_num, file_name);
    }

    /**
     * This function is to initialise the billManager.
     * @param args
     */
    public static void main(String args[]){
        boolean saved = save_data(123, file_name);
        if(saved) System.out.println("Initialized Bill id: 123");
        else System.out.println("Failed to intialise Bill id");
    }
}