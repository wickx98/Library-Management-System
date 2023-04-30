package UI;

public class UIFactory {
    public static UserInterface UserInterfaceFactory(String[] args){
        UserInterface ui = null;

        if(args.length > 0 && args[0].equals("CLI")){
            ui = new CLI();
        }else{
            ui = new GUI();
        }

        return ui;
    }
}
