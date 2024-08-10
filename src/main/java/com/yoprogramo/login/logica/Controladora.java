
package com.yoprogramo.login.logica;

import com.yoprogramo.login.igu.AdminWindow;
import com.yoprogramo.login.igu.UserWindow;
import com.yoprogramo.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis;
    Utility utility;
    Rol realRole = null;
    String adminUserName = null;
    String userName = null;

    public Controladora(ControladoraPersistencia controlPersis, Utility utility) {
        this.controlPersis = controlPersis;
        this.utility = utility;
        
    }

    public List<Usuario> getUsersList() {
        return controlPersis.getUsersList();
    }

    public void signIn(String user, String password) {
        List<Usuario> usersList = controlPersis.getUsersList();
        boolean correctUser = false;
        for (Usuario usu : usersList) {
            if (usu.getNombreUsuario().equalsIgnoreCase(user)) {
                if (usu.getContrasenia().equals(password)) {
                    correctUser = true;
                    if (usu.getRol().getId() == 1) {
                        adminUserName = usu.getNombreUsuario();
                        showAdmin(); 
                        
                    } else {
                        userName = usu.getNombreUsuario();
                        showUser();
                        
                    }
                } else {
                    utility.showMessage("Contraseña incorrecta", "Error", "Error de contraseña");
                }
            }
        }
        if (correctUser == false) {
            utility.showMessage("Debe ingresar un usuario valido", "Error", "Error");
        }
    }

    public void createUser(String userName, String password, String roleName) {
        Usuario user = new Usuario();
        Rol role = getRole(roleName);
        user.setNombreUsuario(userName);
        user.setContrasenia(password);
        user.setRol(role);
        if (role != null) {
            if (role.getNombreRol().equalsIgnoreCase("Admin")) {                
                controlPersis.createUser(user);
                utility.showMessage("User type 'Admin' created correctly", "Info", "Creation successfully");
                showAdmin();
            } else {                
                controlPersis.createUser(user);                
                utility.showMessage("User type 'User' created correctly", "Info", "Creation successfully");
                showUser();
            }
        } else {
            utility.showMessage("You must enter a valid user type", "Error", "Error entering user type"); 
            showAdmin();
        }
    }

    public Rol getRole(String roleName) {
        List<Rol> rolesList = controlPersis.getRolesList();
        for (Rol role : rolesList) {
            if (role.getNombreRol().equals(roleName)) {
                realRole = role;
                break;
            }
        }
        return realRole;
    }

    public void showAdmin() {
        AdminWindow adminW = new AdminWindow(this, utility);
        adminW.setVisible(true);
        adminW.setLocationRelativeTo(null);
        adminW.loadAdminUserName(adminUserName);
    }

    public void showUser() {
        UserWindow userW = new UserWindow(this);
        userW.setVisible(true);
        userW.setLocationRelativeTo(null);
        userW.loadUserName(userName);
    }
    
    public void deleteUser(int userId) {
        controlPersis.deleteUser(userId);
    }
    
    public Usuario getUserById(int editableUserId){
        Usuario editableUser = null;
        List<Usuario> usersList = controlPersis.getUsersList();
        for (Usuario user : usersList) {
            if(editableUserId == user.getId()){
               editableUser = user; 
            }
        }
        return editableUser;
    }

    public void editUser(int userId, String userName, String password, String roleName) {
        Usuario user = getUserById(userId);
        Rol role = getRole(roleName);
        user.setNombreUsuario(userName);
        user.setContrasenia(password);
        user.setRol(role);
        if(!userName.equalsIgnoreCase("")){
            if(!password.equalsIgnoreCase("")){
                if(role != null){
                    controlPersis.editUser(user);
                    utility.showMessage("User edited successfully", "Info", "User edition");
                    showAdmin();
                }else{
                    utility.showMessage("You must enter a valid role", "Error", "Error entering role");
                    showAdmin();
                }
            }else{
                utility.showMessage("You must enter a password", "Error", "Error entering password");
                showAdmin();
            }
        }else{
            utility.showMessage("You must enter a user name", "Error", "Error entering user name");
            showAdmin();
        }              
    }
    
    

}
