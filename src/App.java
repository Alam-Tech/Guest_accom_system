import model.DbInterface;
import model.BillManager;
import views.LoginWindow;

public class App {
    public static void main(String[] args) throws Exception {
        boolean db_connected = DbInterface.initialize();
        boolean bill_manager_connected = BillManager.initialize();
        if(!db_connected) System.out.println("DB Initialisation failed!");
        else if(!bill_manager_connected) System.out.println("Bill Manager intiialisation failed!");
        else{
            LoginWindow login_win = new LoginWindow();
        }
    }
}
