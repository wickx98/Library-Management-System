package UI;

import javax.swing.*;
import java.awt.*;

public class MessageBox extends Frame {
        MessageBox(){

        }
        MessageBox(String message){
            setSize(200,200);
            setVisible(false);
            setLocationRelativeTo(null);
            JOptionPane.showMessageDialog(this,message,"Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }
