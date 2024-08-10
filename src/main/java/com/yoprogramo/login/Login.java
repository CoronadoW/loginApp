package com.yoprogramo.login;

import com.yoprogramo.login.igu.MainLogin;
import com.yoprogramo.login.logica.Controladora;
import com.yoprogramo.login.logica.Utility;
import com.yoprogramo.login.persistencia.ControladoraPersistencia;

public class Login {

    public static void main(String[] args) {
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        Utility utility = new Utility();
        Controladora control = new Controladora(controlPersis, utility);
        
        
        MainLogin mainLogin = new MainLogin(control, utility);
        mainLogin.setVisible(true);
        mainLogin.setLocationRelativeTo(null);

    }
}
