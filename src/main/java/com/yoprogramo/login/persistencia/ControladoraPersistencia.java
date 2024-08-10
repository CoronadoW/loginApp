
package com.yoprogramo.login.persistencia;

import com.yoprogramo.login.logica.Rol;
import com.yoprogramo.login.logica.Usuario;
import com.yoprogramo.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    RolJpaController rolJpa = new RolJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    public List<Usuario> getUsersList() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void createUser(Usuario user) {
        usuarioJpa.create(user);        
    }

    public List<Rol> getRolesList() {
        return rolJpa.findRolEntities();
    }

    public void deleteUser(int userId)  {
        try {
            usuarioJpa.destroy(userId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editUser(Usuario user) {
        try {
            usuarioJpa.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
