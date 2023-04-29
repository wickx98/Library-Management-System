import Storage.InMemoryBookStorage;
import Store.Book;
import Store.Library;
import UI.CLI;
import UI.GUI;
import UI.UIFactory;
import UI.UserInterface;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {


            UserInterface ui = UIFactory.UserInterfaceFactory(args);
            ui.start();

        }



    }
















