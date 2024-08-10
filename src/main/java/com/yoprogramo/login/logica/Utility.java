
package com.yoprogramo.login.logica;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Utility {
    
    public void showMessage(String message, String tipo, String titulo){
        JOptionPane optionPane = new JOptionPane(message);
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }else if( tipo.equals("Error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);       
        
    }
}
