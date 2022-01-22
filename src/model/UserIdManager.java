package model;

public class UserIdManager extends FileHandler{
    private static String file_name = "userId_log.txt";
    private static int user_id = -1;

    public static boolean initialize(){
        if(user_id != -1) return true;
        user_id = init_from_file(file_name);
        return user_id != -1;
    }

    public static int get_user_id(){
        return ++user_id;
    }

    public static boolean save_state(){
        if(user_id == -1){
            System.out.println("The User id has not been initialised");
            return false;
        }
        return save_data(user_id, file_name);
    }

    public static void main(String args[]){
        boolean saved = save_data(1, file_name);
        if(saved) System.out.println("Initialized User id: 1");
        else System.out.println("Failed to intialise Bill id");
    }
}
