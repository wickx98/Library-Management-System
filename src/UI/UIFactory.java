package UI;

public class UIFactory {
    public static UserInterface UserInterfaceFactory(String[] args){
        UserInterface ui = null;

        if(args[0].equals("CLI")){
            ui = new CLI();
        }else{
            ui = new GUI();
        }

        return ui;
    }
}
