import model.DbInterface;
import model.UserIdManager;
import model.BillManager;
import views.LoginWindow;

public class App {
    public static void main(String[] args) throws Exception {
        boolean db_connected = DbInterface.initialize();
        boolean bill_manager_connected = BillManager.initialize();
        boolean user_id_manager_connected = UserIdManager.initialize();
        if(!db_connected) System.out.println("DB Initialisation failed!");
        else if(!bill_manager_connected) System.out.println("Bill Manager intiialisation failed!");
        else if(!user_id_manager_connected) System.out.println("User Id manager initialisation failed!");
        else{
            LoginWindow login_win = new LoginWindow();
        }
    }
}
